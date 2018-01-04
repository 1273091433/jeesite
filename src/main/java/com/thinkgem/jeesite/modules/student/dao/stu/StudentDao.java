/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.dao.stu;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.student.entity.stu.Student;

/**
 * 学生信息DAO接口
 * @author admin
 * @version 2017-11-09
 */
@MyBatisDao
public interface StudentDao extends CrudDao<Student> {
	
}