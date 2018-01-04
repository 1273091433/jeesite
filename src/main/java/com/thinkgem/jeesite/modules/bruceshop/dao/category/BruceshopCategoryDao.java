/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.dao.category;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.bruceshop.entity.category.BruceshopCategory;

/**
 * 商品分类管理DAO接口
 * @author admin
 * @version 2017-11-08
 */
@MyBatisDao
public interface BruceshopCategoryDao extends TreeDao<BruceshopCategory> {
	
}