package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbpxb02;
import com.huarui.product2020.mapper.Tbpxb02Mapper;
import com.huarui.product2020.service.ITbpxb02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
@Service
public class Tbpxb02ServiceImpl extends ServiceImpl<Tbpxb02Mapper, Tbpxb02> implements ITbpxb02Service {
	@Autowired
	private Tbpxb02Mapper tbpxb02Mapper;
	@Override
	public List<Tbpxb02> findByPage(IPage<Tbpxb02> page, Req req) {
		req.putParameter("pxb0204", 0);//课程形式（面授:0;线上:1;直播:2）
		List<Tbpxb02> findByPage = tbpxb02Mapper.findByPage(page,req);
		return findByPage;
	}
    @Override
    public List<Tbpxb02> findListByTrainingId(String id) {
        // TODO Auto-generated method stub
        return tbpxb02Mapper.findListByTrainingId(id);
    }
	@Override
	public List<Map<String, String>> findOptionByPxb0202(String pxb0202) {
		// TODO Auto-generated method stub
		return tbpxb02Mapper.findOptionByPxb0202(pxb0202);
	}
	
}
