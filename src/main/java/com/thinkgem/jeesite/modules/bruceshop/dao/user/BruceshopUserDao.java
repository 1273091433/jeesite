/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.dao.user;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.bruceshop.entity.user.BruceshopUser;

/**
 * 会员管理DAO接口
 * @author admin
 * @version 2017-11-14
 */
@MyBatisDao
public interface BruceshopUserDao extends CrudDao<BruceshopUser> {

	Integer islock(BruceshopUser bruceshopUser);
	
}