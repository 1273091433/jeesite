/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.entity.category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.TreeEntity;

/**
 * 商品分类管理Entity
 * @author admin
 * @version 2017-11-08
 */
public class BruceshopCategory extends TreeEntity<BruceshopCategory> {
	
	private static final long serialVersionUID = 1L;
	private BruceshopCategory parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String name;		// 名称
	private Integer status;		// 是否前段显示
	private Integer sort;		// 排序
	
	public BruceshopCategory() {
		super();
	}

	public BruceshopCategory(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public BruceshopCategory getParent() {
		return parent;
	}

	public void setParent(BruceshopCategory parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=2000, message="所有父级编号长度必须介于 1 和 2000 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull(message="是否前段显示不能为空")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@NotNull(message="排序不能为空")
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}