/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.web.category;

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
import com.thinkgem.jeesite.modules.bruceshop.entity.category.BruceshopCategory;
import com.thinkgem.jeesite.modules.bruceshop.service.category.BruceshopCategoryService;

/**
 * 商品分类管理Controller
 * @author admin
 * @version 2017-11-08
 */
@Controller
@RequestMapping(value = "${adminPath}/bruceshop/category/bruceshopCategory")
public class BruceshopCategoryController extends BaseController {

	@Autowired
	private BruceshopCategoryService bruceshopCategoryService;
	
	@ModelAttribute
	public BruceshopCategory get(@RequestParam(required=false) String id) {
		BruceshopCategory entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bruceshopCategoryService.get(id);
		}
		if (entity == null){
			entity = new BruceshopCategory();
		}
		return entity;
	}
	
	@RequiresPermissions("bruceshop:category:bruceshopCategory:view")
	@RequestMapping(value = {"list", ""})
	public String list(BruceshopCategory bruceshopCategory, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<BruceshopCategory> list = bruceshopCategoryService.findList(bruceshopCategory); 
		model.addAttribute("list", list);
		return "modules/bruceshop/category/bruceshopCategoryList";
	}

	@RequiresPermissions("bruceshop:category:bruceshopCategory:view")
	@RequestMapping(value = "form")
	public String form(BruceshopCategory bruceshopCategory, Model model) {
		if (bruceshopCategory.getParent()!=null && StringUtils.isNotBlank(bruceshopCategory.getParent().getId())){
			bruceshopCategory.setParent(bruceshopCategoryService.get(bruceshopCategory.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(bruceshopCategory.getId())){
				BruceshopCategory bruceshopCategoryChild = new BruceshopCategory();
				bruceshopCategoryChild.setParent(new BruceshopCategory(bruceshopCategory.getParent().getId()));
				List<BruceshopCategory> list = bruceshopCategoryService.findList(bruceshopCategory); 
				if (list.size() > 0){
					bruceshopCategory.setSort(list.get(list.size()-1).getSort());
					if (bruceshopCategory.getSort() != null){
						bruceshopCategory.setSort(bruceshopCategory.getSort() + 30);
					}
				}
			}
		}
		if (bruceshopCategory.getSort() == null){
			bruceshopCategory.setSort(30);
		}
		model.addAttribute("bruceshopCategory", bruceshopCategory);
		return "modules/bruceshop/category/bruceshopCategoryForm";
	}

	@RequiresPermissions("bruceshop:category:bruceshopCategory:edit")
	@RequestMapping(value = "save")
	public String save(BruceshopCategory bruceshopCategory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bruceshopCategory)){
			return form(bruceshopCategory, model);
		}
		bruceshopCategoryService.save(bruceshopCategory);
		addMessage(redirectAttributes, "保存商品分类成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/category/bruceshopCategory/?repage";
	}
	
	@RequiresPermissions("bruceshop:category:bruceshopCategory:edit")
	@RequestMapping(value = "delete")
	public String delete(BruceshopCategory bruceshopCategory, RedirectAttributes redirectAttributes) {
		bruceshopCategoryService.delete(bruceshopCategory);
		addMessage(redirectAttributes, "删除商品分类成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/category/bruceshopCategory/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<BruceshopCategory> list = bruceshopCategoryService.findAll();
		for (int i=0; i<list.size(); i++){
			BruceshopCategory e = list.get(i);
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