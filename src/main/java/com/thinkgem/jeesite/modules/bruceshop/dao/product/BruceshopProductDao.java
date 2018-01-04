/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.dao.product;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.bruceshop.entity.product.BruceshopProduct;

/**
 * 商品管理DAO接口
 * @author admin
 * @version 2017-11-13
 */
@MyBatisDao
public interface BruceshopProductDao extends CrudDao<BruceshopProduct> {
	
}