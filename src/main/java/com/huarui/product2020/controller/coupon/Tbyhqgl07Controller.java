package com.huarui.product2020.controller.coupon;


import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.entity.Tbyhqgl03;
import com.huarui.product2020.entity.Tbyhqgl07;
import com.huarui.product2020.service.ITbyhqgl03Service;
import com.huarui.product2020.service.ITbyhqgl07Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author panlei
 * @since 2020-04-07
 */
@Controller
@RequestMapping("/huarui/tbyhqgl07")
public class Tbyhqgl07Controller {
	
	@Autowired
	private ITbyhqgl03Service tbyhqgl03Service;
	@Autowired
	private ITbyhqgl07Service tbyhqgl07Service;
	
	
	/**
	 * 优惠券激活记录列表
	 */
	@RequestMapping("/findByList")
	@ResponseBody
	public ResultEntity findByList(Req req) throws Exception {
		// 返回数据
		ResultEntity result = new ResultEntity();
		Map map = new HashMap<>();
		
		String userId = req.getUserId();
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user001", userId);
		
		try {
			List recordList = tbyhqgl07Service.findActivationRecordList(param);
			map.put("recordList", recordList);
			result.setData(map);
		} catch (Exception e) {
			result.setErrorMsg("获取数据失败");
		}
		return result;
	}
	
	/**
	 * 优惠券激活
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
		param.put("yhqgl0303", xxkgl0303);
		param.put("yhqgl0304", xxkgl0304);
		
		try {
			Tbyhqgl03 tbyhqgl03 = null;
			List<Tbyhqgl03> studyCardList = tbyhqgl03Service.findYHQList(param);
			if(null != studyCardList && studyCardList.size() == 1) {
				//即将激活的一张优惠券
				tbyhqgl03 = studyCardList.get(0);
				if(tbyhqgl03.getYhqgl0704n() == 1) {
					result.setErrorMsg("该卡已激活");
					return result;
				}
				//激活
				Tbyhqgl07 entity = new Tbyhqgl07();
				entity.setYhqgl0703(tbyhqgl03.getYhqgl0301());
				entity.setYhqgl0704(1d);
				entity.setYhqgl0705(req.getUserId());
				entity.setYhqgl0709(0d);
				entity.setYhqgl0710(0d);
				
				boolean updateActivation = tbyhqgl07Service.updateActivation(entity);
				if(updateActivation) {
					map.put("status", "SUCCESS");
				}else {
					result.setErrorMsg("激活失败");
					return result;
				}
			}else if(null != studyCardList && studyCardList.size() > 1){
				result.setErrorMsg("激活出现错误，请联系系统管理员");
				return result;
			}else {
				result.setErrorMsg("卡号或密码错误");
				return result;
			}
		} catch (Exception e) {
			result.setErrorMsg("获取数据失败");
		}
		result.setData(map);
		return result;
	}
	
}
