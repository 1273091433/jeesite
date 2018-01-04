/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.web.warehouse;

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
import com.thinkgem.jeesite.modules.bruceshop.entity.warehouse.BruceshopWarehouse;
import com.thinkgem.jeesite.modules.bruceshop.service.warehouse.BruceshopWarehouseService;

/**
 * 仓库管理Controller
 * @author admin
 * @version 2017-11-13
 */
@Controller
@RequestMapping(value = "${adminPath}/bruceshop/warehouse/bruceshopWarehouse")
public class BruceshopWarehouseController extends BaseController {

	@Autowired
	private BruceshopWarehouseService bruceshopWarehouseService;
	
	@ModelAttribute
	public BruceshopWarehouse get(@RequestParam(required=false) String id) {
		BruceshopWarehouse entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bruceshopWarehouseService.get(id);
		}
		if (entity == null){
			entity = new BruceshopWarehouse();
		}
		return entity;
	}
	
	@RequiresPermissions("bruceshop:warehouse:bruceshopWarehouse:view")
	@RequestMapping(value = {"list", ""})
	public String list(BruceshopWarehouse bruceshopWarehouse, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BruceshopWarehouse> page = bruceshopWarehouseService.findPage(new Page<BruceshopWarehouse>(request, response), bruceshopWarehouse); 
		model.addAttribute("page", page);
		return "modules/bruceshop/warehouse/bruceshopWarehouseList";
	}

	@RequiresPermissions("bruceshop:warehouse:bruceshopWarehouse:view")
	@RequestMapping(value = "form")
	public String form(BruceshopWarehouse bruceshopWarehouse, Model model) {
		model.addAttribute("bruceshopWarehouse", bruceshopWarehouse);
		return "modules/bruceshop/warehouse/bruceshopWarehouseForm";
	}

	@RequiresPermissions("bruceshop:warehouse:bruceshopWarehouse:edit")
	@RequestMapping(value = "save")
	public String save(BruceshopWarehouse bruceshopWarehouse, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bruceshopWarehouse)){
			return form(bruceshopWarehouse, model);
		}
		bruceshopWarehouseService.save(bruceshopWarehouse);
		addMessage(redirectAttributes, "保存仓库管理成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/warehouse/bruceshopWarehouse/?repage";
	}
	
	@RequiresPermissions("bruceshop:warehouse:bruceshopWarehouse:edit")
	@RequestMapping(value = "delete")
	public String delete(BruceshopWarehouse bruceshopWarehouse, RedirectAttributes redirectAttributes) {
		bruceshopWarehouseService.delete(bruceshopWarehouse);
		addMessage(redirectAttributes, "删除仓库管理成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/warehouse/bruceshopWarehouse/?repage";
	}

}