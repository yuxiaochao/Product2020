package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbpxb06;
import com.huarui.product2020.mapper.Tbpxb06Mapper;
import com.huarui.product2020.service.ITbpxb06Service;
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
public class Tbpxb06ServiceImpl extends ServiceImpl<Tbpxb06Mapper, Tbpxb06> implements ITbpxb06Service {
	
    @Autowired
	private Tbpxb06Mapper tbpxb06Mapper;
    
    @Override
    public List findToExcel(Map map) {
        return this.baseMapper.findToExcel(map);
    }

	@Override
	public List<Tbpxb06> findStudentByPage(String id) {
		return tbpxb06Mapper.findStudentByPage(id);
	}
	/**
	 * 根据培训班id统计各种签到次数
	 * @param req
	 * @return
	 */
	@Override
	public IPage findCountByPxb0602(Req req) {
		int start = req.getCurrentPage(); // 分页参数 第几页
		int limit = req.getPageSize(); // 分页参数 每页条数
		IPage page = new IPage(start, limit){};
		List<Map<String, String>> list = tbpxb06Mapper.findCountByPxb0602(page, req);
		page.setRecords(list);
		return page;
	}
	/**
	 * 根据培训班id、学员id统计签到类型
	 * @param req
	 * @return
	 */
	@Override
	public IPage findTypeByPxb0602(Req req) {
		int start = req.getCurrentPage(); // 分页参数 第几页
		int limit = req.getPageSize(); // 分页参数 每页条数
		IPage page = new IPage(start, limit){};
		List<Map<String, String>> list = tbpxb06Mapper.findTypeByPxb0602(page, req);
		page.setRecords(list);
		return page;
	}

    @Override
    public Page<Tbpxb06> findTraineeList(Page<Tbpxb06> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findTraineeList(page, paramMap));
        return page;
    }
}
