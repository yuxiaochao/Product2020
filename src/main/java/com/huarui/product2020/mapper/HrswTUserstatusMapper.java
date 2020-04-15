package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTUserstatus;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface HrswTUserstatusMapper extends BaseMapper<HrswTUserstatus> {
	
     /**
      * 手动添加用户状态
      * @param userInfo
      * @return
      * @throws Exception
      */
	public boolean insertInfo(HrswTUserstatus userInfo) throws Exception;

}