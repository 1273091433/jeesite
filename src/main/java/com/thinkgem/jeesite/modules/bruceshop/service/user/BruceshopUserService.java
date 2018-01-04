/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bruceshop.entity.user.BruceshopUser;
import com.thinkgem.jeesite.modules.bruceshop.dao.user.BruceshopUserDao;

/**
 * 会员管理Service
 * @author admin
 * @version 2017-11-14
 */
@Service
@Transactional(readOnly = true)
public class BruceshopUserService extends CrudService<BruceshopUserDao, BruceshopUser> {

	@Autowired
	private BruceshopUserDao userDao;
	
	public BruceshopUser get(String id) {
		return super.get(id);
	}
	
	public List<BruceshopUser> findList(BruceshopUser bruceshopUser) {
		return super.findList(bruceshopUser);
	}
	
	public Page<BruceshopUser> findPage(Page<BruceshopUser> page, BruceshopUser bruceshopUser) {
		return super.findPage(page, bruceshopUser);
	}
	
	@Transactional(readOnly = false)
	public void save(BruceshopUser bruceshopUser) {
		super.save(bruceshopUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(BruceshopUser bruceshopUser) {
		super.delete(bruceshopUser);
	}
	
	@Transactional(readOnly = false)
	public void islock(BruceshopUser bruceshopUser) {
		userDao.islock(bruceshopUser);
	}
	
}