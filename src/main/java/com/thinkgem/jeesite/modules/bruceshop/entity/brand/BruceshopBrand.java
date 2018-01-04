/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.entity.brand;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商品品牌Entity
 * @author admin
 * @version 2017-11-11
 */
public class BruceshopBrand extends DataEntity<BruceshopBrand> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 品牌名称
	private String bandurl;		// 品牌图片
	public BruceshopBrand() {
		super();
	}

	public BruceshopBrand(String id){
		super(id);
	}

	@Length(min=0, max=255, message="品牌名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=1024, message="品牌图片长度必须介于 0 和 1024 之间")
	public String getBandurl() {
		return bandurl;
	}

	public void setBandurl(String bandurl) {
		this.bandurl = bandurl;
	}
	
}