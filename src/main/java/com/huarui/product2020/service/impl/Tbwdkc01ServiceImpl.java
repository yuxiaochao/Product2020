package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.binarywang.java.emoji.EmojiConverter;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.RedisUtil;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.*;
import com.huarui.product2020.entity.base.StudyMgdbUserProgessEntity;
import com.huarui.product2020.entity.vo.SectionVO;
import com.huarui.product2020.mapper.Tbwdkc01Mapper;
import com.huarui.product2020.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author su
 * @since 2020-02-13
 */
@Service
public class Tbwdkc01ServiceImpl extends ServiceImpl<Tbwdkc01Mapper, Tbwdkc01> implements ITbwdkc01Service {

    private static Logger logger = LoggerFactory.getLogger(Tbwdkc01ServiceImpl.class);

    @Autowired
    private IHrswTCoursewareService hrswTCoursewareService;

    @Autowired
    private AppLearningMongoDbService appLearningMongoDbService;
    /**
     * 课程的章节学习结果表tbLCWR01
     */
    @Autowired
    private ITblcwr01Service tblcwr01Service;
    /**
     * 学员学习课程结果表tbLERE01
     */
    @Autowired
    private ITblere01Service tblere01Service;
    
    @Autowired
    private RedisUtil redisService;

    private static EmojiConverter emojiConverter = EmojiConverter.getInstance();

    /**
     * 查询我的课程——套包list
     */
    @Override
    public List<Tbwdkc01> findbyCoursePackageList(Tbwdkc01 tbwdkc01) {
    	String wdkc0104 = tbwdkc01.getWdkc0104();// 用户id
    	String cmdy0303 = tbwdkc01.getCmdy0303();// 专业id
    	List<Tbwdkc01> list = new ArrayList<Tbwdkc01>();
    	String redisKey = "coursePackageList_" + wdkc0104 + "_" + cmdy0303;
    	if(!redisService.exists(redisKey)) {
    		//查询我的课程——套包list
    		List<Tbwdkc01> list02 = baseMapper.findbyCoursePackageList(tbwdkc01);
    		
    		for (Tbwdkc01 tbwdkc012 : list02) {
    			boolean flag = false;
    			List<Tbwdkc02> tbwdkc02List = tbwdkc012.getWdkc02List();
                for(Tbwdkc02 thisTbwdkc02 : tbwdkc02List) {
                	if(thisTbwdkc02 != null && 
                			(!"890".equals(thisTbwdkc02.getWdkc0203())  //不等于  “全真模拟中药学套包”
                					&& !"1119".equals(thisTbwdkc02.getWdkc0203())  // 不等于  “2019模拟考场中药学”
        					)
        			) {
                		flag = true;
    				}
                }
                if(flag) {
                	list.add(tbwdkc012);
                }
			}
    		
    		redisService.setListCache(redisKey, (List)list, RedisUtil.SerializerMode.SERIALIZATION, TimeUnit.MINUTES.toSeconds(30));
    	}else {
    		list = (List)redisService.lget(redisKey);
    	}

        //查询用户课程进度
        List<Tblere01> tblere01List = tblere01Service.selectUserProgressCourse(wdkc0104);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Tbwdkc01 thisTbwdkc01 : list) {
            List<Tbwdkc02> tbwdkc02List = thisTbwdkc01.getWdkc02List();
            for(Tbwdkc02 thisTbwdkc02 : tbwdkc02List) {
                String wdkc0201 = thisTbwdkc02.getWdkc0201();// 我的商品表
                String cmdy0503 = thisTbwdkc02.getCmdy0503();// 	课程ID
                for(Tblere01 thisTblere01 : tblere01List) {
                    if(thisTblere01.getLere0102() != null && thisTblere01.getLere0102().equals(cmdy0503) // 	课程ID
                            && thisTblere01.getLere0109() != null && thisTblere01.getLere0109().equals(wdkc0201) // 我的商品表主键
                    ) {
                        Date lere0110 = thisTblere01.getLere0110();
                        Double lere0105 = thisTblere01.getLere0105();
                        if(lere0110 != null) {
                            thisTbwdkc02.setLere0110(sdf.format(lere0110));//	上次学习时间
                        }
                        if(lere0105 != null) {
                            thisTbwdkc02.setLere0105(lere0105.intValue());//	学习进度
                        }
                    }
                }
            }
        }
    	
        return list;
    }

    @Override
    public String addCoursePackage(Map param) {
        baseMapper.addCoursePackage(param);
        return "SUCCESS";
    }

    @Override
    public Map<String, String> findbyCourseInformation(String wdkc0201, String cmdy0503) {
        Map map = new HashMap();
        map.put("wdkc0201", wdkc0201);
        map.put("cmdy0503", cmdy0503);
        Map courseInfo = baseMapper.findbyCourseInformation(map);
        if (courseInfo != null) {
            String lcwr0105 = Objects.toString(courseInfo.get("LCWR0105"), "-1");//章节id
            String lere0103 = Objects.toString(courseInfo.get("LERE0103"), "-1");//用户ID
            String lere0101 = Objects.toString(courseInfo.get("LERE0101"), "-1");//	课程结果表id
            if (lcwr0105 != null && lcwr0105.equals("-1")) {//章节id等于-1,即为没有播放记录，查询该课程的第一章节的课件
                String cour001 = Objects.toString(courseInfo.get("COUR001"), "-1");//课程id
                List<Map<String, String>> maps = hrswTCoursewareService.findbyCourseFirstSectionList(cour001);
                if (maps != null && maps.size() >= 1) {
                    Map<String, String> courseMap = maps.get(0);
                    String ccwe001 = courseMap.get("CCWE001");//当前播放章节id
                    courseInfo.put("LCWR0105", ccwe001);//当前播放章节id
                    courseInfo.put("COUR006", courseMap.get("COUR006"));//当前播放章节的课件路径
                    courseInfo.put("CCWE008", courseMap.get("CCWE008"));//非当前课件学习页面自动停止播放和计时：0、否 1、是
                    courseInfo.put("CCWE009", courseMap.get("CCWE009"));//首次学习时允许拖拽：1、不允许 0、允许

                    // 更新当前章节“课程的章节学习结果表tbLCWR01”是否最后观看的章节 为1.是
                    Tblcwr01 t = new Tblcwr01();
                    t.setLcwr0111(0d); // 是否更新完成 （0未更新 1已更新）
                    t.setLcwr0112(1d); // 是否最后观看的章节 0.否 1.是
                    t.setLcwr0113(new Date());
                    EntityWrapper<Tblcwr01> ew = new EntityWrapper<Tblcwr01>();
                    ew.where(" LCWR0104 = {0} and LCWR0102 = {1} and LCWR0103 = {2} and LCWR0105 = {3} ", lere0101, cmdy0503, lere0103, ccwe001);
                    int i1 = tblcwr01Service.selectCount(ew);
                    if(i1 >= 1){
                        tblcwr01Service.update(t, ew);
                    }else{
                        t.setLcwr0104(lere0101);
                        t.setLcwr0102(cour001);
                        t.setLcwr0103(lere0103);
                        t.setLcwr0105(ccwe001);
                        tblcwr01Service.insertOrUpdate(t);
                    }
                }
                courseInfo.put("UPRO005", 0);//当前播放章节位置（秒）

            }else{
                //查询MongoDB该章节课件播放位置（秒）
                Map map02 = new HashMap();
                map02.put("upro003", lere0103);/* 用户ID*/
                map02.put("upro002", lere0101);/* 学习课程结果表id*/
                map02.put("upro004", lcwr0105); /* 章节ID */
                StudyMgdbUserProgessEntity studyMgdbUserProgessEntity = appLearningMongoDbService.findeOnePlayCache(map02);
                if(studyMgdbUserProgessEntity != null) {
                    int upro005 = studyMgdbUserProgessEntity.getUpro005();
                    courseInfo.put("UPRO005", upro005);//当前播放章节位置（秒）
                }else{
                    courseInfo.put("UPRO005", 0);//当前播放章节位置（秒）
                }
            }

            String ccwe001 = Objects.toString(courseInfo.get("LCWR0105"), "");//章节id
            map.put("ccwe001", ccwe001);
            Map<String, String> stringStringMap = baseMapper.findbyCourseNumber(map);
            courseInfo.putAll(stringStringMap);
        }


        return courseInfo;
    }

    @Override
    public List<SectionVO> findbyCourseSectionList(String wdkc0201, String cmdy0503) {
        Map map = new HashMap();
        map.put("wdkc0201", wdkc0201);
        map.put("cmdy0503", cmdy0503);
        List<SectionVO> sectionVOList = new ArrayList<SectionVO>();
        
        String redisKey = "findbyCourseSectionList_" + wdkc0201 + "_" + cmdy0503;
    	if(!redisService.exists(redisKey)) {
    		sectionVOList = baseMapper.findbyCourseSectionList(map);
    		
    		setCourseSectionList(wdkc0201, cmdy0503, sectionVOList);
    	}else {
            sectionVOList = (List)redisService.lget(redisKey);
//            List<String> sectionVOList02 = new ArrayList<String>();
//            sectionVOList02 = (List)redisService.lget(redisKey);
//            for (String sectionVO02 : sectionVOList02
//                 ) {
//                SectionVO sectionVO = ThreadUtils.getRTex().jsonSerializeObject(sectionVO02, SectionVO.class);
//                sectionVOList.add(sectionVO);
//            }
    	}
    	
        return sectionVOList;
    }
    
    public void setCourseSectionList(String wdkc0201, String cmdy0503, List<SectionVO> sectionVOList) {
    	String redisKey = "findbyCourseSectionList_" + wdkc0201 + "_" + cmdy0503;
		redisService.setListCache(redisKey, (List)sectionVOList, RedisUtil.SerializerMode.SERIALIZATION, TimeUnit.MINUTES.toSeconds(30));
//        Gson gson = new Gson();
//        redisService.remove(redisKey);
//        for (SectionVO thisSectionVO :sectionVOList
//             ) {
//            redisService.lradd(redisKey, gson.toJson(thisSectionVO));
//        }

	}

    /**
     * 进入课程——切换章节
     * @param wdkc0201 我的商品表ID
     * @param cmdy0503 课程ID
     * @param ccwe001 章节ID
     * @param lere0101 课程结果表id
     * @param userId 用户id
     */
    @Override
    public Map<String, Object> findbyCourseSwitchSection(String wdkc0201, String cmdy0503, String ccwe001, String lere0101, String userId) {
         /*
            更新一波进度，把上一个章节的播放进度记录一下
         */
        updateProgress(wdkc0201, cmdy0503, userId, lere0101);


        Map map = new HashMap();
        map.put("wdkc0201", wdkc0201);
        map.put("cmdy0503", cmdy0503);
        map.put("ccwe001", ccwe001);
        Map<String, Object> courseSwitchSectionMap = baseMapper.findbyCourseSwitchSection(map);

        if(courseSwitchSectionMap != null){
        	courseSwitchSectionMap.put("LERE0101", lere0101);//lere0101 课程结果表id
            courseSwitchSectionMap.put("LERE0105", 0);//课程进度
            courseSwitchSectionMap.put("LERE0108", 0);//课程是否完成 0：在学 1：已完成
            courseSwitchSectionMap.put("LCWR0107", 0);//学习位置 单位：秒
            courseSwitchSectionMap.put("LCWR0110", 0);//章节是否学完 0未完成 1已完成

            //查询用户课程进度
            List<Tblere01> tblere01List = tblere01Service.selectUserProgressCourse(userId);
            for (Tblere01 thisTblere01 : tblere01List
            ) {
                String lere0102 = thisTblere01.getLere0102();//课程ID
                String lere0109 = thisTblere01.getLere0109();//我的商品表ID
                if(ThreadUtils.getRTex().equals(lere0102, cmdy0503)
                        && ThreadUtils.getRTex().equals(lere0109, wdkc0201)
                ){
                    Double lere0105 = thisTblere01.getLere0105();//课程进度
                    if(lere0105 != null){
                        courseSwitchSectionMap.put("LERE0105", lere0105.intValue());
                    }
                    Double lere0108 = thisTblere01.getLere0108();//课程是否完成 0：在学 1：已完成
                    if(lere0108 != null){
                        courseSwitchSectionMap.put("LERE0108", lere0108.intValue());
                    }

                    //课程底下的章节列表
                    List<SectionVO> maps = findbyCourseSectionList(wdkc0201, cmdy0503);
                    for (SectionVO thisSectionVO : maps
                         ) {
                        boolean flag = false;
                        String courseid = thisSectionVO.getCourseid();//课程ID
                        for (SectionVO thisSectionVO02 : thisSectionVO.getSectionList()
                             ) {
                            String lcwr0104 = thisSectionVO02.getLcwr0104();// 	学习总结果表ID
                            String lcwr0103 = thisSectionVO02.getLcwr0103();//	用户ID
                            String ccwe0011 = thisSectionVO02.getCcwe001();// 章节ID
                            if(ThreadUtils.getRTex().equals(courseid, cmdy0503)
                                    && ThreadUtils.getRTex().equals(lcwr0104, lere0101)
                                    && ThreadUtils.getRTex().equals(lcwr0103, userId)
                                    && ThreadUtils.getRTex().equals(ccwe0011, ccwe001)
                            ){
                                Integer lcwr0107 = thisSectionVO02.getLcwr0107();//学习位置 单位：秒
                                Integer lcwr0110 = thisSectionVO02.getLcwr0110();//章节是否学完 0未完成 1已完成
                                if(lcwr0107 != null){
                                    courseSwitchSectionMap.put("LCWR0107", lcwr0107.intValue());
                                }
                                if(lcwr0110 != null){
                                    courseSwitchSectionMap.put("LCWR0110", lcwr0110.intValue());
                                }
                                thisSectionVO02.setLcwr0111(0);// 是否更新完成 （0未更新 1已更新）

                                flag = true;
                                break;
                            }
                        }
                        if(flag){
                            break;
                        }
                    }
                    //更新章节缓存
                    setCourseSectionList(wdkc0201, cmdy0503, maps);
                    break;
                }
            }
            
          //查询MongoDB该章节课件播放位置（秒）
            Map map02 = new HashMap();
            map02.put("upro003", userId);/* 用户ID*/
            map02.put("upro002", lere0101);/* 学习课程结果表id*/
            map02.put("upro004", ccwe001); /* 章节ID */
            StudyMgdbUserProgessEntity studyMgdbUserProgessEntity = appLearningMongoDbService.findeOnePlayCache(map02);
            if(studyMgdbUserProgessEntity != null) {
                int upro005 = studyMgdbUserProgessEntity.getUpro005();
                courseSwitchSectionMap.put("UPRO005", upro005);//当前播放章节位置（秒）
            }else{
                courseSwitchSectionMap.put("UPRO005", 0);//当前播放章节位置（秒）
            }
        }



        // 更新当前课程下所有章节“课程的章节学习结果表tbLCWR01”是否最后观看的章节 为0.否
        Tblcwr01 t02 = new Tblcwr01();
        t02.setLcwr0112(0d); // 是否最后观看的章节 0.否 1.是
        t02.setLcwr0113(new Date());
        EntityWrapper<Tblcwr01> ew02 = new EntityWrapper<Tblcwr01>();
        ew02.where(" LCWR0104 = {0} and LCWR0102 = {1} and LCWR0103 = {2}  ", lere0101, cmdy0503, userId);
        tblcwr01Service.update(t02, ew02);


        // 更新当前章节“课程的章节学习结果表tbLCWR01”是否最后观看的章节 为1.是
        Tblcwr01 t = new Tblcwr01();
        t.setLcwr0111(0d); // 是否更新完成 （0未更新 1已更新）
        t.setLcwr0112(1d); // 是否最后观看的章节 0.否 1.是
        t.setLcwr0113(new Date());
        EntityWrapper<Tblcwr01> ew = new EntityWrapper<Tblcwr01>();
        ew.where(" LCWR0104 = {0} and LCWR0102 = {1} and LCWR0103 = {2} and LCWR0105 = {3} ", lere0101, cmdy0503, userId, ccwe001);
        int i1 = tblcwr01Service.selectCount(ew);
        if(i1 >= 1){
            tblcwr01Service.update(t, ew);
        }else{
            t.setLcwr0104(lere0101);
            t.setLcwr0102(cmdy0503);
            t.setLcwr0103(userId);
            t.setLcwr0105(ccwe001);
            tblcwr01Service.insertOrUpdate(t);
        }


        return courseSwitchSectionMap;
    }

    /**
     * 课程播放——记录进度
     * @param wdkc0201 我的商品表ID
     * @param cour001 课程ID
     * @param ccwe001 章节ID
     * @param lcwr0107 章节播放位置
     * @param lcwr0110 该章节是否完成 0否 1是
     * @param userid 用户id
     * @param lere0101 学习课程结果表id
     * @param kjjd0106 学习端来源 0：PC端 1：IOS手机端 2：Android手机3：IOS-Pad 4：Android-Pad
     */
    @Override
    public String recordProgress(String wdkc0201, String cour001, String ccwe001, String lcwr0107, String lcwr0110, String userid, String lere0101, String kjjd0106	) throws Exception {
//        String upro003 = ObjectUtils.toString(map.get("upro003")); /* 用户ID*/
//        String upro002 = ObjectUtils.toString(map.get("upro002")); /* 学习活动ID*/
//        String upro004 = ObjectUtils.toString(map.get("upro004")); /* 课件ID*/
//        String upro005 = ObjectUtils.toString(map.get("upro005")); /* 当前进度*/
//        Date nowTime=new Date();
//        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String upro009 = ObjectUtils.toString(map.get("upro009")); /* 学习端类型*/
        try{
            Map map = new HashMap();
            map.put("upro003", userid);/* 用户ID*/
            map.put("upro002", lere0101);/* 学习课程结果表id*/
            map.put("upro004", ccwe001); /* 章节ID */
            map.put("upro005", lcwr0107);/* 章节播放位置 */
            map.put("upro009", kjjd0106);/*学习端来源 */
            map.put("upro010", lcwr0110);/* 是否学完 （0未完成 1已完成）*/
            int i = appLearningMongoDbService.cacheCoursewareProgress(map);


        }catch (Exception e){
            logger.error("记录进度失败！！", e);
            return "FAIL";
        }

        return  "SUCCESS";
    }

    /**
     * 课程播放——记录进度（测试）
     * @param wdkc0201 我的商品表ID
     * @param cour001 课程ID
     * @param ccwe001 章节ID
     * @param lcwr0107 章节播放位置
     * @param lcwr0110 该章节是否完成 0否 1是
     */
    @Override
    public String recordProgress02(String wdkc0201, String cour001, String ccwe001, String lcwr0107, String lcwr0110, String userid, String lere0101) {

//        String upro003 = ObjectUtils.toString(map.get("upro003")); /* 用户ID*/
//        String upro002 = ObjectUtils.toString(map.get("upro002")); /* 学习活动ID*/
//        String upro004 = ObjectUtils.toString(map.get("upro004")); /* 课件ID*/
        Map map = new HashMap();
        map.put("upro003", userid);/* 用户ID*/
        map.put("upro002", lere0101);/* 学习课程结果表id*/
        map.put("upro004", ccwe001); /* 章节ID */
        StudyMgdbUserProgessEntity studyMgdbUserProgessEntity = appLearningMongoDbService.findeOnePlayCache(map);


//        return baseMapper.recordProgress(wdkc0201, cour001, ccwe001, lcwr0107 ,lcwr0110);
        return  null;
    }

    /**
     * 课程播放——更新进度
     * @param wdkc0201 我的商品表ID
     * @param cour001 课程ID
     * @param userid 用户id
     * @param lere0101 学习课程结果表id
     */
    @Override
    public String updateProgress(String wdkc0201, String cour001, String userid, String lere0101) {

        int courseSectionNum = 0;//章节数量
        int courseSectionCompleteNum = 0;//章节完成数量
        int courseSectionTotalTime = 0;//所有章节总时长
        int courseSectionTotalStudyTime = 0;//所有章节已学时长

        /*
		        先查询课程底下的所有章节，逐一检查章节完成情况，如果章节显示未完成，MongoDB记录已完成，更新 章节结果表。
		        记录章节数和章节完成数，如果章节数不等于0且章节数与章节完成数相等，那么证明该课程学习完毕，更新 课程结果表。

         */
        
        //课程底下的章节列表
        List<SectionVO> maps = findbyCourseSectionList(wdkc0201, cour001);
        if(maps != null) {
            for (int i = 0; i < maps.size(); i++) {
                SectionVO item = maps.get(i);
                List zhangjie02List = item.getSectionList();
                if (zhangjie02List != null) {
                    for (int j = 0; j < zhangjie02List.size(); j++) {
                        SectionVO item02 = (SectionVO) zhangjie02List.get(j);
                        //章节ID
                        String ccwe001 = Objects.toString(item02.getCcwe001(), "-1");
                        //该章节 是否学完 0未完成 1已完成
                        String lcwr0110 = Objects.toString(item02.getLcwr0110(), "0");
                        //是否更新完成 （0未更新 1已更新）
                        String lcwr0111 = Objects.toString(item02.getLcwr0111(), "0");
                        //该章节 课件总时长
                        int cour005 = new Integer(Objects.toString(item02.getCour005(), "0"));
                        //该章节 学习位置 单位：秒
                        int lcwr0107 = new Integer(Objects.toString(item02.getLcwr0107(), "0"));
                        courseSectionTotalTime += cour005;

                        if (lcwr0110.equals("0")) {
                            Map map02 = new HashMap();
                            map02.put("upro003", userid);/* 用户ID*/
                            map02.put("upro002", lere0101);/* 学习课程结果表id*/
                            map02.put("upro004", ccwe001); /* 章节ID */
                            StudyMgdbUserProgessEntity studyMgdbUserProgessEntity = appLearningMongoDbService.findeOnePlayCache(map02);
                            //MongoDB记录该章节已经完成，更新 学习章节结果表
                            if (studyMgdbUserProgessEntity != null && Objects.toString(studyMgdbUserProgessEntity.getUpro010(), "-1").equals("1")) {
                                Tblcwr01 t = new Tblcwr01();
                                t.setLcwr0107(0d); // 	学习位置 单位：秒
                                t.setLcwr0108(100d); // 学习进度
                                t.setLcwr0109(new Date());
                                t.setLcwr0110(1d); // 是否学完
                                t.setLcwr0111(1d); // 是否更新完成 （0未更新 1已更新）
                                t.setLcwr0113(new Date());
                                EntityWrapper<Tblcwr01> ew = new EntityWrapper<Tblcwr01>();
                                ew.where(" LCWR0104 = {0} and LCWR0102 = {1} and LCWR0103 = {2} and LCWR0105 = {3} ", lere0101, cour001, userid, ccwe001);

                                int i1 = tblcwr01Service.selectCount(ew);
                                if(i1 >= 1){
                                    tblcwr01Service.update(t, ew);
                                }else{
                                    t.setLcwr0104(lere0101);
                                    t.setLcwr0102(cour001);
                                    t.setLcwr0103(userid);
                                    t.setLcwr0105(ccwe001);
                                    tblcwr01Service.insertOrUpdate(t);
                                }
                                
                                item02.setLcwr0107(0);// 	学习位置 单位：秒
                                item02.setLcwr0110(1);//已完成
                                item02.setLcwr0111(1);//更新完成

                                courseSectionTotalStudyTime += cour005;
                                courseSectionCompleteNum++;
                            }else if(studyMgdbUserProgessEntity != null){
                                //mongodb  记录的课件播放时长
                                int upro005 = studyMgdbUserProgessEntity.getUpro005();
                                if(upro005 > lcwr0107 && upro005 <= cour005){
                                    if(lcwr0111.equals("0")){
                                        double lcwr0108 = new BigDecimal((float)upro005/cour005 * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                                        Tblcwr01 t = new Tblcwr01();
                                        t.setLcwr0107((double)upro005); // 	学习位置 单位：秒
                                        t.setLcwr0108(lcwr0108); // 学习进度
                                        t.setLcwr0109(new Date());
                                        t.setLcwr0111(1d); // 是否更新完成 （0未更新 1已更新）
                                        t.setLcwr0113(new Date());
                                        EntityWrapper<Tblcwr01> ew = new EntityWrapper<Tblcwr01>();
                                        ew.where(" LCWR0104 = {0} and LCWR0102 = {1} and LCWR0103 = {2} and LCWR0105 = {3} ", lere0101, cour001, userid, ccwe001);
                                        int i1 = tblcwr01Service.selectCount(ew);
                                        if(i1 >= 1){
                                            tblcwr01Service.update(t, ew);
                                        }else{
                                            t.setLcwr0104(lere0101);
                                            t.setLcwr0102(cour001);
                                            t.setLcwr0103(userid);
                                            t.setLcwr0105(ccwe001);
                                            tblcwr01Service.insertOrUpdate(t);
                                        }

                                        item02.setLcwr0107(upro005);// 	学习位置 单位：秒
                                        item02.setLcwr0111(1);//更新完成
                                    }

                                    courseSectionTotalStudyTime += upro005;
                                }else{
                                    if(lcwr0111.equals("0")){
                                        // 更新当前章节“课程的章节学习结果表tbLCWR01”是否更新完成 为1.是
                                        Tblcwr01 t = new Tblcwr01();
                                        t.setLcwr0111(1d); // 是否更新完成 （0未更新 1已更新）
                                        t.setLcwr0113(new Date());
                                        EntityWrapper<Tblcwr01> ew = new EntityWrapper<Tblcwr01>();
                                        ew.where(" LCWR0104 = {0} and LCWR0102 = {1} and LCWR0103 = {2} and LCWR0105 = {3} ", lere0101, cour001, userid, ccwe001);
                                        int i1 = tblcwr01Service.selectCount(ew);
                                        if(i1 >= 1){
                                            tblcwr01Service.update(t, ew);
                                        }else{
                                            t.setLcwr0104(lere0101);
                                            t.setLcwr0102(cour001);
                                            t.setLcwr0103(userid);
                                            t.setLcwr0105(ccwe001);
                                            tblcwr01Service.insertOrUpdate(t);
                                        }

                                        item02.setLcwr0111(1);//更新完成
                                    }

                                    item02.setLcwr0107(upro005);// 	学习位置 单位：秒
                                    courseSectionTotalStudyTime += lcwr0107;
                                }
                            }
                        } else if (lcwr0110.equals("1")) {
                            courseSectionTotalStudyTime += cour005;
                            courseSectionCompleteNum++;
                        }
                        courseSectionNum++;
                    }
                }
            }
            //更新章节缓存
            setCourseSectionList(wdkc0201, cour001, maps);
        }
        
		//查询用户课程进度
		List<Tblere01> tblere01List = tblere01Service.selectUserProgressCourse(userid);

        if(courseSectionNum >= 1 && courseSectionNum == courseSectionCompleteNum){
            //课程完成，更新状态
            Tblere01 t2 = new Tblere01();
            t2.setLere0105(100d);
            t2.setLere0107(new Date());//学习结束时间
            t2.setLere0108(1d);
            t2.setLere0110(new Date());//上次学习时间
            EntityWrapper<Tblere01> ew02 = new EntityWrapper<Tblere01>();
            ew02.where(" lere0101 = {0}  ", lere0101);
            tblere01Service.update(t2, ew02);
            
            for(Tblere01 tblere0102 : tblere01List) {
            	if(tblere0102.getLere0101() != null && tblere0102.getLere0101().equals(lere0101) // 学员学习课程结果表id
            			) {
            		tblere0102.setLere0105(100d);
            		tblere0102.setLere0110(new Date());
            	}
            }
            //保存用户课程学习进度
            tblere01Service.setUserProgressCourse(userid, tblere01List);
        }else{
            //总学习进度
            double lere0105 = 0;
            if(courseSectionTotalTime != 0){
                lere0105 = new BigDecimal((float)courseSectionTotalStudyTime/courseSectionTotalTime * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            Tblere01 t2 = new Tblere01();
            t2.setLere0105(lere0105);//学习进度
            t2.setLere0110(new Date());//上次学习时间
            EntityWrapper<Tblere01> ew02 = new EntityWrapper<Tblere01>();
            ew02.where(" lere0101 = {0}  ", lere0101);
            tblere01Service.update(t2, ew02);
            
            for(Tblere01 tblere0102 : tblere01List) {
            	if(tblere0102.getLere0101() != null && tblere0102.getLere0101().equals(lere0101) // 学员学习课程结果表id
            			) {
            		tblere0102.setLere0105(lere0105);
            		tblere0102.setLere0110(new Date());
            	}
            }
            //保存用户课程学习进度
            tblere01Service.setUserProgressCourse(userid, tblere01List);
        }

        Map map = new HashMap();
        map.put("lere0101", lere0101);/* 学习课程结果表id*/
        
        //更新完成状态
        baseMapper.updateProgress(map);

        return "SUCCESS";
    }

    @Override
    public IPage findbyCourseQuestionsAndAnswersList(IPage evaluationPage, Tbclassaskquestions01 tbclassaskquestions01) {
        List<Tbclassaskquestions01> tbclassaskquestions01s = baseMapper.findbyCourseQuestionsAndAnswersList(evaluationPage, tbclassaskquestions01);
        tbclassaskquestions01s.forEach((data)->{
            data.setClaq0113(emojiConverter.toUnicode(data.getClaq0113()));
        });
        evaluationPage.setRecords(tbclassaskquestions01s);
        return evaluationPage;
    }

    @Override
    public IPage browseTheQuestions(IPage evaluationPage, Tbclassaskquestions01 tbclassaskquestions01) {
        List<Tbclassaskquestions01> tbclassaskquestions01s = baseMapper.browseTheQuestions(evaluationPage, tbclassaskquestions01);
        tbclassaskquestions01s.forEach(data -> {
            data.setClaq0104(emojiConverter.toUnicode(data.getClaq0104()));
        });
        evaluationPage.setRecords(tbclassaskquestions01s);
        return evaluationPage;
    }

    @Override
    public List<Map> courseRecord(Tbwdkc01 tbwdkc01) {
        return baseMapper.courseRecord(tbwdkc01);
    }

    @Override
    public Map<String, Object> findbyCommentInformatica(String cour001) {
        return baseMapper.findbyCommentInformatica(cour001);
    }

    @Override
    public String toAdoptToAnswer(String claq0201) {
        return baseMapper.toAdoptToAnswer(claq0201)==1?"SUCCESS":"FAIL";
    }

    @Override
    public String increaseTheNumberOfViews(String claq0101) {
        return baseMapper.increaseTheNumberOfViews(claq0101)==1?"SUCCESS":"FAIL";
    }

    @Override
    public Map<String, String> findbyCourseNumber(String cour001, String ccwe001) {
        Map map = new HashMap();
        map.put("cmdy0503", cour001);
        map.put("ccwe001", ccwe001);


        return baseMapper.findbyCourseNumber(map);
    }

}
