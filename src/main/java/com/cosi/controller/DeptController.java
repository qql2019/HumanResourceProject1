package com.cosi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cosi.iservice.IDeptService;
import com.cosi.vo.Dept;
import com.cosi.vo.PageBean;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	@Qualifier("deptService")
	private IDeptService deptService;
	
	private Map<String,Object> getDeptsMap(PageBean pageBean){
		List<Dept> depts = deptService.getDepts(pageBean);
		Map<String,Object> result = new HashMap<>();
		result.put("rows", depts);
		result.put("total", deptService.getDeptsSize());
		return result;
	}
	
	private Map<String,Object> getDeptsMap(){
		return getDeptsMap(new PageBean(1,10));
	}
	
	
	// 在方法的返回值之前标注@ResponseBody注解，提示以json格式返回数据（Object）
	@RequestMapping("/getdeptsjson.do")
	public @ResponseBody Map<String,Object> getDeptsJson(HttpServletRequest req, PageBean pageBean){
		
		String dname = req.getParameter("dname");
		// 通过名称获取部门记录
		if (dname!=null){
			List<Dept> depts = deptService.getDeptsByDname(dname);
			Map<String,Object> result = new HashMap<>();
			result.put("rows", depts);
			result.put("total", depts.size());
			return result;
		}
		return getDeptsMap(pageBean);
	}
	
	// 添加dept操作
	@RequestMapping("/save.do")
	public @ResponseBody Map<String,Object> saveDept(Dept dept){	
		deptService.saveDept(dept);		
		return getDeptsMap();
	}
	
	// 修改dept操作
	@RequestMapping("/update.do")
	public @ResponseBody Map<String,Object> updateDept(Dept dept){	
		deptService.updateDept(dept);		
		return getDeptsMap();
	}
	
	// 批量删除dept操作
	@RequestMapping("/delete.do")
	public @ResponseBody Map<String,Object> deleteDept(String ids){	
		String[] idsArray = ids.split(",");
		int idsInt[] = new int[idsArray.length];
		for (int i=0;i<idsInt.length;i++){
			idsInt[i] = Integer.parseInt(idsArray[i]);
		}
		deptService.deleteDepts(idsInt);		
		return getDeptsMap();
	}

	
}
