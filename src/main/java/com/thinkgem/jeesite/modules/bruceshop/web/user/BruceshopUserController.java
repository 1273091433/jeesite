/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.web.user;

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
import com.thinkgem.jeesite.modules.bruceshop.entity.user.BruceshopUser;
import com.thinkgem.jeesite.modules.bruceshop.entity.userlevel.BruceshopUserlevel;
import com.thinkgem.jeesite.modules.bruceshop.service.user.BruceshopUserService;
import com.thinkgem.jeesite.modules.bruceshop.service.userlevel.BruceshopUserlevelService;
import com.thinkgem.jeesite.modules.bruceshop.utils.OrderNumberGenerratorUtils;

/**
 * 会员管理Controller
 * @author admin
 * @version 2017-11-14
 */
@Controller
@RequestMapping(value = "${adminPath}/bruceshop/user/bruceshopUser")
public class BruceshopUserController extends BaseController {

	@Autowired
	private BruceshopUserService bruceshopUserService;
	
	@Autowired 
	private BruceshopUserlevelService bruceshopUserlevelService;
	
	@ModelAttribute
	public BruceshopUser get(@RequestParam(required=false) String id) {
		BruceshopUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bruceshopUserService.get(id);
		}
		if (entity == null){
			entity = new BruceshopUser();
		}
		return entity;
	}
	
	@RequiresPermissions("bruceshop:user:bruceshopUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(BruceshopUser bruceshopUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		bruceshopUser.setIslock(0);
		Page<BruceshopUser> page = bruceshopUserService.findPage(new Page<BruceshopUser>(request, response), bruceshopUser); 
		model.addAttribute("page", page);
		return "modules/bruceshop/user/bruceshopUserList";
	}
	
	@RequiresPermissions("bruceshop:user:bruceshopUser:view")
	@RequestMapping(value = "lockList")
	public String lockList(BruceshopUser bruceshopUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		bruceshopUser.setIslock(1);
		Page<BruceshopUser> page = bruceshopUserService.findPage(new Page<BruceshopUser>(request, response), bruceshopUser); 
		model.addAttribute("page", page);
		return "modules/bruceshop/user/bruceshopLockUserList";
	}

	@RequiresPermissions("bruceshop:user:bruceshopUser:view")
	@RequestMapping(value = "form")
	public String form(BruceshopUser bruceshopUser, Model model) {
		List<BruceshopUserlevel> userLevelList = bruceshopUserlevelService.findList(new BruceshopUserlevel());
		model.addAttribute("bruceshopUser", bruceshopUser);
		model.addAttribute("userLevelList", userLevelList);
		return "modules/bruceshop/user/bruceshopUserForm";
	}

	@RequiresPermissions("bruceshop:user:bruceshopUser:edit")
	@RequestMapping(value = "save")
	public String save(BruceshopUser bruceshopUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bruceshopUser)){
			return form(bruceshopUser, model);
		}
		bruceshopUserService.save(bruceshopUser);
		addMessage(redirectAttributes, "保存会员管理成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/user/bruceshopUser/?repage";
	}
	
	@RequiresPermissions("bruceshop:user:bruceshopUser:edit")
	@RequestMapping(value = "delete")
	public String delete(BruceshopUser bruceshopUser, RedirectAttributes redirectAttributes) {
		bruceshopUserService.delete(bruceshopUser);
		addMessage(redirectAttributes, "删除会员管理成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/user/bruceshopUser/?repage";
	}
	
	@RequiresPermissions("bruceshop:user:bruceshopUser:edit")
	@RequestMapping(value = "islock")
	public String islock(BruceshopUser bruceshopUser, RedirectAttributes redirectAttributes) {
		bruceshopUser.setIslock(1);
		bruceshopUserService.islock(bruceshopUser);
		addMessage(redirectAttributes, "冻结会员管理成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/user/bruceshopUser/?repage";
	}
	
	@RequiresPermissions("bruceshop:user:bruceshopUser:edit")
	@RequestMapping(value = "unlock")
	public String unlock(BruceshopUser bruceshopUser, RedirectAttributes redirectAttributes) {
		bruceshopUser.setIslock(0);
		bruceshopUserService.islock(bruceshopUser);
		addMessage(redirectAttributes, "恢复会员管理成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/user/bruceshopUser/lockList";
	}

}