package com.eilikce.osm.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.admin.service.ManageService;
import com.eilikce.osm.core.bo.common.CommodityBatch;
import com.eilikce.osm.core.bo.common.CommodityGroupItem;
import com.eilikce.osm.core.bo.common.CommodityShow;
import com.eilikce.osm.core.bo.transformable.Commodity;
import com.eilikce.osm.core.bo.transformable.CommodityItem;
import com.eilikce.osm.core.handler.CommodityHandler;
import com.eilikce.osm.core.handler.OsmIdHandler;
import com.eilikce.osm.entity.consumer.CommodityFurtherPo;
import com.eilikce.osm.util.JsonUtil;
import com.eilikce.osm.util.StringUtil;

@Controller
@RequestMapping("/manage")
public class ManageController {
	
	private static Logger logger = Logger.getLogger(ManageController.class);
	
	@Autowired
	ManageService service;
	
	@Value("#{osmProperties['modifyPageSize']}")  
	private String modifyPageSize;

	@RequestMapping(value = "/manageModify.do")
	public ModelAndView manageModify(@RequestParam(value = "page" , required=false) Integer page ,@RequestParam(value = "search" , required=false) String search,@RequestParam(value = "commodityId" , required=false) String commodityId,@RequestParam(value = "barcode" , required=false) String barcode ) {
		
		int pageSize = Integer.parseInt(this.modifyPageSize);//从配置文件中获取默认页长
		int totalPage = service.findTotalPage(pageSize);
		if(page==null){
			page = 1;
		}else{
			page = page>totalPage?totalPage:page;//页数大于总页数则跳转尾页
		}

		List<CommodityShow>  commodityShowList = new ArrayList<CommodityShow>();
		
		
		if(commodityId!=null){
			CommodityShow commodityShow = service.getCommodityShowById(commodityId);
			if(commodityShow!=null){//避免放入空对象
				commodityShowList.add(commodityShow);
			}
		}else if(barcode!=null){
			Integer barcode_int = StringUtil.IntegerParse(barcode);//转换参数为整型，如果参数为""在转为null
			CommodityShow commodityShow = null;
			if(barcode_int != null){
				commodityShow = service.getCommodityShowByBarcode(barcode_int);
			}
			if(commodityShow!=null){//避免放入空对象
				commodityShowList.add(commodityShow);
			}
		}else{
			
			//判断是否搜索
			if(search!=null){
				commodityShowList = service.getCommodityShowListByPageSearch(page,pageSize,search);
			}else{
				commodityShowList = service.getCommodityShowListByPage(page,pageSize);
			}
		}
		
		
		List<CommodityGroupItem> groupList = service.getAllCommodityGroupList();
		
		ModelAndView modelAndView = new ModelAndView("/admin/manageModify");
		modelAndView.addObject("commodityShowList", commodityShowList);
		modelAndView.addObject("groupList", groupList);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("page", page);
		modelAndView.addObject("pageSize", pageSize);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/manageAdd.do")
	public ModelAndView manageAdd() {
		
		ModelAndView modelAndView = new ModelAndView("/admin/manageAdd");
		
		List<CommodityGroupItem> groupList = service.getAllCommodityGroupList();
		
		modelAndView.addObject("groupList", groupList);
		
		return modelAndView;
	}

	@RequestMapping(value = "/manageBatch.do")
	public ModelAndView manageBatch() {
		
		ModelAndView modelAndView = new ModelAndView("/admin/manageBatch");
		
		return modelAndView;
	}
	
	

	
	@RequestMapping(value = "/findCommodityItemListByGroupId.do")
	@ResponseBody
	public String findCommodityItemListByGroupId(@RequestParam("group_id") int groupId) {
		
		List<CommodityItem> commodityItemList = service.getCommodityItemListByGroupId(groupId);
		String commodityItemListJson = JsonUtil.objectToJson(commodityItemList);
		
		logger.debug("二级分类信息json："+commodityItemListJson);
		
		return commodityItemListJson;
	}
	
	
	@RequestMapping(value = "/findCommodityById.do")
	@ResponseBody
	public String findCommodityById(@RequestParam("commodityId") String commodityId) {

		String commodityJson = "";
		CommodityFurtherPo commodityFurther = service.getCommodityFurtherById(commodityId);
		commodityJson = JsonUtil.objectToJsonTransformDate(commodityFurther,"yyyy-MM-dd");

		logger.debug("商品json："+commodityJson);
		
		return commodityJson;
	}
	
	
	@RequestMapping(value = "/modifyCommodity.do")
	@ResponseBody
	public String modifyCommodity(@RequestParam(value = "imgFile", required = false) MultipartFile imgFile , HttpServletRequest request) {
		
		Commodity commodityBo = transfromCommodity(request,false);
		String commodityId = commodityBo.getCommodityId();
		
		Integer update = service.modifyCommodity(commodityBo);
		logger.debug("更新商品："+commodityBo);
		
		String commodityJson = "";
		if(update==1){
			CommodityShow commodityShow = service.getCommodityShowById(commodityId);
			commodityJson = JsonUtil.objectToJsonTransformDate(commodityShow,"yyyy-MM-dd");
		}

		//如果上传了图片则更新图片，否则不更新图片，只更新数据信息
		if(!imgFile.isEmpty()){
			logger.debug("用户上传了图片，准备更新图片");
			String filePath = CommodityHandler.CommodityImgSystemPath(commodityBo);
			String fileName = CommodityHandler.CommodityImgName(commodityBo);
			boolean flag = service.imgWriteFile(imgFile, filePath, fileName);
			if(flag){
				logger.info(commodityId+"商品，图片更新成功");
			}
		}else{
			logger.info(commodityId+"商品，未更新图片");
		}
		
		return commodityJson;
	}
	
	/**
	 * 以Json形式接收commodity对象并更新
	 * @param commodityBo
	 * @return
	 */
	@Deprecated
	@RequestMapping(value = "/modifyCommodityJson.do")
	@ResponseBody
	public Integer modifyCommodityJson(@RequestBody Commodity commodityBo) {
		
		Integer update = service.modifyCommodity(commodityBo);
		logger.debug("更新商品json："+commodityBo);
		
		return update;
	}
	
	@RequestMapping(value = "/deleteCommodity.do")
	@ResponseBody
	public Integer modifyCommodity(@RequestParam("commodityId") String commodityId) {
		
		Integer delete = service.dropCommodity(commodityId);
		logger.debug("删除商品 , commodityId："+commodityId);
		
		return delete;
	}

	
	@RequestMapping(value = "/addCommodity.do")
	@ResponseBody
	public Integer addCommodity(@RequestParam(value = "imgFile", required = false) MultipartFile imgFile , HttpServletRequest request) {
		
		Commodity commodityBo = transfromCommodity(request,true);//新增情况下，自动生成commodityId
		String commodityId = commodityBo.getCommodityId();
		logger.debug("新增商品："+commodityBo);
		Integer insert = service.addCommodity(commodityBo);
		
		if(!imgFile.isEmpty()){
			logger.debug("用户上传了图片，准备新增图片");
			String filePath = CommodityHandler.CommodityImgSystemPath(commodityBo);
			String fileName = CommodityHandler.CommodityImgName(commodityBo);
			boolean flag = service.imgWriteFile(imgFile, filePath, fileName);
			if(flag){
				logger.info(commodityId+"商品，图片上传成功");
			}
		}else{
			logger.info(commodityId+"商品，未上传图片");
		}
		
		return insert;
	}

	@RequestMapping(value = "/findCountByPage.do")
	@ResponseBody
	public Integer findCountByPage(@RequestParam(value = "page", required = false) Integer page) {

		int pageSize = Integer.parseInt(this.modifyPageSize);// 从配置文件中获取默认页长
		Integer count = service.findCountByPage(page, pageSize);

		return count;
	}

	@RequestMapping(value = "/findTotalPage.do")
	@ResponseBody
	public Map<String,Number> findTotalPage() {
		Map<String,Number> map = new HashMap<String,Number>();
		int pageSize = Integer.parseInt(this.modifyPageSize);//从配置文件中获取默认页长
		int TotalPage = service.findTotalPage(pageSize);
		map.put("totalPage", TotalPage);
		
		return map;
	}

	@RequestMapping(value = "/changeShelves.do")
	@ResponseBody
	public Map<String,Object> changeShelves(@RequestParam(value = "commodityId", required = true) String commodityId,@RequestParam(value = "shelves", required = true) Integer shelves) {
		Map<String,Object> map = new HashMap<String,Object>();
		int shelves_back = service.changeShelves(commodityId,shelves);
		map.put("commodityId", commodityId);
		map.put("shelves", shelves_back);
		
		return map;
	}
	
	/**
	 * 批量删除
	 * 通过起止点，批量删除商品信息
	 * 
	 * 废弃，由于修改commodityId为字符串类型，且批量删除功能不实用
	 * @param startCommodityId
	 * @param endCommodityId
	 * @return
	 */
	@Deprecated
	@RequestMapping(value = "/deleteCommodityByRange.do")
	@ResponseBody
	public Integer deleteCommodityByRange(@RequestParam(value = "startCommodityId", required = true) Integer startCommodityId,@RequestParam(value = "endCommodityId", required = true) Integer endCommodityId) {
		
		if(startCommodityId>endCommodityId){
			logger.error("批量删除 ,开始编号 "+startCommodityId+" 大于结束编号 "+endCommodityId);
			return 0;
		}
		
		int delete = service.dropCommodity(startCommodityId, endCommodityId);
		logger.info("批量删除 , 从 "+startCommodityId+" 号到 "+endCommodityId+" 号的商品信息");
		
		return delete;
	}
	
	/**
	 * 批量导入xlsx数据
	 * 不可部分导入成功，只能全部成功或全部失败
	 * @param mfile
	 * @return
	 */
	@RequestMapping(value = "/importXlsx.do")
	@ResponseBody
	public Map<String,Object>  importXls(@RequestParam(value = "mfile", required = true) MultipartFile mfile) {
		Map<String,Object> map = new HashMap<String,Object>();
		CommodityBatch commodityBatch = service.findCommodityListFromXlsx(mfile);
		boolean parseFlag = commodityBatch.isParseFlag();
		//首先检查文件解析，解析错误直接返回错误信息
		if(!parseFlag){
			logger.error("文件解析错误，跳过处理");
			map.put("dataCount",0 );
			map.put("success", 0);
			map.put("failure", 0);
			map.put("failureList", 0);
			map.put("parseFlag", false);
			return map;
		}
		
		List<Commodity> commodityBoList = commodityBatch.getSuccessCommodityList();
		List<Map<String, String>> failureCommodityMap = commodityBatch.getFailureCommodityMap();
 
		List<String> failureList = new ArrayList<String>();//失败商品信息列表
		//批量商品，解析失败对象信息
		for(Map<String, String> m : failureCommodityMap){
			String commodityName = (String) m.get("名称");
			String commodityDetail = (String) m.get("详细");
			failureList.add("商品解析失败，名称："+commodityName+"，详细："+commodityDetail);
		}
		//批量商品，条形码重复对象
		List<Integer> bcarcodeDuplicateList = service.checkBarcodeExsit(commodityBoList);
		if(bcarcodeDuplicateList.size()>0){
			for(Integer i : bcarcodeDuplicateList){
				failureList.add("条形码："+i+" 与已有商品重复，请检查条形码是否输入正确，或删除原有商品，或修改原有商品");
			}
		}
		
		//无错误商品信息才批量添加，否则不添加
		int dataCount = service.findCountFromXlsx(mfile) - 1 ; //原始数据行数不包括标题行
		int successCount = 0;
		String returnInfo = "";
		if(failureList.size()==0){
			successCount = service.addCommodityList(commodityBoList);
			returnInfo = "批量导入成功，共 "+dataCount+" 条数据，成功导入 "+successCount+"条";
		}else{
			returnInfo = "批量导入失败，请查看错误信息";
		}
		
		map.put("returnInfo",returnInfo);
		map.put("failureList", failureList);
		map.put("parseFlag", true);//标识文件被正常处理。
		
		if(failureList.size()>0){
			logger.info("批量导入失败，共 "+dataCount+" 条数据。错误信息："+ failureList);
		}else{
			logger.info("批量导入成功，共 "+dataCount+" 条数据，成功导入 "+successCount+"条");
		}
		
		return map;
	}
	
	/**
	 * 图片管理页面
	 * @return
	 */
	@RequestMapping(value = "/manageImage.do")
	public ModelAndView manageImage() {
		
		ModelAndView modelAndView = new ModelAndView("/admin/manageImage");
		
		return modelAndView;
	}
	
	/**
	 * 通过请求将request转换为Commodity对象
	 * null替换为""
	 * 去除字符串两端空格
	 * @param request	请求request
	 * @param ifCreateCommodityId	是否生成唯一commodityId
	 * @return
	 */
	private Commodity transfromCommodity(HttpServletRequest request, boolean ifCreateCommodityId) {
		
		// 获取参数
		String commodityId = "";
		Integer groupId = StringUtil.IntegerParse(request.getParameter("groupId"));
		Integer itemId = StringUtil.IntegerParse(request.getParameter("itemId"));
		Integer barcode = StringUtil.IntegerParse(request.getParameter("barcode"));
		String commodityName = StringUtil.StringNullTransform(request.getParameter("commodityName")).trim();
		String commodityDetail = StringUtil.StringNullTransform(request.getParameter("commodityDetail")).trim();
		String imgRule = StringUtil.StringNullTransform(request.getParameter("imgRule")).trim();
		Integer number = StringUtil.IntegerParse(request.getParameter("number"));
		Float original = StringUtil.FloatParse(request.getParameter("original"));
		Float price = StringUtil.FloatParse(request.getParameter("price"));
		String unit = StringUtil.StringNullTransform(request.getParameter("unit")).trim();
		String source = StringUtil.StringNullTransform(request.getParameter("source")).trim();
		String detail = StringUtil.StringNullTransform(request.getParameter("detail")).trim();
		Integer salesVolume = StringUtil.IntegerParse(request.getParameter("salesVolume"));
		Integer shelves = StringUtil.IntegerParse(request.getParameter("shelves"));

		if(ifCreateCommodityId){
			commodityId = OsmIdHandler.commodityIdCreater(commodityName);
		}else{
			commodityId = StringUtil.StringNullTransform(request.getParameter("commodityId")).trim();
		}
		
		Commodity commodityBo = new Commodity(commodityId, groupId, itemId, barcode, commodityName, commodityDetail,
				imgRule, number, original, price, unit, source, detail, salesVolume, shelves);

		return commodityBo;
	}
}
