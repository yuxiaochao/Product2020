package com.huarui.product2020.controller.study;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.binarywang.java.emoji.EmojiConverter;
import com.huarui.common.Req;
import com.huarui.common.utils.AESHelper;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.RText;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.*;
import com.huarui.product2020.entity.vo.SectionVO;
import com.huarui.product2020.service.*;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping("/study")
public class StudyOnlineController {

    private static Logger logger = LoggerFactory.getLogger(StudyOnlineController.class);

    /**
     * 1.	我的课程套包表
     */
    @Autowired
    public ITbwdkc01Service tbwdkc01Service;
    /**
     * 2.	我的课程表tbWDKC02
     */
    @Autowired
    public ITbwdkc02Service tbwdkc02Service;
    /**
     * 1.	学员学习课程结果表tbLERE01
     */
    @Autowired
    public ITblere01Service tblere01Service;
    /**
     * 2.	课程的章节学习结果表tbLCWR01
     */
    @Autowired
    public ITblcwr01Service tblcwr01Service;

    @Autowired
    public ITbcmdy01Service cmdy01Service;

    @Autowired
    private IStudyTUsernoteService noteService;

    @Autowired
    private StudyCenterService studyCenterService;

    @Autowired
    private IStudyTUsermessageService messageService;

    @Autowired
    private IStudyTUsermessagereplyService replyService;

    @Autowired
    private ITbclassaskquestions01Service tbclassaskquestions01Service;

    @Autowired
    private ITbclassaskquestions02Service tbclassaskquestions02Service;

    private static EmojiConverter emojiConverter = EmojiConverter.getInstance();

    /**
     * 我的课程——完成订单加入课程
     */
    @RequestMapping("/addCoursePackage")
    @ResponseBody
    public ResultEntity addCoursePackage(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

        Map<String, Object> paramMap = req.getParameterMap();
        //	商品包ID
        String cmdy0301 = Objects.toString(paramMap.get("cmdy0301"), "");
        // 套包ID
        String cmdy0601 = Objects.toString(paramMap.get("cmdy0601"), "");
        // 商品ID
        String cmdy0401 = Objects.toString(paramMap.get("cmdy0401"), "");
        //类型 1.整个套包购买 2.单个商品购买
        String param01 = Objects.toString(paramMap.get("param01"), "");
        //订单ID
        String dd0101 = Objects.toString(paramMap.get("dd0101"), "");

        String userId = req.getUserId();

        Map t = new HashMap();
        t.put("cmdy0301", cmdy0301);
        t.put("cmdy0601", cmdy0601);
        t.put("cmdy0401", cmdy0401);
        t.put("param01", param01);
        t.put("dd0101", dd0101);
        t.put("userId", userId);
        String s = tbwdkc01Service.addCoursePackage(t);

        result.setData(s);

        return result;
    }

    /**
     * 查询
     * 我的课程——专业list
     */
    @RequestMapping("/findCmdy01")
    @ResponseBody
    public ResultEntity findCmdy01(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

        List<Tbcmdy01> tbcmdy01s = cmdy01Service.selectList(new EntityWrapper<Tbcmdy01>().eq("cmdy0104",1));

        result.setData(tbcmdy01s);

        return result;
    }


    /**
     * 查询
     * 我的课程——套包list
     */
    @RequestMapping("/findbyCoursePackage")
    @ResponseBody
    public ResultEntity findbyCoursePackage(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

        Map<String, Object> paramMap = req.getParameterMap();
        String cmdy0101 = Objects.toString(paramMap.get("cmdy0101"), null);//专业id

        String userId = req.getUserId();

        Tbwdkc01 t = new Tbwdkc01();
        t.setWdkc0104(userId);
        t.setCmdy0303(cmdy0101);//专业id
        List<Tbwdkc01> tbwdkc01s = tbwdkc01Service.findbyCoursePackageList(t);
        
        /*以下为金题库的参数处理*/
        for (Tbwdkc01 tbwdkc01 : tbwdkc01s) {
//        	if("其他".equals(tbwdkc01.getWdkc0105())) {
        		List<Tbwdkc02> wdkc02List = tbwdkc01.getWdkc02List();
        		for (Tbwdkc02 product : wdkc02List) {//商品信息
        			if(product.getCour010().contains("金题库")) {
	        			String user001 = product.getUser001();
	        			String courseid = product.getCmdy0503();
	        			String leex003 = product.getLeex003();
	        			String cour010 = product.getCour010();
	        			String user004 = product.getUser004();
	        			String cmdy0409n = product.getCmdy0409n();//过期时间
	        			String endtime =cmdy0409n;
	        			//endtime=endtime.substring(0,19);

	        			//生成跳转中转页面的参数加密串
						 PowerToken pt=new PowerToken();
						 pt.setUserid(String.valueOf(user001));
						 pt.setUsername(user004);
						 pt.setEndTime(endtime);
						 pt.setResourceId(courseid);
						 String auth=pt.jsonToken();
//						 auth=AESUtils.encrypt(auth, "video20150126");
						 auth = new AESHelper("video20150126").encrypt(auth, "video20150126");
						 String appEName="";
						 if("2".equals(leex003)){
							 appEName="TY_YSGL_WY";
						 }else if("3".equals(leex003)){
							 appEName="XY_YXZSY_GJ";
						 }else if("5".equals(leex003)){
							 appEName="XY_YXZSE_GJ";
						 }else if("7".equals(leex003)){
							 appEName="XY_ZHZSJN_GJ";
						 }else if("10".equals(leex003)){
							 appEName="ZY_YXZSY_WY";
						 }else if("11".equals(leex003)){
							 appEName="ZY_YXZSE_GJ";
						 }else if("13".equals(leex003)){
							 appEName="ZY_ZHZSJN_GJ";
						 }
						 product.setAuth(auth);
						 product.setAppEName(appEName);
						 product.setAppName(URLEncoder.encode(cour010, "UTF-8"));
//						 product.setSsoToken(AESUtils.encrypt("{\"userId\":\""+user001+"\"}", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCB"));
						 product.setSsoToken(new AESHelper("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCB").encrypt("{\"userId\":\""+user001+"\"}", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCB"));
						 product.setUid(user001+"_"+product.getCmdy0503());
        			}
        			
				}
//        	}
		}
        
        
        result.setData(tbwdkc01s);

        return result;
    }


    /**
     * 查询
     * 我的课程——套包list
     */
    @RequestMapping("/findbyCourse")
    @ResponseBody
    public ResultEntity findbyCourse(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

        Map<String, Object> paramMap = req.getParameterMap();
        String userId = req.getUserId();
        String wdkc0101 = Objects.toString(paramMap.get("wdkc0101"), "");//我的课程套包表id
        String cour010 = Objects.toString(paramMap.get("cour010"), "");//课程名称
        Tbwdkc02 t = new Tbwdkc02();
        if(!"".equals(cour010)){
            t.setCour010(cour010);
            t.setWdkc0204(userId);
        }else {
            t.setWdkc0202(wdkc0101);
        }
        List<Tbwdkc02> tbwdkc02s = tbwdkc02Service.findbyCourseList(t);

        result.setData(tbwdkc02s);

        return result;
    }

    /**
     * 学习笔记-新增笔记
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/addStudyNote")
    @ResponseBody
    public ResultEntity addStudyNote(Req req, HttpServletRequest request) throws Exception {

        // 返回内容
        ResultEntity result = new ResultEntity();
        Map map = new HashMap();

        // 获取输入参数
        String user001 = req.getUserId(); // 用户ID
        String userCode = ObjectUtils.toString(request.getParameter("userCode")); // 密码
        String unot002 = ObjectUtils.toString(request.getParameter("UNOT002")); // 课程ID
        String unot005 = ObjectUtils.toString(request.getParameter("UNOT005")); // 课件ID
        String unot006 = ObjectUtils.toString(request.getParameter("UNOT006")); // 笔记内容
        String unot009 = ObjectUtils.toString(request.getParameter("UNOT009"));// 是否为共享笔记 0 否 1 是
        String unot010 = ObjectUtils.toString(request.getParameter("UNOT010"));// 当前视频播放时间
        unot006 = emojiConverterToAlias(unot006);
        try {
            // 插入笔记
            StudyTUsernote noteEntity = new StudyTUsernote();
            noteEntity.setUnot001(new RText().getUUID());
            noteEntity.setUnot002(unot002);
            noteEntity.setUnot003(user001);
            noteEntity.setUnot005(unot005);
            noteEntity.setUnot006(unot006);
            noteEntity.setUnot007(new Date().toString());
            noteEntity.setUnot008(new Date());
            noteEntity.setUnot009(unot009);
            noteEntity.setUnot010(unot010);
            boolean flag = noteService.insert(noteEntity);
            map.put("resultState", flag ? 1 : 0);
            result.setData(map);
        } catch (Exception e) {
            result.setErrorMsg("数据添加失败");
        }

        return result;
    }

    public static String emojiConverterToAlias(String str){
        String result = emojiConverter.toAlias(str);
        return result;
    }

    public static String emojiConverterUnicodeStr(String emojiStr){
        String result = emojiConverter.toUnicode(emojiStr);
        return result;
    }

    /**
     * 进入课程——课程详细信息
     */
    @RequestMapping("/findbyCourseInformation")
    @ResponseBody
    public ResultEntity findbyCourseInformation(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

        Map<String, Object> paramMap = req.getParameterMap();

        String wdkc0101 = Objects.toString(paramMap.get("wdkc0201"), "");//我的商品表ID
        String cmdy0503 = Objects.toString(paramMap.get("cmdy0503"), "");//课程ID

        Map courseInfo = tbwdkc01Service.findbyCourseInformation(wdkc0101, cmdy0503);


        List<SectionVO> sectionList = tbwdkc01Service.findbyCourseSectionList(wdkc0101, cmdy0503);
        courseInfo.put("sectionList", sectionList);

        paramMap.put("user001", req.getUserId());
        paramMap.put("leac001", cmdy0503);
        paramMap.put("umes005", "");
        List evaluationNum = studyCenterService.queryCourseEvaluationNum(paramMap);
        if(evaluationNum!=null&&evaluationNum.get(0)!=null){
            Map map = (Map)evaluationNum.get(0);
            courseInfo.put("evaluationNum", map.get("NUM0"));
        }else {
            courseInfo.put("evaluationNum", 0);
        }
        result.setData(ThreadUtils.getRTex().formatMap(courseInfo));

        return result;
    }


    /**
     * 进入课程——切换章节
     */
    @RequestMapping("/findbyCourseSwitchSection")
    @ResponseBody
    public ResultEntity findbyCourseSwitchSection(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

        Map<String, Object> paramMap = req.getParameterMap();

        String wdkc0101 = Objects.toString(paramMap.get("wdkc0201"), "");//我的商品表ID
        String cmdy0503 = Objects.toString(paramMap.get("cmdy0503"), "");//课程ID
        String ccwe001 = Objects.toString(paramMap.get("ccwe001"), "");//章节ID
        String lere0101 = Objects.toString(paramMap.get("lere0101"), "");//课程结果表id
        String userId = req.getUserId();//用户id

        Map courseInfo = tbwdkc01Service.findbyCourseSwitchSection(wdkc0101, cmdy0503, ccwe001, lere0101, userId);

        List<SectionVO> sectionList = tbwdkc01Service.findbyCourseSectionList(wdkc0101, cmdy0503);
        courseInfo.put("sectionlist", sectionList);

        result.setData(ThreadUtils.getRTex().formatMap(courseInfo));

        return result;
    }

    /**
     * 课程学习-收藏取消收藏
     *
     * @return
     */
    @RequestMapping("/collectionOrCancelCollection")
    @ResponseBody
    public ResultEntity collectionOrCancelCollection(Req req, HttpServletRequest request) throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap<>();

        // 获取输入参数
        String user001 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("USER001"));//用户ID
        String fav002 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("FAV002"));//课程ID
        String collectionType = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("COLLECTIONTYPE"));//点赞或者取消赞
        try {
            if (!"".equals(collectionType) && "0".equals(collectionType)) {//收藏
                String fav001 = new RText().getUUID();
                Map<String, Object> paramMap = new HashMap<String, Object>();
                paramMap.put("fav001", fav001);
                paramMap.put("user001", user001);
                paramMap.put("fav002", fav002);
                studyCenterService.collection(paramMap);
                map.put("resultState", 0);
            } else if (!"".equals(collectionType) && "1".equals(collectionType)) { //取消收藏
                Map<String, Object> paramMap = new HashMap<String, Object>();
                paramMap.put("fav003", user001);
                paramMap.put("fav002", fav002);
                studyCenterService.cancelCollection(paramMap);
                map.put("resultState", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorMsg("操作失败");
        }
        result.setData(map);
        return result;
    }

    /**
     * 互动沟通-添加评价
     *
     * @return
     */
    @RequestMapping("/add_courseEvaluation")
    @ResponseBody
    public ResultEntity addcourseEvaluation(Req req, HttpServletRequest request) throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap<>();

        // 获取输入参数
        String user001 = req.getUserId();
        String cmdy0503 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("cmdy0503"));// 课程ID
        String umes004 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UMES004"));
        Double umes005 = Double.parseDouble(Objects.toString(request.getParameter("UMES005"), "0")); // 学员评论：0、好评 1、中评 2、差评 -2.我的
        Integer star = req.getInteger("star"); //星数  1~5
        if(star >= 4){
            umes005 = 0d;
        }else if(star >= 2){
            umes005 = 1d;
        }else if(star >= 1){
            umes005 = 2d;
        }


        umes004 = emojiConverterToAlias(umes004);
        try {
            StudyTUsermessage messageEntity = new StudyTUsermessage();
            messageEntity.setUmes002(cmdy0503);
            messageEntity.setUmes003(user001);
            messageEntity.setUmes004(umes004);
            messageEntity.setUmes005(umes005);
            messageEntity.setUmes006("0");
            messageEntity.setUmes007(new Date());
            messageEntity.setUmes008(star);
            messageService.insert(messageEntity);
        } catch (Exception e) {
            result.setErrorMsg("添加数据失败");
        }
        return result;
    }

    /**
     * 学习笔记-列表（移动端适用）
     *
     * @return
     */
    @RequestMapping("/studyNoteList")
    @ResponseBody
    public ResultEntity studyNoteList(Req req, HttpServletRequest request) throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap<>();

        // 获取输入参数
        String user001 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("USER001"));// user001 我的笔记 -1 共享笔记
        String unot002 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT002"));// 课程ID
        String unot005 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT005"));// 章节ID
        String unot009 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT009"));// 0.我的笔记 1.共享笔记 2.共享笔记 + 我的笔记 3.我点赞的笔记
        // 分页参数
        int start = Integer.parseInt(request.getParameter("START")); // 分页参数 第几页
        int limit = Integer.parseInt(request.getParameter("LIMIT")); // 分页参数 每页条数
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user001", user001);
        paramMap.put("unot002", unot002);
        paramMap.put("unot005", unot005);
        paramMap.put("unot009", unot009);
        String totals = "totals";//我的笔记数量
        String studentTotals = "studentTotals";//共享笔记数量
        try {
            IPage noteListPage = new IPage(start, limit){};
            noteListPage = studyCenterService.queryStudyNoteList(noteListPage, paramMap);
            List<Map<String, Object>> myNoteList = noteListPage.getRecords();
            if (null != myNoteList && myNoteList.size() > 0) {
                for (int i = 0; i < myNoteList.size(); i++) {
                    Map<String, Object> myNoteMap = myNoteList.get(i);
                    myNoteMap.put("unot006", emojiConverterUnicodeStr(myNoteMap.get("unot006").toString()));
                }
            }
            map.put("studyNoteList", new RText().formatList(myNoteList));
            if (unot009.equals("0")) {
                paramMap.put("unot009", "1");
                map.put(totals, noteListPage.getTotal());
            } else {
                paramMap.put("unot009", "0");
                map.put(studentTotals, noteListPage.getTotal());
            }
            map.put("totalPage", noteListPage.getPages());

            IPage noteListPages = new IPage(start, limit){};
            noteListPages = studyCenterService.queryStudyNoteList(noteListPage, paramMap);
            if (unot009.equals("0")) {
                map.put(studentTotals, noteListPages.getTotal());
            } else {
                map.put(totals, noteListPages.getTotal());
            }
            result.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorMsg("数据获取失败");
        }

        return result;
    }

    /**
     * 学习笔记-列表（PC端适用）
     *
     * @return
     */
    @RequestMapping("/findbyCourseNotesList")
    @ResponseBody
    public ResultEntity findbyCourseNotesList(Req req, HttpServletRequest request) throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap<>();

        // 获取输入参数
        String user001 = req.getUserId();// user001 我的笔记 -1 共享笔记
        String unot002 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT002"));// 课程ID
        String unot005 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT005"));// 章节ID
        String unot009 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT009"));// 0.我的笔记 1.共享笔记 2.共享笔记 + 我的笔记 3.我点赞的笔记
        // 分页参数
        int start = Integer.parseInt(request.getParameter("START")); // 分页参数 第几页
        int limit = Integer.parseInt(request.getParameter("LIMIT")); // 分页参数 每页条数
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user001", user001);
        paramMap.put("unot002", unot002);
        paramMap.put("unot005", unot005);
        paramMap.put("unot009", unot009);
        try {
            IPage noteListPage = new IPage(start, limit){};
            noteListPage = studyCenterService.queryStudyNoteList(noteListPage, paramMap);
            List<Map<String, Object>> myNoteList = ThreadUtils.getRTex().formatList(noteListPage.getRecords());
            if (null != myNoteList && myNoteList.size() > 0) {
                for (int i = 0; i < myNoteList.size(); i++) {
                    Map<String, Object> myNoteMap = myNoteList.get(i);
                    myNoteMap.put("unot006", emojiConverterUnicodeStr(myNoteMap.get("unot006").toString()));
                }
            }
            result.setData(noteListPage);
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorMsg("数据获取失败");
        }

        return result;
    }

    /**
     * //学习笔记-点赞
     *
     * @return
     */
    @RequestMapping("/studyNoteFabulous")
    @ResponseBody
    public ResultEntity studyNoteFabulous(Req req, HttpServletRequest request) throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap<>();

        // 获取输入参数
        String UNOFB003 = req.getUserId();// 用户user001
        String UNOFB002 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOFB002"));//  笔记id
        String FabulousType = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOFB004"));// 0:点赞，1取消点赞
        String TYPE = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("TYPE"));//  TYPE:0点赞，1取消赞
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("UNOFB002", UNOFB002);
        paramMap.put("UNOFB003", UNOFB003);
        paramMap.put("FabulousType", FabulousType);

        try {
            if (TYPE.equals("0")) {
                studyCenterService.StudyNoteFabulous(paramMap);
                //更新数量
                studyCenterService.upStudyNoteFabulous(paramMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorMsg("fasle");
        }

        return result;
    }

    /**
     * 学习笔记-修改笔记内容
     *
     * @return
     */
    @RequestMapping("/updateNoteContent")
    @ResponseBody
    public ResultEntity updateNoteContent(Req req, HttpServletRequest request) throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap<>();

        // 获取输入参数
        String unot001 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT001")); //笔记ID
        String unot006 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT006")); //笔记内容
        String unot009 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT009")); //笔记状态
        try {
            // 修改笔记
            StudyTUsernote noteEntity = new StudyTUsernote();
            noteEntity.setUnot001(unot001);
            noteEntity.setUnot006(unot006);
            noteEntity.setUnot009(unot009);
            boolean flag = noteService.updateById(noteEntity);
            map.put("resultState", flag ? 1 : 0);
            result.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorMsg("数据修改失败");
        }
        return result;
    }

    /**
     * 学习笔记-删除笔记
     *
     * @return
     */
    @RequestMapping("/deleteStudyNote")
    @ResponseBody
    public ResultEntity deleteStudyNote(Req req, HttpServletRequest request) throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap<>();

        // 获取输入参数
        String user001 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("USER001")); // 用户编号
        String userCode = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("userCode")); // 密码
        String unot001 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT001"));// 笔记ID
        try {
            // 删除笔记
            boolean flag = noteService.deleteById(unot001);
            map.put("resultState", flag ? 1 : 0);
            result.setData(map);
        } catch (Exception e) {
            result.setErrorMsg("数据删除失败");
        }
        return result;
    }

    /**
     * 学习笔记-共享笔记
     *
     * @return
     */
    @RequestMapping("/shareStudyNote")
    @ResponseBody
    public ResultEntity shareStudyNote(Req req, HttpServletRequest request) throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap<>();

        // 获取输入参数
        String user001 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("USER001")); // 用户编号
        String userCode = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("userCode")); // 密码
        String unot001 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UNOT001"));// 笔记ID
        try {
            // 共享笔记
            StudyTUsernote noteEntity = new StudyTUsernote();
            noteEntity.setUnot001(unot001);
            noteEntity.setUnot009("1");
            boolean flag = noteService.updateById(noteEntity);
            map.put("resultState", flag ? 1 : 0);
            result.setData(map);
        } catch (Exception e) {
            result.setErrorMsg("共享笔记失败");
        }
        return result;
    }

    /**
     * 课程预览页面---课程评价列表（适用移动端）
     *
     * @return
     */
    @RequestMapping("/query_studyCourseSingleEvaluation")
    @ResponseBody
    public ResultEntity queryStudyCourseSingleEvaluation(Req req, HttpServletRequest request)
            throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap<>();

        // 获取输入参数
        String user001 = req.getUserId();
        String leac001 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("LEAC001"));// 课程ID
        String umes005 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UMES005"));// 学员评论：0、好评 1、中评 2、差评 -2.我的 空字符串 全部
        int START = Integer.parseInt(org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("START")));//分頁
        int LIMIT = Integer.parseInt(org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("LIMIT")));// 分頁
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user001", user001);
        paramMap.put("leac001", leac001);
        paramMap.put("umes005", umes005);

        try {
            // 评论列表
            IPage evaluationPage = new IPage(START, LIMIT){};
            evaluationPage = studyCenterService.queryCourseEvaluationList(evaluationPage, paramMap);
            List<Map> list = new RText().formatList(evaluationPage.getRecords());
            map.put("singleEvaluationList", new RText().formatList(evaluationPage.getRecords()));
            for (Map map1: list) {
                map1.put("umes004",emojiConverterUnicodeStr(map1.get("umes004").toString()));
            }
            List evaluationNum = studyCenterService.queryCourseEvaluationNum(paramMap);
            map.put("totalPage", evaluationPage.getPages());
            map.put("evaluationNum", evaluationNum);
            result.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorMsg("获取数据失败");
        }
        return result;
    }

    /**
     * 课程预览页面---课程评价列表（适用PC端）
     *
     * @return
     */
    @RequestMapping("/findbyCourseCommentList")
    @ResponseBody
    public ResultEntity findbyCourseCommentList(Req req, HttpServletRequest request)
            throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();

        // 获取输入参数
        String user001 = req.getUserId();
        String leac001 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("LEAC001"));// 课程ID
        String umes005 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UMES005"));// 学员评论：0、好评 1、中评 2、差评 -2.我的 空字符串 全部
        String queryDate = Objects.toString(request.getParameter("queryDate"), null);// 查询时间，查询该时间之前的数据
        int START = Integer.parseInt(org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("START")));//分頁
        int LIMIT = Integer.parseInt(org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("LIMIT")));// 分頁
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user001", user001);
        paramMap.put("leac001", leac001);
        paramMap.put("umes005", umes005);
        paramMap.put("queryDate", queryDate);

        try {
            // 评论列表
            IPage evaluationPage = new IPage(START, LIMIT){};
            evaluationPage = studyCenterService.queryCourseEvaluationList(evaluationPage, paramMap);
            List<Map> list = ThreadUtils.getRTex().formatList(evaluationPage.getRecords());
            for (Map map1: list) {
                map1.put("umes004",emojiConverterUnicodeStr(map1.get("umes004").toString()));
            }
            result.setData(evaluationPage);
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorMsg("获取数据失败");
        }
        return result;
    }


    /**
     * 课程播放——记录进度
     */
    @RequestMapping("/recordProgress")
    @ResponseBody
    public ResultEntity recordProgress(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

        Map<String, Object> paramMap = req.getParameterMap();

        String wdkc0201 = Objects.toString(paramMap.get("wdkc0201"), "");//我的商品表ID
        String cour001 = Objects.toString(paramMap.get("cour001"), "");//课程ID
        String ccwe001 = Objects.toString(paramMap.get("ccwe001"), "");//章节ID
        String lcwr0107 = Objects.toString(paramMap.get("lcwr0107"), "");//章节播放位置
        String lcwr0110 = Objects.toString(paramMap.get("lcwr0110"), "");//该章节是否完成 0否 1是
        String lere0101 = Objects.toString(paramMap.get("lere0101"), "");//学习课程结果表id
        String kjjd0106 = Objects.toString(paramMap.get("kjjd0106"), "");//学习端来源 0：PC端 1：IOS手机端 2：Android手机3：IOS-Pad 4：Android-Pad

        String userId = req.getUserId();

        String courseInfo = tbwdkc01Service.recordProgress(wdkc0201, cour001, ccwe001, lcwr0107, lcwr0110, userId, lere0101, kjjd0106);

        result.setData(courseInfo);

        return result;
    }

    /**
     * 课程播放——记录进度
     */
    @RequestMapping("/recordProgressTest")
    @ResponseBody
    public ResultEntity recordProgressTest(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

        Map<String, Object> paramMap = req.getParameterMap();

        String wdkc0101 = Objects.toString(paramMap.get("wdkc0201"), "");//我的商品表ID
        String cour001 = Objects.toString(paramMap.get("cour001"), "");//课程ID
        String ccwe001 = Objects.toString(paramMap.get("ccwe001"), "");//章节ID
        String lcwr0107 = Objects.toString(paramMap.get("lcwr0107"), "");//章节播放位置
        String lcwr0110 = Objects.toString(paramMap.get("lcwr0110"), "");//该章节是否完成 0否 1是
        String lere0101 = Objects.toString(paramMap.get("lere0101"), "");//学习课程结果表id

        String userId = req.getUserId();

        String courseInfo = tbwdkc01Service.recordProgress02(wdkc0101, cour001, ccwe001, lcwr0107, lcwr0110, userId, lere0101);

        result.setData(courseInfo);

        return result;
    }

    /**
     * 课程播放——更新进度
     */
    @RequestMapping("/updateProgress")
    @ResponseBody
    public ResultEntity updateProgress(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

        Map<String, Object> paramMap = req.getParameterMap();

        String wdkc0101 = Objects.toString(paramMap.get("wdkc0201"), "");//我的商品表ID
        String cour001 = Objects.toString(paramMap.get("cour001"), "");//课程ID
        String lere0101 = Objects.toString(paramMap.get("lere0101"), "");//学习课程结果表id

        String userId = req.getUserId();

        String courseInfo = tbwdkc01Service.updateProgress(wdkc0101, cour001, userId, lere0101);

        result.setData(courseInfo);

        return result;
    }

    /**
     * 互动沟通-点赞取消赞
     * @return
     */
    @RequestMapping("/likeOrDislike")
    @ResponseBody
    public ResultEntity likeOrDislike(Req req, HttpServletRequest request) throws Exception {

        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap<>();

        // 获取输入参数
        String user001 = req.getUserId();
        String umre002 = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("UMRE002"));// 消息ID
        String likeType = org.apache.commons.lang3.ObjectUtils.toString(request.getParameter("LIKETYPE"));
        try {
            if (!"".equals(likeType) && "0".equals(likeType)) {// 点赞
                String umre001 = new RText().getUUID();
                Map<String, Object> paramMap = new HashMap<String, Object>();
                paramMap.put("user001", user001);
                paramMap.put("umre002", umre002);
                paramMap.put("umre001", umre001);
                studyCenterService.spotFabulous(paramMap);
            } else if (!"".equals(likeType) && "1".equals(likeType)) { // 取消赞
                EntityWrapper<StudyTUsermessagereply> entityWrapper = new EntityWrapper<>();
                entityWrapper.eq("UMRE002", umre002);
                entityWrapper.eq("UMRE003", user001);
                replyService.delete(entityWrapper);
            }
            map.put("resultState", 1);
        } catch (Exception e) {
            map.put("resultState", 0);
            result.setErrorMsg("操作失败");
        }
        result.setData(map);
        return result;
    }


    /**
     * 查询
     * 课程问答——问答列表
     */
    @RequestMapping("/findbyCourseQuestionsAndAnswersList")
    @ResponseBody
    public ResultEntity findbyCourseQuestionsAndAnswersList(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap();

        Map<String, Object> paramMap = req.getParameterMap();
        String claq0102 = Objects.toString(paramMap.get("claq0102"), null);//课程ID
        String claq0110 = Objects.toString(paramMap.get("claq0110"), null);//章节ID(二级章节)
        String type = Objects.toString(paramMap.get("type"), null);//类型 0全部 1我回答的 2我提问的

        String userid = req.getUserId();//用户id

        int start = req.getInteger("START");//分頁
        int limit = req.getInteger("LIMIT");// 分頁

//        IPage evaluationPage = new IPage(start, limit){};
        IPage evaluationPage02 = new IPage(start, limit){};

//        //所有提问列表
//        Tbclassaskquestions01 t = new Tbclassaskquestions01();
//        t.setClaq0102(claq0102);
//        evaluationPage = tbwdkc01Service.findbyCourseQuestionsAndAnswersList(evaluationPage, t);
//        map.put("allQuestionsList", evaluationPage.getRecords());
//
//        //我的提问列表
//        Tbclassaskquestions01 t2 = new Tbclassaskquestions01();
//        t2.setClaq0102(claq0102);
//        t2.setClaq0103(userid);
//        evaluationPage02 = tbwdkc01Service.findbyCourseQuestionsAndAnswersList(evaluationPage02,t2);
//        map.put("myQuestionsList", evaluationPage02.getRecords());

        //我的提问列表
        Tbclassaskquestions01 t2 = new Tbclassaskquestions01();
        t2.setClaq0102(claq0102);
        t2.setClaq0103(userid);
        t2.setClaq0109(type);//类型 0全部 1我回答的 2我提问的
        t2.setClaq0110(claq0110);//二级章节ID
        evaluationPage02 = tbwdkc01Service.findbyCourseQuestionsAndAnswersList(evaluationPage02,t2);

        result.setData(evaluationPage02);

        return result;
    }

    /**
     * 查询
     * 课程问答——浏览问题
     */
    @RequestMapping("/browseTheQuestions")
    @ResponseBody
    public ResultEntity browseTheQuestions(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap();

        Map<String, Object> paramMap = req.getParameterMap();
        String claq0101 = Objects.toString(paramMap.get("claq0101"), null);//题目ID

        String userid = req.getUserId();//用户id

        int start = req.getInteger("START");//分頁
        int limit = req.getInteger("LIMIT");// 分頁

        IPage evaluationPage = new IPage(start, limit){};

        //所有提问列表
        Tbclassaskquestions01 t = new Tbclassaskquestions01();
        t.setClaq0101(claq0101);
        evaluationPage = tbwdkc01Service.browseTheQuestions(evaluationPage, t);

        //浏览数增加一
        tbwdkc01Service.increaseTheNumberOfViews(claq0101);


        result.setData(evaluationPage);

        return result;
    }


    /**
     * 课程问答——发布提问
     */
    @RequestMapping("/askQuestion")
    @ResponseBody
    public ResultEntity askQuestion(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap();

        Map<String, Object> paramMap = req.getParameterMap();
        String claq0102 = Objects.toString(paramMap.get("cour001"), null);//课程ID
        String claq0104 = Objects.toString(paramMap.get("claq0104"), null);//问题内容
        String claq0113 = Objects.toString(paramMap.get("claq0113"), null);//问题内容(纯文本)
        String claq0110 = Objects.toString(paramMap.get("claq0110"), null);//章节id
        int claq0111 = req.getInteger("claq0111");//当前播放时间（秒）
        claq0104 = emojiConverterToAlias(claq0104);
        claq0113 = emojiConverterToAlias(claq0113);

        String userid = req.getUserId();//用户id


        try {
            Tbclassaskquestions01 tbclassaskquestions01 = new Tbclassaskquestions01();
            tbclassaskquestions01.setClaq0102(claq0102);
            tbclassaskquestions01.setClaq0103(userid);
            tbclassaskquestions01.setClaq0104(claq0104);
            tbclassaskquestions01.setClaq0105(0);
            tbclassaskquestions01.setClaq0107(new Date());
            tbclassaskquestions01.setClaq0110(claq0110);
            tbclassaskquestions01.setClaq0111(claq0111);
            tbclassaskquestions01.setClaq0112(0d);
            tbclassaskquestions01.setClaq0113(claq0113);

            tbclassaskquestions01Service.insert(tbclassaskquestions01);
            result.setData("SUCCESS");
        } catch (Exception e) {
            logger.error("插入提问数据出错了！！！", e);
            result.setErrorMsg("添加数据失败");
        }

        return result;
    }

    /**
     * 课程问答——回答问题
     */
    @RequestMapping("/answer")
    @ResponseBody
    public ResultEntity answer(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap();

        Map<String, Object> paramMap = req.getParameterMap();
        String cour001 = Objects.toString(paramMap.get("cour001"), null);//题目ID
        String claq0101 = Objects.toString(paramMap.get("claq0101"), null);//题目ID
        String claq0205 = Objects.toString(paramMap.get("claq0205"), null);//回答内容
        String claq0201 = Objects.toString(paramMap.get("claq0201"), null);//回复某内容 内容ID
        claq0205 = emojiConverterToAlias(claq0205);
        claq0201 = emojiConverterToAlias(claq0201);

        String userid = req.getUserId();//用户id

        //内容类型：0、回答问题 1、回复答案
        int claq0206 = 0;
        if(claq0201 != null && !claq0201.isEmpty()){
            claq0206 = 1;
        }


        try {
            Tbclassaskquestions02 tbclassaskquestions02 = new Tbclassaskquestions02();
            tbclassaskquestions02.setClaq0202(claq0101);
            tbclassaskquestions02.setClaq0203(cour001);
            tbclassaskquestions02.setClaq0204(userid);
            tbclassaskquestions02.setClaq0205(claq0205);
            tbclassaskquestions02.setClaq0206(claq0206);
            tbclassaskquestions02.setClaq0207(claq0201);
            tbclassaskquestions02.setClaq0208(new Date());

            tbclassaskquestions02Service.insert(tbclassaskquestions02);

            result.setData("SUCCESS");
        } catch (Exception e) {
            logger.error("插入提问数据出错了！！！", e);
            result.setErrorMsg("添加数据失败");
        }

        return result;
    }


    /**
     * 查询
     * 我的——课程记录
     */
    @RequestMapping("/courseRecord")
    @ResponseBody
    public ResultEntity courseRecord(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

//        Map<String, Object> paramMap = req.getParameterMap();

        String userId = req.getUserId();

        Tbwdkc01 t = new Tbwdkc01();
        t.setWdkc0104(userId);
        List<Map> tbwdkc01s = tbwdkc01Service.courseRecord(t);

        result.setData(ThreadUtils.getRTex().formatList(tbwdkc01s));

        return result;
    }

    /**
     * 课程评价——获取 评价信息
     */
    @RequestMapping("/findbyCommentInformatica")
    @ResponseBody
    public ResultEntity findbyCommentInformatica(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap();

        Map<String, Object> paramMap = req.getParameterMap();
        String cour001 = Objects.toString(paramMap.get("cour001"), null);//课程ID

//        String userid = req.getUserId();//用户id

        Map<String, Object> stringObjectMap = tbwdkc01Service.findbyCommentInformatica(cour001);
        result.setData(ThreadUtils.getRTex().formatMap(stringObjectMap));
        return result;
    }


    /**
     * 课程评价——采纳回答
     */
    @RequestMapping("/toAdoptToAnswer")
    @ResponseBody
    public ResultEntity toAdoptToAnswer(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();
        Map map = new HashMap();

        Map<String, Object> paramMap = req.getParameterMap();
        String claq0201 = Objects.toString(paramMap.get("claq0201"), null);//回答ID

//        String userid = req.getUserId();//用户id

        String isSuccess = tbwdkc01Service.toAdoptToAnswer(claq0201);
        result.setData(isSuccess);
        return result;
    }

    /**
     * 进入课程——查询笔记数、问答数和评论数
     */
    @RequestMapping("/findbyCourseNumber")
    @ResponseBody
    public ResultEntity findbyCourseNumber(Req req) throws Exception {
        // 返回数据
        ResultEntity result = new ResultEntity();

        Map<String, Object> paramMap = req.getParameterMap();

        String cour001 = Objects.toString(paramMap.get("cour001"), null);//课程ID
        String ccwe001 = Objects.toString(paramMap.get("ccwe001"), null);//章节ID

        Map<String, String> stringStringMap = tbwdkc01Service.findbyCourseNumber(cour001, ccwe001);

        result.setData(ThreadUtils.getRTex().formatMap(stringStringMap));

        return result;
    }

}
