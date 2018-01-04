/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.classes.service.cal;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.TreeService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.classes.entity.cal.Classes;
import com.thinkgem.jeesite.modules.classes.dao.cal.ClassesDao;

/**
 * 日用百货分类Service
 * @author admin
 * @version 2017-11-10
 */
@Service
@Transactional(readOnly = true)
public class ClassesService extends TreeService<ClassesDao, Classes> {

	public Classes get(String id) {
		return super.get(id);
	}
	
	public List<Classes> findList(Classes classes) {
		if (StringUtils.isNotBlank(classes.getParentIds())){
			classes.setParentIds(","+classes.getParentIds()+",");
		}
		return super.findList(classes);
	}
	
	@Transactional(readOnly = false)
	public void save(Classes classes) {
		super.save(classes);
	}
	
	@Transactional(readOnly = false)
	public void delete(Classes classes) {
		super.delete(classes);
	}
	
}