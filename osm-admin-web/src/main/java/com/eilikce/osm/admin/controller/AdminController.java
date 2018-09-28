package com.eilikce.osm.admin.controller;

import com.eilikce.osm.admin.service.AdminService;
import com.eilikce.osm.core.bo.common.ResponseData;
import com.eilikce.osm.core.bo.transformable.Admin;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController{

	private static Logger logger = Logger.getLogger(AdminController.class);

	@Autowired
	private AdminService service;

    @RequestMapping(value = "/login")
	public ResponseData login(String name, String password) {
        service.login(getSubject(),name,password);
        return responseData("success");
    }

    @RequestMapping(value = "/findAll")
    @RequiresRoles("admin")
    public ResponseData findAll() {
        List<Admin> allAdminBo = service.getAllAdmin();
        return responseData(allAdminBo);
    }


	@RequestMapping(value = "/findCount")
    @RequiresRoles("admin")
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
    @RequiresRoles("admin")
	public ResponseData addAdmin(String user_name, String password, String permissions){
		
		String addResult = service.addAdmin(user_name, password, permissions);
		
		if(addResult.equals("sucess")){
			logger.info("插入管理员信息");
		}else if(addResult.equals("repeat")){
			logger.info("插入的管理员信息重复");
		}else{
			logger.error("管理员信息插入失败");
		}

        return responseData(addResult);
	}

}
