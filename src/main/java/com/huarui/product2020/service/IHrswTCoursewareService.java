package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTCourseware;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IHrswTCoursewareService extends IService<HrswTCourseware> {

    /**
     * 进入课程——课程详细信息——查询某课程下第一章节的课件信息
     * @param cour001 课程id
     */
    public List<Map<String, String>> findbyCourseFirstSectionList(String cour001);
	
}
