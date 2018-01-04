/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.service.product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bruceshop.entity.product.BruceshopProduct;
import com.thinkgem.jeesite.modules.bruceshop.dao.product.BruceshopProductDao;

/**
 * 商品管理Service
 * @author admin
 * @version 2017-11-13
 */
@Service
@Transactional(readOnly = true)
public class BruceshopProductService extends CrudService<BruceshopProductDao, BruceshopProduct> {

	public BruceshopProduct get(String id) {
		return super.get(id);
	}
	
	public List<BruceshopProduct> findList(BruceshopProduct bruceshopProduct) {
		return super.findList(bruceshopProduct);
	}
	
	public Page<BruceshopProduct> findPage(Page<BruceshopProduct> page, BruceshopProduct bruceshopProduct) {
		return super.findPage(page, bruceshopProduct);
	}
	
	@Transactional(readOnly = false)
	public void save(BruceshopProduct bruceshopProduct) {
		super.save(bruceshopProduct);
	}
	
	@Transactional(readOnly = false)
	public void delete(BruceshopProduct bruceshopProduct) {
		super.delete(bruceshopProduct);
	}
	
}