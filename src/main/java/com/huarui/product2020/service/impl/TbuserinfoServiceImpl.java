package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbuserinfo;
import com.huarui.product2020.mapper.TbuserinfoMapper;
import com.huarui.product2020.service.ITbuserinfoService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuxiaochao
 * @since 2020-02-19
 */
@Service
public class TbuserinfoServiceImpl extends ServiceImpl<TbuserinfoMapper, Tbuserinfo> implements ITbuserinfoService {

	@Override
	public Map<String, Object> selectUserInfo(String webUserId) {
		return baseMapper.selectMapForUserInfo(webUserId);
	}
	
}
