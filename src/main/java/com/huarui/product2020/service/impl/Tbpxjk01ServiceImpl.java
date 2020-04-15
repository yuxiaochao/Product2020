package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.Tbpxjk01;
import com.huarui.product2020.mapper.Tbpxjk01Mapper;
import com.huarui.product2020.service.ITbpxjk01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YanZeYang
 * @since 2020-01-15
 */
@Service
public class Tbpxjk01ServiceImpl extends ServiceImpl<Tbpxjk01Mapper, Tbpxjk01> implements ITbpxjk01Service {
	@Autowired
	private Tbpxjk01Mapper tbpxjk01Mapper;

	@Override
	public Integer insertReported(Req req) {
		String ids = req.getIds();
		if(ThreadUtils.getRTex().isNotEmpty(ids)) {
			String[] split = ids.split(",");
			req.putParameter("list", split);
			EntityWrapper<Tbpxjk01> wrapper = new EntityWrapper<Tbpxjk01>();
			wrapper.in("PXJK0105", split);
			wrapper.eq("PXJK0102", 1);
			Integer count = tbpxjk01Mapper.selectCount(wrapper);
			if(count>0) {
				return count;
			}else {
				String pxjk0104 = req.getString("pxjk0104");
				if(ThreadUtils.getRTex().isNotEmpty(pxjk0104)) {
					Date date = new Date(Long.parseLong(pxjk0104));
					req.putParameter("pxjk0104", date);
					tbpxjk01Mapper.insertBatch(req);
				}
			}
		}
		return 0;
	}
}
