/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.entity.warehouse;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 仓库管理Entity
 * @author admin
 * @version 2017-11-13
 */
public class BruceshopWarehouse extends DataEntity<BruceshopWarehouse> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 仓库名称
	private String city;		// 仓库所在城市
	private String address;		// 仓库详细地址
	
	private String cityName;
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public BruceshopWarehouse() {
		super();
	}

	public BruceshopWarehouse(String id){
		super(id);
	}

	@Length(min=0, max=255, message="仓库名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="仓库所在城市长度必须介于 0 和 255 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}