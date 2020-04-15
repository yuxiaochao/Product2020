package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.AccommodationArrangeDto;
import com.huarui.product2020.entity.Tbpxb01;
import com.huarui.product2020.mapper.Tbpxb01Mapper;
import com.huarui.product2020.service.ITbpxb01Service;
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
public class Tbpxb01ServiceImpl extends ServiceImpl<Tbpxb01Mapper, Tbpxb01> implements ITbpxb01Service {
	
	@Autowired
	private Tbpxb01Mapper tbpxb01Mapper;
	
	
	@Override
	public IPage<Tbpxb01> queryTranList(IPage<Tbpxb01> page, Map<String, Object> map) throws Exception {
		
		page.setRecords(tbpxb01Mapper.queryTranList(page,map));
		return page;
	}


    @Override
    public Tbpxb01 findBasicInfoById(String id) {
        return tbpxb01Mapper.findBasicInfoById(id);
    }

    /**
     * 已发布的培训班
     * @param req
     * @param pageable
     * @return
     */
	@Override
	public List<Map<String, String>> findByPxb0123(Req req, Pagination pagination) {
		String string = req.getString("rs3rs4");
		if(ThreadUtils.getRTex().isNotEmpty(string)) {
			String[] split = string.split(",");
			if(split.length>0) {
				req.putParameter("rs3", split[0]);
				req.putParameter("rs4", split[1]);
			}
		}
		List<Map<String, String>> record = tbpxb01Mapper.findByPxb0123(pagination,req);
		return record;
	}

	/**
   	 * 根据ID查询
   	 * @param id
   	 * @return
   	 */
	@Override
	public Map<String, String> findByPxb0101(Req req) {
		String ids = req.getIds();
		return tbpxb01Mapper.findByPxb0101(ids);
	}
	 /**
     * 根据id查询班培训学员签到情况
     * @param req
     * @param pagination
     * @return
     */
	@Override
	public List<Map<String, String>> findRegisterByPxb0101(Pagination pagination, Req req) {
		List<Map<String, String>> record = tbpxb01Mapper.findRegisterByPxb0101(pagination,req);
		return record;
	}
	/**
     * 根据id查询班已报到培训学员数
     * @param req
     * @return
     */
    public Integer findRegisterCountByPxb0101(Req req) {
    	return tbpxb01Mapper.findRegisterCountByPxb0101(req);
    };

    @Override
    public Page<AccommodationArrangeDto> findArrangedListByPage(Page<AccommodationArrangeDto> page,
            Map<String, Object> paramMap) {
        page.setRecords(tbpxb01Mapper.findArrangedListByPage(page, paramMap));
        return page;
    }


    @Override
    public Page<AccommodationArrangeDto> findUnArrangeListByPage(Page<AccommodationArrangeDto> page,
            Map<String, Object> paramMap) {
        page.setRecords(tbpxb01Mapper.findUnArrangeListByPage(page, paramMap));
        return page;
    }


    @Override
    public AccommodationArrangeDto findAccommodationArranging(String id) {
        return tbpxb01Mapper.findAccommodationArranging(id);
    }

}