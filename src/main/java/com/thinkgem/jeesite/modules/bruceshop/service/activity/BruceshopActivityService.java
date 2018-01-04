/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.service.activity;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bruceshop.entity.activity.BruceshopActivity;
import com.thinkgem.jeesite.modules.bruceshop.dao.activity.BruceshopActivityDao;

/**
 * 促销活动Service
 * @author admin
 * @version 2017-11-16
 */
@Service
@Transactional(readOnly = true)
public class BruceshopActivityService extends CrudService<BruceshopActivityDao, BruceshopActivity> {

	public BruceshopActivity get(String id) {
		return super.get(id);
	}
	
	public List<BruceshopActivity> findList(BruceshopActivity bruceshopActivity) {
		return super.findList(bruceshopActivity);
	}
	
	public Page<BruceshopActivity> findPage(Page<BruceshopActivity> page, BruceshopActivity bruceshopActivity) {
		return super.findPage(page, bruceshopActivity);
	}
	
	@Transactional(readOnly = false)
	public void save(BruceshopActivity bruceshopActivity) {
		super.save(bruceshopActivity);
	}
	
	@Transactional(readOnly = false)
	public void delete(BruceshopActivity bruceshopActivity) {
		super.delete(bruceshopActivity);
	}
	
}