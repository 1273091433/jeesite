/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.dao.brand;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.bruceshop.entity.brand.BruceshopBrand;

/**
 * 商品品牌DAO接口
 * @author admin
 * @version 2017-11-11
 */
@MyBatisDao
public interface BruceshopBrandDao extends CrudDao<BruceshopBrand> {
	
}