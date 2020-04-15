package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbyhqgl01;
import com.huarui.product2020.mapper.Tbyhqgl01Mapper;
import com.huarui.product2020.service.ITbyhqgl01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2020-04-07
 */
@Service
public class Tbyhqgl01ServiceImpl extends ServiceImpl<Tbyhqgl01Mapper, Tbyhqgl01> implements ITbyhqgl01Service {

	@Autowired
	private Tbyhqgl01Mapper tbyhqgl01Mapper;
	
	/**
	 * 根据卡号、密码查询对应的信息 
	 */
	public Map<String, String> getCouponByCardAndPwd(String yhqgl0303, String yhqgl0304){
		return tbyhqgl01Mapper.getCouponByCardAndPwd(yhqgl0303,yhqgl0304);
	}
}
