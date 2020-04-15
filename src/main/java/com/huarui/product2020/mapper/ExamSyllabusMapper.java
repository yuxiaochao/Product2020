package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.product2020.entity.ExamSyllabusEntity;

public interface ExamSyllabusMapper extends BaseMapper<ExamSyllabusEntity>  {

    /**
     * 根据条件查询考试大纲根节点
     * @param map
     * @return
     */
    List<ExamSyllabusEntity> findExamSyllabusRootNode(Map<String, Object> paramsMap);

    /**
     * 根据父ID查询考试大纲子节点
     * @param paramsMap
     * @return
     */
    List<ExamSyllabusEntity> findByParentIdNode(Map<String, Object> paramsMap);

    /**
	 * 考试大纲首页树节点
	 * @param map1
	 * @return
	 */
	List<ExamSyllabusEntity> findSyllabusForTree(Map<String, Object> map1);

    /**
     * 插入考试大纲目录表
     * @param entity
     * @return
     */
    void insertSyllabusLevelrel(ExamSyllabusEntity entity);

	List<ExamSyllabusEntity> findByCriteria(ExamSyllabusEntity t);

}