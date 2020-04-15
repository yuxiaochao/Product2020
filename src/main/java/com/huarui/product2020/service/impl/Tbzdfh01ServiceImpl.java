package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbzdfh01;
import com.huarui.product2020.mapper.Tbzdfh01Mapper;
import com.huarui.product2020.service.ITbzdfh01Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 天猫推送数据日志表 服务实现类
 * </p>
 *
 * @author panlei
 * @since 2020-03-23
 */
@Service
public class Tbzdfh01ServiceImpl extends ServiceImpl<Tbzdfh01Mapper, Tbzdfh01> implements ITbzdfh01Service {
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean insert(Tbzdfh01 entity) {
        return retBool(baseMapper.insert(entity));
    }
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	 public boolean updateById(Tbzdfh01 entity) {
        return retBool(baseMapper.updateById(entity));
    }
}
