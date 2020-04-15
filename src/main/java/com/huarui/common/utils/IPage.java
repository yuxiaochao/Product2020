package com.huarui.common.utils;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.plugins.Page;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class  IPage<T extends Model> extends Page<T>{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键字段
	 */
	private String pkName = "";
	
	public IPage() {
		String pkName = getPkName();
		setPkName(pkName);
    }
	

    public IPage(int current, int size) {
        super(current, size);
		String pkName = getPkName();
		setPkName(pkName);
    }

    public IPage(int current, int size, String orderByField) {
        super(current, size);
        this.setOrderByField(orderByField);
		String pkName = getPkName();
		setPkName(pkName);
    }

	public List<T> getRecords() {
		List<T> records = super.getRecords();
        return ThreadUtils.getRTex().formatList(records, getPkName());
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
		}else {
			try {

				// 获取当前new的对象的泛型的父类类型
				Type type = this.getClass().getGenericSuperclass();
				if(type instanceof ParameterizedType){
					ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
					// 获取第一个类型参数的真实类型
					Class<T> clazz02 = (Class<T>) pt.getActualTypeArguments()[0];
					String pkName = ThreadUtils.getEntityUtil().getEntityPk(clazz02);
					if(!pkName.isEmpty()){
						this.pkName = pkName.toLowerCase();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.pkName;
	}

}
