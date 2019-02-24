package com.eilikce.osm.admin.controller;

import com.eilikce.osm.admin.service.AdminService;
import com.eilikce.osm.core.bo.common.ResponseData;
import com.eilikce.osm.core.bo.transformable.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController{

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService service;

    @RequestMapping(value = "/login")
	public ResponseData login(String name, String password) {
        service.login(name,password);
        return responseData("success");
    }

    @RequestMapping(value = "/findAll")
    public ResponseData findAll() {
        List<Admin> allAdminBo = service.getAllAdmin();
        return responseData(allAdminBo);
    }


	@RequestMapping(value = "/findCount")
	public ResponseData findCount(){
		int count = service.getCount();
		return responseData(count);
	}
	
	/**
	 * 添加一个admin用户
	 * @param user_name
	 * @param password
	 * @param permissions
	 * @return
	 */
	@RequestMapping(value = "/addAdmin")
	public ResponseData addAdmin(String user_name, String password, String permissions){
		
		String addResult = service.addAdmin(user_name, password, permissions);
		
		if(addResult.equals("sucess")){
			LOG.info("插入管理员信息");
		}else if(addResult.equals("repeat")){
			LOG.info("插入的管理员信息重复");
		}else{
			LOG.error("管理员信息插入失败");
		}

        return responseData(addResult);
	}

}
