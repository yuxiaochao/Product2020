package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.AccommodationArrangeDto;
import com.huarui.product2020.entity.Tbpxb01;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface Tbpxb01Mapper extends BaseMapper<Tbpxb01> {
	/**
	 * 培训班管理
	 * 培训班基本信息列表
	 * @param
	 * @return
	 */
	public List<Tbpxb01> queryTranList(IPage<Tbpxb01> page,Map<String, Object> map) throws Exception;

	/**
	 * 根据ID查询基本信息
	 * @param id
	 * @return
	 */
    public Tbpxb01 findBasicInfoById(String id);
    /**
     * 已发布的培训班
     * @param req
     * @param pagination
     * @return
     */
    public List<Map<String, String>> findByPxb0123(Pagination pagination,Req req);
    /**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
    public Map<String,String> findByPxb0101(String id);
    /**
     * 根据id查询班培训学员签到情况
     * @param req
     * @param pagination
     * @return
     */
    public List<Map<String, String>> findRegisterByPxb0101(Pagination pagination,Req req);
    /**
     * 根据id查询班已报到培训学员数
     * @param req
     * @return
     */
    public Integer findRegisterCountByPxb0101(Req req);

    public List<AccommodationArrangeDto> findArrangedListByPage(Page<AccommodationArrangeDto> page,
            Map<String, Object> paramMap);

    public List<AccommodationArrangeDto> findUnArrangeListByPage(Page<AccommodationArrangeDto> page,
            Map<String, Object> paramMap);

    public AccommodationArrangeDto findAccommodationArranging(String id);
}