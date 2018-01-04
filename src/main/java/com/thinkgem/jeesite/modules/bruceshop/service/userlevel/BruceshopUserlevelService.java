/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.service.userlevel;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bruceshop.entity.userlevel.BruceshopUserlevel;
import com.thinkgem.jeesite.modules.bruceshop.dao.userlevel.BruceshopUserlevelDao;

/**
 * 会员等级Service
 * @author admin
 * @version 2017-11-14
 */
@Service
@Transactional(readOnly = true)
public class BruceshopUserlevelService extends CrudService<BruceshopUserlevelDao, BruceshopUserlevel> {

	public BruceshopUserlevel get(String id) {
		return super.get(id);
	}
	
	public List<BruceshopUserlevel> findList(BruceshopUserlevel bruceshopUserlevel) {
		return super.findList(bruceshopUserlevel);
	}
	
	public Page<BruceshopUserlevel> findPage(Page<BruceshopUserlevel> page, BruceshopUserlevel bruceshopUserlevel) {
		return super.findPage(page, bruceshopUserlevel);
		/**
		 *  Page<BruceshopUserlevel> findPage = super.findPage(page, bruceshopUserlevel);
		 List<BruceshopUserlevel> list = findPage.getList();
		 for (BruceshopUserlevel b : list) {
			b.setScoreRange(b.getMinscore()+"~"+b.getMaxscore());
		}
		 return findPage;
		 */
	}
	
	@Transactional(readOnly = false)
	public void save(BruceshopUserlevel bruceshopUserlevel) {
		super.save(bruceshopUserlevel);
	}
	
	@Transactional(readOnly = false)
	public void delete(BruceshopUserlevel bruceshopUserlevel) {
		super.delete(bruceshopUserlevel);
	}
	
}