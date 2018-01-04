/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.service.order;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bruceshop.entity.order.BruceshopOrder;
import com.thinkgem.jeesite.modules.bruceshop.dao.order.BruceshopOrderDao;

/**
 * 订单类型Service
 * @author admin
 * @version 2017-11-15
 */
@Service
@Transactional(readOnly = true)
public class BruceshopOrderService extends CrudService<BruceshopOrderDao, BruceshopOrder> {

	public BruceshopOrder get(String id) {
		return super.get(id);
	}
	
	public List<BruceshopOrder> findList(BruceshopOrder bruceshopOrder) {
		return super.findList(bruceshopOrder);
	}
	
	public Page<BruceshopOrder> findPage(Page<BruceshopOrder> page, BruceshopOrder bruceshopOrder) {
		return super.findPage(page, bruceshopOrder);
	}
	
	@Transactional(readOnly = false)
	public void save(BruceshopOrder bruceshopOrder) {
		super.save(bruceshopOrder);
	}
	
	@Transactional(readOnly = false)
	public void delete(BruceshopOrder bruceshopOrder) {
		super.delete(bruceshopOrder);
	}
	
}