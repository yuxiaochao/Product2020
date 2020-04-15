package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.AccommodationArrangeDto;
import com.huarui.product2020.entity.Tbpxb01;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface ITbpxb01Service extends IService<Tbpxb01> {
	
	/**
	 * 培训班管理
	 * 培训班基本信息列表
	 * @param
	 * @return
	 */
	public IPage<Tbpxb01> queryTranList(IPage<Tbpxb01> page, Map<String, Object> map) throws Exception;

	
	/**
	 * 根据ID查询培训班基础信息
	 * @param id
	 * @return
	 */
    public Tbpxb01 findBasicInfoById(String id);
	
    /**
     * 已发布的培训班
     * @param req
     * @param iPage 
     * @param pageable
     * @return
     */
    public List<Map<String, String>> findByPxb0123(Req req, Pagination pagination);
    /**
   	 * 根据ID查询
   	 * @param id
   	 * @return
   	 */
    public Map<String, String> findByPxb0101(Req req);
    /**
     * 根据id查询班培训学员签到情况
     * @param pagination
     * @param req
     * @return
     */
    public List<Map<String, String>> findRegisterByPxb0101(Pagination pagination, Req req);
    /**
     * 根据id查询班已报到培训学员数
     * @param req
     * @return
     */
    public Integer findRegisterCountByPxb0101(Req req);


    /**
     * 查询食宿已安排的培训班
     * @param page
     * @param paramMap
     * @return
     */
    public Page<AccommodationArrangeDto> findArrangedListByPage(Page<AccommodationArrangeDto> page,
            Map<String, Object> paramMap);


    /**
     * 查询食宿未安排的培训班
     * @param page
     * @param paramMap
     * @return
     */
    public Page<AccommodationArrangeDto> findUnArrangeListByPage(Page<AccommodationArrangeDto> page,
            Map<String, Object> paramMap);


    public AccommodationArrangeDto findAccommodationArranging(String id);

}
