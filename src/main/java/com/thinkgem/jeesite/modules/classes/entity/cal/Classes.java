/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.classes.entity.cal;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;

import com.thinkgem.jeesite.common.persistence.TreeEntity;

/**
 * 日用百货分类Entity
 * @author admin
 * @version 2017-11-10
 */
public class Classes extends TreeEntity<Classes> {
	
	private static final long serialVersionUID = 1L;
	private String classes;		// 班级
	private Integer sort;		// 排序
	private Classes parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private Integer status;		// 是否前段显示
	
	public Classes() {
		super();
	}

	public Classes(String id){
		super(id);
	}

	@Length(min=1, max=100, message="班级长度必须介于 1 和 100 之间")
	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}
	
	@NotNull(message="排序不能为空")
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public Classes getParent() {
		return parent;
	}

	public void setParent(Classes parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=2000, message="所有父级编号长度必须介于 1 和 2000 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	@NotNull(message="是否前段显示不能为空")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}