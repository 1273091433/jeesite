/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service.stu;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.stu.Student;
import com.thinkgem.jeesite.modules.student.dao.stu.StudentDao;

/**
 * 学生信息Service
 * @author admin
 * @version 2017-11-09
 */
@Service
@Transactional(readOnly = true)
public class StudentService extends CrudService<StudentDao, Student> {

	public Student get(String id) {
		return super.get(id);
	}
	
	public List<Student> findList(Student student) {
		return super.findList(student);
	}
	
	public Page<Student> findPage(Page<Student> page, Student student) {
		return super.findPage(page, student);
	}
	
	@Transactional(readOnly = false)
	public void save(Student student) {
		super.save(student);
	}
	
	@Transactional(readOnly = false)
	public void delete(Student student) {
		super.delete(student);
	}
	
}