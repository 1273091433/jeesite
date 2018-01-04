/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.entity.notice;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 公告信息Entity
 * @author admin
 * @version 2017-11-16
 */
public class BruceshopNotice extends DataEntity<BruceshopNotice> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 公告标题
	private String content;		// 公告内容
	
	public BruceshopNotice() {
		super();
	}

	public BruceshopNotice(String id){
		super(id);
	}

	@Length(min=0, max=255, message="公告标题长度必须介于 0 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}