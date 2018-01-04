/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.entity.order;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 订单类型Entity
 * @author admin
 * @version 2017-11-15
 */
public class BruceshopOrder extends DataEntity<BruceshopOrder> {
	
	private static final long serialVersionUID = 1L;
	private String orderno;		// 订单号
	private String userid;		// 会员昵称
	private Integer paytype;		// 支付方式
	private Integer paystatus;		// 支付状态
	private Integer orderstatus;		// 订单状态
	private Double amount;		// 订单总额
	private Double fee;		// 订单运费
	private Integer quantity;		// 商品总数量
	private String city;		// 送货地址
	private String address;		// 详细地址
	private String expressno;		// 快递运单号
	private String expresscompanyname;		// 快递公司名称
	
	private String usernickname; //昵称
	
	private String cityName; //送货城市
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getUsernickname() {
		return usernickname;
	}

	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}

	public BruceshopOrder() {
		super();
	}

	public BruceshopOrder(String id){
		super(id);
	}

	@Length(min=0, max=255, message="订单号长度必须介于 0 和 255 之间")
	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	
	@Length(min=0, max=64, message="会员昵称长度必须介于 0 和 64 之间")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public Integer getPaytype() {
		return paytype;
	}

	public void setPaytype(Integer paytype) {
		this.paytype = paytype;
	}
	
	public Integer getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
	
	public Integer getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Length(min=0, max=255, message="送货地址长度必须介于 0 和 255 之间")
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
	
	@Length(min=0, max=255, message="快递运单号长度必须介于 0 和 255 之间")
	public String getExpressno() {
		return expressno;
	}

	public void setExpressno(String expressno) {
		this.expressno = expressno;
	}
	
	@Length(min=0, max=255, message="快递公司名称长度必须介于 0 和 255 之间")
	public String getExpresscompanyname() {
		return expresscompanyname;
	}

	public void setExpresscompanyname(String expresscompanyname) {
		this.expresscompanyname = expresscompanyname;
	}
	
}