/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.classes.web.cal;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.classes.entity.cal.Classes;
import com.thinkgem.jeesite.modules.classes.service.cal.ClassesService;

/**
 * 日用百货分类Controller
 * @author admin
 * @version 2017-11-10
 */
@Controller
@RequestMapping(value = "${adminPath}/classes/cal/classes")
public class ClassesController extends BaseController {

	@Autowired
	private ClassesService classesService;
	
	@ModelAttribute
	public Classes get(@RequestParam(required=false) String id) {
		Classes entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = classesService.get(id);
		}
		if (entity == null){
			entity = new Classes();
		}
		return entity;
	}
	
	@RequiresPermissions("classes:cal:classes:view")
	@RequestMapping(value = {"list", ""})
	public String list(Classes classes, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Classes> list = classesService.findList(classes); 
		model.addAttribute("list", list);
		return "modules/classes/cal/classesList";
	}

	@RequiresPermissions("classes:cal:classes:view")
	@RequestMapping(value = "form")
	public String form(Classes classes, Model model) {
		if (classes.getParent()!=null && StringUtils.isNotBlank(classes.getParent().getId())){
			classes.setParent(classesService.get(classes.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(classes.getId())){
				Classes classesChild = new Classes();
				classesChild.setParent(new Classes(classes.getParent().getId()));
				List<Classes> list = classesService.findList(classes); 
				if (list.size() > 0){
					classes.setSort(list.get(list.size()-1).getSort());
					if (classes.getSort() != null){
						classes.setSort(classes.getSort() + 30);
					}
				}
			}
		}
		if (classes.getSort() == null){
			classes.setSort(30);
		}
		model.addAttribute("classes", classes);
		return "modules/classes/cal/classesForm";
	}

	@RequiresPermissions("classes:cal:classes:edit")
	@RequestMapping(value = "save")
	public String save(Classes classes, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, classes)){
			return form(classes, model);
		}
		classesService.save(classes);
		addMessage(redirectAttributes, "保存日用百货分类成功");
		return "redirect:"+Global.getAdminPath()+"/classes/cal/classes/?repage";
	}
	
	@RequiresPermissions("classes:cal:classes:edit")
	@RequestMapping(value = "delete")
	public String delete(Classes classes, RedirectAttributes redirectAttributes) {
		classesService.delete(classes);
		addMessage(redirectAttributes, "删除日用百货分类成功");
		return "redirect:"+Global.getAdminPath()+"/classes/cal/classes/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Classes> list = classesService.findList(new Classes());
		for (int i=0; i<list.size(); i++){
			Classes e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
}