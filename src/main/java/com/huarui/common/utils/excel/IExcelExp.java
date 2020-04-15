package com.huarui.common.utils.excel;

import com.baomidou.mybatisplus.activerecord.Model;
import com.huarui.common.Req;

import java.util.List;

/**
 * 导出Excel需集成的接口
 */
public interface IExcelExp {

    /**
     * 设置Excel基础信息
     */
    public ExcelExpEntity setExcelBasicInformation();

    /**
     * 查询导出数据
     * @return
     */
    public List<Model> derivedData(Req req);
}
