/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.service.brand;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bruceshop.entity.brand.BruceshopBrand;
import com.thinkgem.jeesite.modules.bruceshop.dao.brand.BruceshopBrandDao;

/**
 * 商品品牌Service
 * @author admin
 * @version 2017-11-11
 */
@Service
@Transactional(readOnly = true)
public class BruceshopBrandService extends CrudService<BruceshopBrandDao, BruceshopBrand> {

	public BruceshopBrand get(String id) {
		return super.get(id);
	}
	
	public List<BruceshopBrand> findList(BruceshopBrand bruceshopBrand) {
		return super.findList(bruceshopBrand);
	}
	
	public Page<BruceshopBrand> findPage(Page<BruceshopBrand> page, BruceshopBrand bruceshopBrand) {
		return super.findPage(page, bruceshopBrand);
	}
	
	@Transactional(readOnly = false)
	public void save(BruceshopBrand bruceshopBrand) {
		super.save(bruceshopBrand);
	}
	
	@Transactional(readOnly = false)
	public void delete(BruceshopBrand bruceshopBrand) {
		super.delete(bruceshopBrand);
	}
	
}