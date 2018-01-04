/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity.stu;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生信息Entity
 * @author admin
 * @version 2017-11-09
 */
public class Student extends DataEntity<Student> {
	
	private static final long serialVersionUID = 1L;
	private Student parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String studentname;		// 学生名字
	private String sort;		// 排序
	
	public Student() {
		super();
	}

	public Student(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public Student getParent() {
		return parent;
	}

	public void setParent(Student parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=2000, message="所有父级编号长度必须介于 1 和 2000 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	@Length(min=1, max=100, message="学生名字长度必须介于 1 和 100 之间")
	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}