/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.dao.warehouse;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.bruceshop.entity.warehouse.BruceshopWarehouse;

/**
 * 仓库管理DAO接口
 * @author admin
 * @version 2017-11-13
 */
@MyBatisDao
public interface BruceshopWarehouseDao extends CrudDao<BruceshopWarehouse> {
	
}