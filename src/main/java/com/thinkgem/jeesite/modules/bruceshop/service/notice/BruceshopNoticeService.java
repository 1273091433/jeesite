/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.service.notice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bruceshop.entity.notice.BruceshopNotice;
import com.thinkgem.jeesite.modules.bruceshop.dao.notice.BruceshopNoticeDao;

/**
 * 公告信息Service
 * @author admin
 * @version 2017-11-16
 */
@Service
@Transactional(readOnly = true)
public class BruceshopNoticeService extends CrudService<BruceshopNoticeDao, BruceshopNotice> {

	public BruceshopNotice get(String id) {
		return super.get(id);
	}
	
	public List<BruceshopNotice> findList(BruceshopNotice bruceshopNotice) {
		return super.findList(bruceshopNotice);
	}
	
	public Page<BruceshopNotice> findPage(Page<BruceshopNotice> page, BruceshopNotice bruceshopNotice) {
		return super.findPage(page, bruceshopNotice);
	}
	
	@Transactional(readOnly = false)
	public void save(BruceshopNotice bruceshopNotice) {
		super.save(bruceshopNotice);
	}
	
	@Transactional(readOnly = false)
	public void delete(BruceshopNotice bruceshopNotice) {
		super.delete(bruceshopNotice);
	}
	
}