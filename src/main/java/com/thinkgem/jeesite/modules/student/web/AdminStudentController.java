/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.web;

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
import com.thinkgem.jeesite.modules.student.entity.AdminStudent;
import com.thinkgem.jeesite.modules.student.service.AdminStudentService;

/**
 * 学生信息管理Controller
 * @author admin
 * @version 2018-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/student/adminStudent")
public class AdminStudentController extends BaseController {

	@Autowired
	private AdminStudentService adminStudentService;
	
	@ModelAttribute
	public AdminStudent get(@RequestParam(required=false) String id) {
		AdminStudent entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = adminStudentService.get(id);
		}
		if (entity == null){
			entity = new AdminStudent();
		}
		return entity;
	}
	
	@RequiresPermissions("student:adminStudent:view")
	@RequestMapping(value = {"list", ""})
	public String list(AdminStudent adminStudent, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AdminStudent> page = adminStudentService.findPage(new Page<AdminStudent>(request, response), adminStudent); 
		model.addAttribute("page", page);
		return "modules/student/adminStudentList";
	}

	@RequiresPermissions("student:adminStudent:view")
	@RequestMapping(value = "form")
	public String form(AdminStudent adminStudent, Model model) {
		model.addAttribute("adminStudent", adminStudent);
		return "modules/student/adminStudentForm";
	}

	@RequiresPermissions("student:adminStudent:edit")
	@RequestMapping(value = "save")
	public String save(AdminStudent adminStudent, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, adminStudent)){
			return form(adminStudent, model);
		}
		adminStudentService.save(adminStudent);
		addMessage(redirectAttributes, "保存学生信息成功");
		return "redirect:"+Global.getAdminPath()+"/student/adminStudent/?repage";
	}
	
	@RequiresPermissions("student:adminStudent:edit")
	@RequestMapping(value = "delete")
	public String delete(AdminStudent adminStudent, RedirectAttributes redirectAttributes) {
		adminStudentService.delete(adminStudent);
		addMessage(redirectAttributes, "删除学生信息成功");
		return "redirect:"+Global.getAdminPath()+"/student/adminStudent/?repage";
	}

}