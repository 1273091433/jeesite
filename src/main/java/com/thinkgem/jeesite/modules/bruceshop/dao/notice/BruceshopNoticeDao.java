/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.dao.notice;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.bruceshop.entity.notice.BruceshopNotice;

/**
 * 公告信息DAO接口
 * @author admin
 * @version 2017-11-16
 */
@MyBatisDao
public interface BruceshopNoticeDao extends CrudDao<BruceshopNotice> {
	
}