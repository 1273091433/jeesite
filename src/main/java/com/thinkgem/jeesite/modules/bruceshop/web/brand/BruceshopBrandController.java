/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.web.brand;

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
import com.thinkgem.jeesite.modules.bruceshop.service.brand.BruceshopBrandService;

/**
 * 商品品牌Controller
 * @author admin
 * @version 2017-11-11
 */
@Controller
@RequestMapping(value = "${adminPath}/bruceshop/brand/bruceshopBrand")
public class BruceshopBrandController extends BaseController {

	@Autowired
	private BruceshopBrandService bruceshopBrandService;
	
	@ModelAttribute
	public BruceshopBrand get(@RequestParam(required=false) String id) {
		BruceshopBrand entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bruceshopBrandService.get(id);
		}
		if (entity == null){
			entity = new BruceshopBrand();
		}
		return entity;
	}
	
	@RequiresPermissions("bruceshop:brand:bruceshopBrand:view")
	@RequestMapping(value = {"list", ""})
	public String list(BruceshopBrand bruceshopBrand, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BruceshopBrand> page = bruceshopBrandService.findPage(new Page<BruceshopBrand>(request, response), bruceshopBrand); 
		model.addAttribute("page", page);
		return "modules/bruceshop/brand/bruceshopBrandList";
	}

	@RequiresPermissions("bruceshop:brand:bruceshopBrand:view")
	@RequestMapping(value = "form")
	public String form(BruceshopBrand bruceshopBrand, Model model) {
		model.addAttribute("bruceshopBrand", bruceshopBrand);
		return "modules/bruceshop/brand/bruceshopBrandForm";
	}

	@RequiresPermissions("bruceshop:brand:bruceshopBrand:edit")
	@RequestMapping(value = "save")
	public String save(BruceshopBrand bruceshopBrand, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bruceshopBrand)){
			return form(bruceshopBrand, model);
		}
		bruceshopBrandService.save(bruceshopBrand);
		addMessage(redirectAttributes, "保存商品品牌成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/brand/bruceshopBrand/?repage";
	}
	
	@RequiresPermissions("bruceshop:brand:bruceshopBrand:edit")
	@RequestMapping(value = "delete")
	public String delete(BruceshopBrand bruceshopBrand, RedirectAttributes redirectAttributes) {
		bruceshopBrandService.delete(bruceshopBrand);
		addMessage(redirectAttributes, "删除商品品牌成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/brand/bruceshopBrand/?repage";
	}

}