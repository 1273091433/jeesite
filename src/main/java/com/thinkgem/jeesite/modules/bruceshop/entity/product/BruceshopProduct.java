/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.entity.product;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商品管理Entity
 * @author admin
 * @version 2017-11-13
 */
public class BruceshopProduct extends DataEntity<BruceshopProduct> {
	
	private static final long serialVersionUID = 1L;
	private String categoryId;		// 商品分类
	private String name;		// 商品名称
	private String subtitle;		// 商品副标题
	private String mainImage;		// 商品主图
	private String detail;		// 商品详情
	private Double price;		// 商品价格
	private Integer stock;		// 库存数量
	private Integer status;		// 商品状态
	private String brandId;		// 商品品牌
	private String warehouse;		// 仓库
	private String categoryName;
	private String brandName;
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BruceshopProduct() {
		super();
	}

	public BruceshopProduct(String id){
		super(id);
	}

	@Length(min=0, max=64, message="商品分类长度必须介于 0 和 64 之间")
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@Length(min=0, max=100, message="商品名称长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=200, message="商品副标题长度必须介于 0 和 200 之间")
	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
	@Length(min=0, max=500, message="商品主图长度必须介于 0 和 500 之间")
	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Length(min=0, max=64, message="商品品牌长度必须介于 0 和 64 之间")
	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	
	@Length(min=0, max=255, message="仓库长度必须介于 0 和 255 之间")
	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	
}