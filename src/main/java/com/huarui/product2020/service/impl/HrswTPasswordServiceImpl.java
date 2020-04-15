package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTPassword;
import com.huarui.product2020.mapper.HrswTPasswordMapper;
import com.huarui.product2020.service.IHrswTPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2019-08-26
 */
@Service
public class HrswTPasswordServiceImpl extends ServiceImpl<HrswTPasswordMapper, HrswTPassword> implements IHrswTPasswordService {
	
	@Autowired
	private HrswTPasswordMapper hrswTPasswordMapper;
	
	public boolean insertOrUpdate( HrswTPassword passwordEntity) {
		return hrswTPasswordMapper.insertOrUpdate(passwordEntity);
	}
	
}
