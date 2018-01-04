/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.web.userlevel;

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
import com.thinkgem.jeesite.modules.bruceshop.entity.userlevel.BruceshopUserlevel;
import com.thinkgem.jeesite.modules.bruceshop.service.userlevel.BruceshopUserlevelService;

/**
 * 会员等级Controller
 * @author admin
 * @version 2017-11-14
 */
@Controller
@RequestMapping(value = "${adminPath}/bruceshop/userlevel/bruceshopUserlevel")
public class BruceshopUserlevelController extends BaseController {

	@Autowired
	private BruceshopUserlevelService bruceshopUserlevelService;
	
	@ModelAttribute
	public BruceshopUserlevel get(@RequestParam(required=false) String id) {
		BruceshopUserlevel entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bruceshopUserlevelService.get(id);
		}
		if (entity == null){
			entity = new BruceshopUserlevel();
		}
		return entity;
	}
	
	@RequiresPermissions("bruceshop:userlevel:bruceshopUserlevel:view")
	@RequestMapping(value = {"list", ""})
	public String list(BruceshopUserlevel bruceshopUserlevel, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BruceshopUserlevel> page = bruceshopUserlevelService.findPage(new Page<BruceshopUserlevel>(request, response), bruceshopUserlevel); 
		model.addAttribute("page", page);
		return "modules/bruceshop/userlevel/bruceshopUserlevelList";
	}

	@RequiresPermissions("bruceshop:userlevel:bruceshopUserlevel:view")
	@RequestMapping(value = "form")
	public String form(BruceshopUserlevel bruceshopUserlevel, Model model) {
		model.addAttribute("bruceshopUserlevel", bruceshopUserlevel);
		return "modules/bruceshop/userlevel/bruceshopUserlevelForm";
	}

	@RequiresPermissions("bruceshop:userlevel:bruceshopUserlevel:edit")
	@RequestMapping(value = "save")
	public String save(BruceshopUserlevel bruceshopUserlevel, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bruceshopUserlevel)){
			return form(bruceshopUserlevel, model);
		}
		bruceshopUserlevelService.save(bruceshopUserlevel);
		addMessage(redirectAttributes, "保存会员等级成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/userlevel/bruceshopUserlevel/?repage";
	}
	
	@RequiresPermissions("bruceshop:userlevel:bruceshopUserlevel:edit")
	@RequestMapping(value = "delete")
	public String delete(BruceshopUserlevel bruceshopUserlevel, RedirectAttributes redirectAttributes) {
		bruceshopUserlevelService.delete(bruceshopUserlevel);
		addMessage(redirectAttributes, "删除会员等级成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/userlevel/bruceshopUserlevel/?repage";
	}

}