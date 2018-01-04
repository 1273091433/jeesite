/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.web.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.bruceshop.entity.brand.BruceshopBrand;
import com.thinkgem.jeesite.modules.bruceshop.entity.product.BruceshopProduct;
import com.thinkgem.jeesite.modules.bruceshop.entity.warehouse.BruceshopWarehouse;
import com.thinkgem.jeesite.modules.bruceshop.service.brand.BruceshopBrandService;
import com.thinkgem.jeesite.modules.bruceshop.service.product.BruceshopProductService;
import com.thinkgem.jeesite.modules.bruceshop.service.warehouse.BruceshopWarehouseService;

/**
 * 商品管理Controller
 * @author admin
 * @version 2017-11-13
 */
@Controller
@RequestMapping(value = "${adminPath}/bruceshop/product/bruceshopProduct")
public class BruceshopProductController extends BaseController {

	@Autowired
	private BruceshopProductService bruceshopProductService;
	
	@Autowired
	private BruceshopWarehouseService bruceshopWarehouseService;
	
	@Autowired
	private BruceshopBrandService bruceshopBrandService;
	
	@ModelAttribute
	public BruceshopProduct get(@RequestParam(required=false) String id) {
		BruceshopProduct entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bruceshopProductService.get(id);
		}
		if (entity == null){
			entity = new BruceshopProduct();
		}
		return entity;
	}
	
	@RequiresPermissions("bruceshop:product:bruceshopProduct:view")
	@RequestMapping(value = {"list", ""})
	public String list(BruceshopProduct bruceshopProduct, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BruceshopProduct> page = bruceshopProductService.findPage(new Page<BruceshopProduct>(request, response), bruceshopProduct); 
		model.addAttribute("page", page);
		return "modules/bruceshop/product/bruceshopProductList";
	}

	@RequiresPermissions("bruceshop:product:bruceshopProduct:view")
	@RequestMapping(value = "form")
	public String form(BruceshopProduct bruceshopProduct, Model model) {
		List<BruceshopWarehouse> warehouseList = bruceshopWarehouseService.findList(new BruceshopWarehouse());
		List<BruceshopBrand> brandList = bruceshopBrandService.findList(new BruceshopBrand());
		model.addAttribute("bruceshopProduct", bruceshopProduct);
		model.addAttribute("warehouseList", warehouseList);
		model.addAttribute("brandList", brandList);
		return "modules/bruceshop/product/bruceshopProductForm";
	}

	@RequiresPermissions("bruceshop:product:bruceshopProduct:edit")
	@RequestMapping(value = "save")
	public String save(BruceshopProduct bruceshopProduct, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bruceshopProduct)){
			return form(bruceshopProduct, model);
		}
		bruceshopProductService.save(bruceshopProduct);
		addMessage(redirectAttributes, "保存商品管理成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/product/bruceshopProduct/?repage";
	}
	
	@RequiresPermissions("bruceshop:product:bruceshopProduct:edit")
	@RequestMapping(value = "delete")
	public String delete(BruceshopProduct bruceshopProduct, RedirectAttributes redirectAttributes) {
		bruceshopProductService.delete(bruceshopProduct);
		addMessage(redirectAttributes, "删除商品管理成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/product/bruceshopProduct/?repage";
	}

}