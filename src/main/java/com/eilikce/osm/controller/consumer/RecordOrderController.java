package com.eilikce.osm.controller.consumer;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.bo.admin.RecordOrderBo;
import com.eilikce.osm.bo.admin.RecordOrderCommodityBo;
import com.eilikce.osm.service.consumer.RecordOrderService;
import com.eilikce.osm.util.JsonUtil;

@Controller
@RequestMapping("/recordOrder")
public class RecordOrderController {
	
	private static Logger logger = Logger.getLogger(RecordOrderController.class);
	
	@Autowired
	private RecordOrderService service;
	
	@Value("#{osmProperties['recordOrderPageSize']}")  
	private String recordOrderPageSize;
	
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
		
		int pageSize = Integer.parseInt(this.recordOrderPageSize);//从配置文件中获取默认页长
		int totalPage = service.findTotalPage(pageSize);
		if(page==null){
			page = 1;
		}else{
			page = page>totalPage?totalPage:page;//页数大于总页数则跳转尾页
		}
		
		List<RecordOrderBo> recordOrderBoList = service.getRecordOrderBoByPage(page, pageSize);
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
		
		List<RecordOrderCommodityBo> recordOrderBoList = service.getRecordOrderCommodityBoById(orderId);
		String recordOrderBoListJson = JsonUtil.objectToJson(recordOrderBoList);
		logger.debug("订单id为 " + orderId + " 的订单商品列表json为 "+recordOrderBoListJson);
		
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

		int pageSize = Integer.parseInt(this.recordOrderPageSize);// 从配置文件中获取默认页长
		Integer count = service.findCountByPage(page, pageSize);

		return count;
	}
}
