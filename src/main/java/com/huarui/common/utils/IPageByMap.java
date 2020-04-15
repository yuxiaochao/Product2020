package com.huarui.common.utils;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

public class  IPageByMap<Map> extends Page<Map>{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键字段
	 */
	private String pkName = "";
	
	public IPageByMap() {
    }
	

    public IPageByMap(int current, int size) {
        super(current, size);
    }

    public IPageByMap(int current, int size, String orderByField) {
        super(current, size);
        this.setOrderByField(orderByField);
    }

	public List<Map> getRecords() {
		List<Map> records = super.getRecords();
        return ThreadUtils.getRTex().formatList(records);
    }
	
	
	
	public void setPkName(String pkName) {
		this.pkName = pkName;
	}

	/**
	 * 获得主键字段名称
	 * @return
	 */
	public String getPkName() {
		if(ThreadUtils.getRTex().isNotEmpty(this.pkName)) {
			return this.pkName;
		}
		return this.pkName;
	}
}
