/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.entity.activity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 促销活动Entity
 * @author admin
 * @version 2017-11-16
 */
public class BruceshopActivity extends DataEntity<BruceshopActivity> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 活动标题
	private String picture;		// 活动图片
	private String content;		// 活动描述
	
	public BruceshopActivity() {
		super();
	}

	public BruceshopActivity(String id){
		super(id);
	}

	@Length(min=0, max=255, message="活动标题长度必须介于 0 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=1024, message="活动图片长度必须介于 0 和 1024 之间")
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}