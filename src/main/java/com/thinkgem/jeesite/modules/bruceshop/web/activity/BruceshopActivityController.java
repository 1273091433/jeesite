/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.web.activity;

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
import com.thinkgem.jeesite.modules.bruceshop.entity.activity.BruceshopActivity;
import com.thinkgem.jeesite.modules.bruceshop.service.activity.BruceshopActivityService;

/**
 * 促销活动Controller
 * @author admin
 * @version 2017-11-16
 */
@Controller
@RequestMapping(value = "${adminPath}/bruceshop/activity/bruceshopActivity")
public class BruceshopActivityController extends BaseController {

	@Autowired
	private BruceshopActivityService bruceshopActivityService;
	
	@ModelAttribute
	public BruceshopActivity get(@RequestParam(required=false) String id) {
		BruceshopActivity entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bruceshopActivityService.get(id);
		}
		if (entity == null){
			entity = new BruceshopActivity();
		}
		return entity;
	}
	
	@RequiresPermissions("bruceshop:activity:bruceshopActivity:view")
	@RequestMapping(value = {"list", ""})
	public String list(BruceshopActivity bruceshopActivity, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BruceshopActivity> page = bruceshopActivityService.findPage(new Page<BruceshopActivity>(request, response), bruceshopActivity); 
		model.addAttribute("page", page);
		return "modules/bruceshop/activity/bruceshopActivityList";
	}

	@RequiresPermissions("bruceshop:activity:bruceshopActivity:view")
	@RequestMapping(value = "form")
	public String form(BruceshopActivity bruceshopActivity, Model model) {
		model.addAttribute("bruceshopActivity", bruceshopActivity);
		return "modules/bruceshop/activity/bruceshopActivityForm";
	}

	@RequiresPermissions("bruceshop:activity:bruceshopActivity:edit")
	@RequestMapping(value = "save")
	public String save(BruceshopActivity bruceshopActivity, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bruceshopActivity)){
			return form(bruceshopActivity, model);
		}
		bruceshopActivityService.save(bruceshopActivity);
		addMessage(redirectAttributes, "保存促销活动成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/activity/bruceshopActivity/?repage";
	}
	
	@RequiresPermissions("bruceshop:activity:bruceshopActivity:edit")
	@RequestMapping(value = "delete")
	public String delete(BruceshopActivity bruceshopActivity, RedirectAttributes redirectAttributes) {
		bruceshopActivityService.delete(bruceshopActivity);
		addMessage(redirectAttributes, "删除促销活动成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/activity/bruceshopActivity/?repage";
	}

}