package com.eilikce.osm.shop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.core.bo.transformable.RecordOrder;
import com.eilikce.osm.core.bo.transformable.RecordOrderCommodity;
import com.eilikce.osm.shop.service.OrderService;
import com.eilikce.osm.util.JsonUtil;

@Controller
@RequestMapping("/recordOrder")
public class RecordOrderController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RecordOrderController.class);
	
	@Autowired
	private OrderService service;
	
	/**
	 * 获取订单总数
	 * @return
	 */
	@RequestMapping(value = "/findCount", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView findCount(){
		
		int count = service.getCount();
		ModelAndView modelAndView = new ModelAndView("/test/test");
		modelAndView.addObject("count", count);
		
		return modelAndView;
	}
	
	/**
	 * 根据页数
	 * 获取订单列表
	 * @param page
	 * @param search
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/findRecordOrderBoByPage", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView findRecordOrderBoByPage(@RequestParam(value = "page" , required=false) Integer page ,@RequestParam(value = "search" , required=false) String search,@RequestParam(value = "orderId" , required=false) String orderId){
		
		int totalPage = service.findTotalPage();
		if(page==null){
			page = 1;
		}else{
			page = page>totalPage?totalPage:page;//页数大于总页数则跳转尾页
		}
		
		List<RecordOrder> recordOrderBoList = service.getOrderBoByPage(page);
		int pageSize = service.findRecordOrderPageSize();
		
		
		ModelAndView modelAndView = new ModelAndView("/admin/recordOrder");
		
		modelAndView.addObject("recordOrderBoList", recordOrderBoList);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("page", page);
		modelAndView.addObject("pageSize", pageSize);
		
		return modelAndView;
	}
	
	/**
	 * 根据订单id
	 * 获取订单商品列表
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/findRecordOrderCommodityBoListByOrderId", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String findRecordOrderCommodityBoListByOrderId(@RequestParam("orderId") String orderId){
		
		List<RecordOrderCommodity> recordOrderBoList = service.getOrderCommodityBoById(orderId);
		String recordOrderBoListJson = JsonUtil.objectToJson(recordOrderBoList);
		LOG.debug("订单id为 " + orderId + " 的订单商品列表json为 "+recordOrderBoListJson);
		
		return recordOrderBoListJson;
	}
	
	/**
	 * 查询某页的订单条数
	 * 页数超过最大值则返回0条
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/findCountByPage.do")
	@ResponseBody
	public Integer findCountByPage(@RequestParam(value = "page", required = false) Integer page) {

		Integer count = service.findCountByPage(page);

		return count;
	}
}
