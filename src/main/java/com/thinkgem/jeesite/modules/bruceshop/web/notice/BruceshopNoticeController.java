/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.web.notice;

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
import com.thinkgem.jeesite.modules.bruceshop.entity.notice.BruceshopNotice;
import com.thinkgem.jeesite.modules.bruceshop.service.notice.BruceshopNoticeService;

/**
 * 公告信息Controller
 * @author admin
 * @version 2017-11-16
 */
@Controller
@RequestMapping(value = "${adminPath}/bruceshop/notice/bruceshopNotice")
public class BruceshopNoticeController extends BaseController {

	@Autowired
	private BruceshopNoticeService bruceshopNoticeService;
	
	@ModelAttribute
	public BruceshopNotice get(@RequestParam(required=false) String id) {
		BruceshopNotice entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bruceshopNoticeService.get(id);
		}
		if (entity == null){
			entity = new BruceshopNotice();
		}
		return entity;
	}
	
	@RequiresPermissions("bruceshop:notice:bruceshopNotice:view")
	@RequestMapping(value = {"list", ""})
	public String list(BruceshopNotice bruceshopNotice, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BruceshopNotice> page = bruceshopNoticeService.findPage(new Page<BruceshopNotice>(request, response), bruceshopNotice); 
		model.addAttribute("page", page);
		return "modules/bruceshop/notice/bruceshopNoticeList";
	}

	@RequiresPermissions("bruceshop:notice:bruceshopNotice:view")
	@RequestMapping(value = "form")
	public String form(BruceshopNotice bruceshopNotice, Model model) {
		model.addAttribute("bruceshopNotice", bruceshopNotice);
		return "modules/bruceshop/notice/bruceshopNoticeForm";
	}

	@RequiresPermissions("bruceshop:notice:bruceshopNotice:edit")
	@RequestMapping(value = "save")
	public String save(BruceshopNotice bruceshopNotice, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bruceshopNotice)){
			return form(bruceshopNotice, model);
		}
		bruceshopNoticeService.save(bruceshopNotice);
		addMessage(redirectAttributes, "保存公告信息成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/notice/bruceshopNotice/?repage";
	}
	
	@RequiresPermissions("bruceshop:notice:bruceshopNotice:edit")
	@RequestMapping(value = "delete")
	public String delete(BruceshopNotice bruceshopNotice, RedirectAttributes redirectAttributes) {
		bruceshopNoticeService.delete(bruceshopNotice);
		addMessage(redirectAttributes, "删除公告信息成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/notice/bruceshopNotice/?repage";
	}

}