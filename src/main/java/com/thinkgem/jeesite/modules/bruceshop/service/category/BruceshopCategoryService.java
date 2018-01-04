/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.service.category;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.TreeService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.bruceshop.entity.category.BruceshopCategory;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.bruceshop.dao.category.BruceshopCategoryDao;

/**
 * 商品分类管理Service
 * @author admin
 * @version 2017-11-08
 */
@Service
@Transactional(readOnly = true)
public class BruceshopCategoryService extends TreeService<BruceshopCategoryDao, BruceshopCategory> {

	public BruceshopCategory get(String id) {
		return super.get(id);
	}
	
	public List<BruceshopCategory> findList(BruceshopCategory bruceshopCategory) {
		if (StringUtils.isNotBlank(bruceshopCategory.getParentIds())){
			bruceshopCategory.setParentIds(","+bruceshopCategory.getParentIds()+",");
		}
		return super.findList(bruceshopCategory);
	}
	
	public List<BruceshopCategory> findAll(){
		return UserUtils.getBruceshopCategoryList();
	}
	
	@Transactional(readOnly = false)
	public void save(BruceshopCategory bruceshopCategory) {
		super.save(bruceshopCategory);
	}
	
	@Transactional(readOnly = false)
	public void delete(BruceshopCategory bruceshopCategory) {
		super.delete(bruceshopCategory);
	}
	
}