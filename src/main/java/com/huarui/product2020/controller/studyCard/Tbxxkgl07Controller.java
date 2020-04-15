package com.huarui.product2020.controller.studyCard;


import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.*;
import com.huarui.product2020.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author su
 * @since 2020-03-27
 */
@Controller
@RequestMapping("/huarui/tbxxkgl07")
public class Tbxxkgl07Controller {
	
	@Autowired
	private ITbxxkgl02Service tbxxkgl02Service;
	@Autowired
	private ITbxxkgl03Service tbxxkgl03Service;
	@Autowired
	private ITbxxkgl07Service tbxxkgl07Service;
	@Autowired
	private ITbcmdy06Service tbcmdy06Service;
	@Autowired
	private ITbcmdy07Service tbcmdy07Service;
	@Autowired
	private ITbwdkc01Service tbwdkc01Service;
	@Autowired
	private ITbkcgm06Service tbkcgm06Service;
	@Autowired
	private ITbzdfh03Service tbzdfh03Service;
	
	/**
	 * 学习卡激活记录列表（带分页）
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findByPage")
	@ResponseBody
	public ResultEntity findByPage(Req req) throws Exception {

		// 返回数据
		ResultEntity result = new ResultEntity();
		Map map = new HashMap<>();

		// 获取输入参数
		String userId = req.getUserId();
		int start = Integer.parseInt(req.getString("START")); // 分页参数 第几页
		int limit = Integer.parseInt(req.getString("LIMIT")); // 分页参数 每页条数

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user001", userId);

		try {
			IPage page = new IPage(start,limit){};
			List recordList = tbxxkgl07Service.queryActivationRecordList(page, param);
			map.put("recordList", recordList);
			result.setData(map);
		} catch (Exception e) {
			result.setErrorMsg("获取数据失败");
		}
		return result;
	}
	
	/**
	 * 学习卡激活记录列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findByList")
	@ResponseBody
	public ResultEntity findByList(Req req) throws Exception {
		// 返回数据
		ResultEntity result = new ResultEntity();
		Map map = new HashMap<>();
		
		// 获取输入参数
		String userId = req.getUserId();
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user001", userId);
		
		try {
			List recordList = tbxxkgl07Service.findActivationRecordList(param);
			map.put("recordList", recordList);
			result.setData(map);
		} catch (Exception e) {
			result.setErrorMsg("获取数据失败");
		}
		return result;
	}
	
	/**
	 * 学习卡激活
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/activate")
	@ResponseBody
	public ResultEntity activate(HttpServletRequest request, Req req) throws Exception {
		// 返回数据
		ResultEntity result = new ResultEntity();
		Map map = new HashMap<>();
		
		// 获取输入参数
		String xxkgl0303 = req.getString("xxkgl0303");//卡号
		String xxkgl0304 = req.getString("xxkgl0304");//密码
		String validate = req.getString("validate");//验证码
		//验证码校验
		if (!validate.equals(request.getSession().getAttribute("code"))) {
			result.setErrorMsg("验证码错误");
			return result;
		}
		//参数校验
		if (ThreadUtils.getRTex().isEmpty(xxkgl0303)) {
			result.setErrorMsg("请输入卡号");
			return result;
		}
		if (ThreadUtils.getRTex().isEmpty(xxkgl0304)) {
			result.setErrorMsg("请输入密码");
			return result;
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("xxkgl0303", xxkgl0303);
		param.put("xxkgl0304", xxkgl0304);
		
		try {
			List<Map<String, Object>> bindCommodity = null;
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Tbxxkgl03 tbxxkgl03 = null;
			List<Tbxxkgl03> studyCardList = tbxxkgl03Service.findStudyCardList(param);
			if(null != studyCardList && studyCardList.size() == 1) {
				//即将激活的一张学习卡
				tbxxkgl03 = studyCardList.get(0);
				if(tbxxkgl03.getXxkgl0704n() == 1) {
					result.setErrorMsg("该卡已激活");
					return result;
				}
				if(2 == tbxxkgl03.getCardType() && !req.getUserId().equals(tbxxkgl03.getUserId())) {// 2 管理员分配，学员不匹配
					result.setErrorMsg("无权限激活，请换其他卡");
					return result;
				}

				Integer cardType = tbxxkgl03.getCardType();
				if(cardType != null && (cardType == 0 || cardType == 1)) {//卡类型：0 学习卡；1 试听卡  2 管理员分配  3 天猫商品自动开卡
					//学习卡ID（tbXXKGL01）
					String xxkgl0302 = tbxxkgl03.getXxkgl0302();
					//查找学习卡绑定的商品
					Map<String, Object> param1 = new HashMap<String, Object>();
					param1.put("xxkgl0302", xxkgl0302);
					bindCommodity = tbxxkgl02Service.findBindCommodity(param1);
				}else if(cardType != null && (cardType == 2)) {
					//TODO 查询tbKCGM06商品密码卡对应的商品
					String kcgm0601 = tbxxkgl03.getXxkgl0301();
					Map<String, Object> param1 = new HashMap<String, Object>();
					param1.put("kcgm0601", kcgm0601);
					bindCommodity = tbkcgm06Service.findBindCommodity(param1);
				}else if(cardType != null && (cardType == 3)) {
					//TODO 查询tbZDFH03 天猫商品自动开卡对应的商品
					String zdfh0301 = tbxxkgl03.getXxkgl0301();
					Map<String, Object> param1 = new HashMap<String, Object>();
					param1.put("zdfh0301", zdfh0301);
					bindCommodity = tbzdfh03Service.findBindCommodity(param1);
				}
				
			}else if(null != studyCardList && studyCardList.size() > 1){
				result.setErrorMsg("激活出现错误，请联系系统管理员");
				return result;
			}else {
				result.setErrorMsg("卡号或密码错误");
				return result;
			}
				
			map.put("xxkgl0301", tbxxkgl03.getXxkgl0301());
			map.put("cardType", tbxxkgl03.getCardType());//卡类型：0 学习卡；1 试听卡  2 管理员分配  3 天猫商品自动开卡
			//判断是否有套包
			boolean flag = false;
			if(null != bindCommodity && bindCommodity.size() > 0) {
				for (Map<String, Object> entity : bindCommodity) {
					Integer selectType = ThreadUtils.getRTex().toInteger(entity.get("SELECTTYPE"));
					if(2 == selectType) {
						list.add(entity);
						flag = true;
					}
				}
				if(flag) {
					map.put("bindCommodity", list);
				}else {
					map.put("bindCommodity", bindCommodity);
				}
			}
			result.setData(map);
		} catch (Exception e) {
			result.setErrorMsg("获取数据失败");
		}
		return result;
	}
	
	/**
	 * 学习卡激活时选择课程后确定
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bindCommodity")
	@ResponseBody
	public ResultEntity bindCommodity(Req req) throws Exception {
		// 返回数据
		ResultEntity result = new ResultEntity();
		Map map = new HashMap<>();
		
		// 获取输入参数
		String xxkgl0301 = req.getString("xxkgl0301");//学习卡卡号id
		String selectId = req.getString("selectId");//选择商品id
		Integer selectType = req.getInteger("selectType");//商品类型:1商品，2套包
		Integer cardType = req.getInteger("cardType");//卡类型：0 学习卡；1 试听卡  2 管理员分配  3 天猫商品自动开卡
		//参数校验
		if (ThreadUtils.getRTex().isEmpty(xxkgl0301) || ThreadUtils.getRTex().isEmpty(selectId) || ThreadUtils.getRTex().isEmpty(selectType)) {
			result.setErrorMsg("请选择所要学习的课程科目");
			return result;
		}
		
		try {
			if(cardType != null && (cardType == 0 || cardType == 1)) {
				//激活学习卡或试听卡
				Tbxxkgl07 entity = new Tbxxkgl07();
				entity.setXxkgl0703(xxkgl0301);
				entity.setXxkgl0704(1);
				entity.setXxkgl0705(req.getUserId());
				if(selectType == 2) {//套包
					entity.setXxkgl0707(selectId);
				}else if(selectType == 1) {//商品
					entity.setXxkgl0708(selectId);
				}
				boolean updateActivation = tbxxkgl07Service.updateActivation(entity);
			}else if(cardType != null && (cardType == 2)) {
				//激活tbKCGM06商品密码卡
				Tbkcgm06 entity = new Tbkcgm06();
				entity.setKcgm0601(xxkgl0301);
				entity.setKcgm0609(1l);//是否已用 0:未使用 1:已使用
				boolean updateActivation = tbkcgm06Service.updateActivation(entity);
			}else if(cardType != null && (cardType == 3)) {
				//激活tbZDFH03 天猫商品自动开卡
				Tbzdfh03 entity = new Tbzdfh03();
				entity.setZdfh0301(xxkgl0301);
				entity.setZdfh0302(1d);//是否已用 0:未使用 1:已使用
				entity.setZdfh0304(0d);
				entity.setZdfh0310(req.getUserId());
				boolean updateActivation = tbzdfh03Service.updateActivation(entity);
			}
			
			
			//学习卡激活后，课程中心添加商品课程
			String userId = req.getUserId();
			String cmdy0301 = "";
			String cmdy0601 = "";
			String cmdy0401 = "";
			int param01 = 0;
			int param07 = 0;
			Date param08 = new Date();
			if(selectType == 2) {//套包
				Tbcmdy06 tbcmdy06 = tbcmdy06Service.selectById(selectId);
				cmdy0301 = tbcmdy06.getCmdy0602();
				cmdy0601 = selectId;
				param01 = 1;
			}else if(selectType == 1) {//商品
				Tbcmdy07 tbcmdy07 = tbcmdy07Service.selectById(selectId);
				cmdy0301 = tbcmdy07.getCmdy0706();
				cmdy0601 = tbcmdy07.getCmdy0702();
				cmdy0401 = tbcmdy07.getCmdy0703();
				param01 = 2;
			}
			if(1 == cardType) {//试听卡
				Tbxxkgl03 Tbxxkgl03 = tbxxkgl03Service.findById(xxkgl0301);
				param07 = 1;
				param08 = Tbxxkgl03.getXxkgl0112n();
			}

	        Map t = new HashMap();
	        t.put("cmdy0301", cmdy0301);
	        t.put("cmdy0601", cmdy0601);
	        t.put("cmdy0401", cmdy0401);
	        t.put("userId", userId);
	        t.put("param01", param01);
	        t.put("dd0101", "");
	        t.put("param07", param07);
	        t.put("param08", param08);
	        String s = tbxxkgl07Service.addCoursePackage(t);
			
		} catch (Exception e) {
			result.setErrorMsg("激活失败");
		}
		return result;
	}
	
	
	
}
