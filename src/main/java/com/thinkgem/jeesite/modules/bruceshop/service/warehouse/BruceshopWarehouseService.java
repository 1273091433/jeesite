/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.service.warehouse;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bruceshop.entity.warehouse.BruceshopWarehouse;
import com.thinkgem.jeesite.modules.bruceshop.dao.warehouse.BruceshopWarehouseDao;

/**
 * 仓库管理Service
 * @author admin
 * @version 2017-11-13
 */
@Service
@Transactional(readOnly = true)
public class BruceshopWarehouseService extends CrudService<BruceshopWarehouseDao, BruceshopWarehouse> {

	public BruceshopWarehouse get(String id) {
		return super.get(id);
	}
	
	public List<BruceshopWarehouse> findList(BruceshopWarehouse bruceshopWarehouse) {
		return super.findList(bruceshopWarehouse);
	}
	
	public Page<BruceshopWarehouse> findPage(Page<BruceshopWarehouse> page, BruceshopWarehouse bruceshopWarehouse) {
		return super.findPage(page, bruceshopWarehouse);
	}
	
	@Transactional(readOnly = false)
	public void save(BruceshopWarehouse bruceshopWarehouse) {
		super.save(bruceshopWarehouse);
	}
	
	@Transactional(readOnly = false)
	public void delete(BruceshopWarehouse bruceshopWarehouse) {
		super.delete(bruceshopWarehouse);
	}
	
}