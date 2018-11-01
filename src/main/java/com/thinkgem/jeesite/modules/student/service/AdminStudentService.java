/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.AdminStudent;
import com.thinkgem.jeesite.modules.student.dao.AdminStudentDao;

/**
 * 学生信息管理Service
 * @author admin
 * @version 2018-11-01
 */
@Service
@Transactional(readOnly = true)
public class AdminStudentService extends CrudService<AdminStudentDao, AdminStudent> {

	public AdminStudent get(String id) {
		return super.get(id);
	}
	
	public List<AdminStudent> findList(AdminStudent adminStudent) {
		return super.findList(adminStudent);
	}
	
	public Page<AdminStudent> findPage(Page<AdminStudent> page, AdminStudent adminStudent) {
		return super.findPage(page, adminStudent);
	}
	
	@Transactional(readOnly = false)
	public void save(AdminStudent adminStudent) {
		super.save(adminStudent);
	}
	
	@Transactional(readOnly = false)
	public void delete(AdminStudent adminStudent) {
		super.delete(adminStudent);
	}
	
}