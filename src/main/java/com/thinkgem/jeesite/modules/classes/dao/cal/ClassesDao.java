/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.classes.dao.cal;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.classes.entity.cal.Classes;

/**
 * 日用百货分类DAO接口
 * @author admin
 * @version 2017-11-10
 */
@MyBatisDao
public interface ClassesDao extends TreeDao<Classes> {
	
}