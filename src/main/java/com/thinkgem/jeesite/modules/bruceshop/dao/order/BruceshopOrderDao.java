/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.dao.order;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.bruceshop.entity.order.BruceshopOrder;

/**
 * 订单类型DAO接口
 * @author admin
 * @version 2017-11-15
 */
@MyBatisDao
public interface BruceshopOrderDao extends CrudDao<BruceshopOrder> {
	
}