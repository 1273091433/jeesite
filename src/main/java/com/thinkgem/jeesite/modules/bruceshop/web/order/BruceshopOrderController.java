/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bruceshop.web.order;

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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.bruceshop.entity.order.BruceshopOrder;
import com.thinkgem.jeesite.modules.bruceshop.entity.user.BruceshopUser;
import com.thinkgem.jeesite.modules.bruceshop.service.order.BruceshopOrderService;
import com.thinkgem.jeesite.modules.bruceshop.service.user.BruceshopUserService;
import com.thinkgem.jeesite.modules.bruceshop.utils.OrderNumberGenerratorUtils;

/**
 * 订单类型Controller
 * @author admin
 * @version 2017-11-15
 */
@Controller
@RequestMapping(value = "${adminPath}/bruceshop/order/bruceshopOrder")
public class BruceshopOrderController extends BaseController {

	@Autowired
	private BruceshopOrderService bruceshopOrderService;
	@Autowired
	private BruceshopUserService bruceshopUserService;
	
	@ModelAttribute
	public BruceshopOrder get(@RequestParam(required=false) String id) {
		BruceshopOrder entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bruceshopOrderService.get(id);
		}
		if (entity == null){
			entity = new BruceshopOrder();
		}
		return entity;
	}
	
	@RequiresPermissions("bruceshop:order:bruceshopOrder:view")
	@RequestMapping(value = {"list", ""})
	public String list(BruceshopOrder bruceshopOrder, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BruceshopOrder> page = bruceshopOrderService.findPage(new Page<BruceshopOrder>(request, response), bruceshopOrder); 
		model.addAttribute("page", page);
		return "modules/bruceshop/order/bruceshopOrderList";
	}
	
	@RequiresPermissions("bruceshop:order:bruceshopOrder:view")
	@RequestMapping(value = "refundlist")
	public String refundlist(BruceshopOrder bruceshopOrder, HttpServletRequest request, HttpServletResponse response, Model model) {
		bruceshopOrder.setOrderstatus(6);
		Page<BruceshopOrder> page = bruceshopOrderService.findPage(new Page<BruceshopOrder>(request, response), bruceshopOrder); 
		model.addAttribute("page", page);
		return "modules/bruceshop/order/bruceshopRefundOrderList";
	}
	
	@RequiresPermissions("bruceshop:order:bruceshopOrder:view")
	@RequestMapping(value = "returnlist")
	public String returnlist(BruceshopOrder bruceshopOrder, HttpServletRequest request, HttpServletResponse response, Model model) {
		bruceshopOrder.setOrderstatus(7);
		Page<BruceshopOrder> page = bruceshopOrderService.findPage(new Page<BruceshopOrder>(request, response), bruceshopOrder); 
		model.addAttribute("page", page);
		return "modules/bruceshop/order/bruceshopReturnOrderList";
	}
	
	@RequiresPermissions("bruceshop:order:bruceshopOrder:view")
	@RequestMapping(value = "form")
	public String form(BruceshopOrder bruceshopOrder, Model model,HttpServletRequest request) {
		String path = request.getParameter("path");
		BruceshopUser user = new BruceshopUser();
		user.setIslock(0);
		List<BruceshopUser> userList = bruceshopUserService.findList(user);
		model.addAttribute("bruceshopOrder", bruceshopOrder);
		model.addAttribute("userList", userList);
		model.addAttribute("path", path);
		return "modules/bruceshop/order/bruceshopOrderForm";
	}

	@RequiresPermissions("bruceshop:order:bruceshopOrder:edit")
	@RequestMapping(value = "save")
	public String save(BruceshopOrder bruceshopOrder, Model model, RedirectAttributes redirectAttributes,HttpServletRequest request) {
		if(bruceshopOrder.getOrderno()==null || bruceshopOrder.getOrderno().isEmpty()){
			bruceshopOrder.setOrderno(OrderNumberGenerratorUtils.getOrderIdByUUID());
		}
		
		if (!beanValidator(model, bruceshopOrder)){
			return form(bruceshopOrder, model, request);
		}
		String path = request.getParameter("path");
		bruceshopOrderService.save(bruceshopOrder);
		addMessage(redirectAttributes, "保存订单类型成功");
		if (path != null && path != "") {
			return "redirect:"+Global.getAdminPath()+"/bruceshop/order/bruceshopOrder/"+path;
		}
		return "redirect:"+Global.getAdminPath()+"/bruceshop/order/bruceshopOrder/?repage";
	}
	
	@RequiresPermissions("bruceshop:order:bruceshopOrder:edit")
	@RequestMapping(value = "delete")
	public String delete(BruceshopOrder bruceshopOrder, RedirectAttributes redirectAttributes) {
		bruceshopOrderService.delete(bruceshopOrder);
		addMessage(redirectAttributes, "删除订单类型成功");
		return "redirect:"+Global.getAdminPath()+"/bruceshop/order/bruceshopOrder/?repage";
	}

}