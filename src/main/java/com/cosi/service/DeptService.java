package com.cosi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosi.iservice.IDeptService;
import com.cosi.mapper.DeptMapper;
import com.cosi.vo.Dept;
import com.cosi.vo.PageBean;

@Service("deptService")
public class DeptService implements IDeptService{

	@Autowired
	private DeptMapper deptMapper;

	@Override
	public void saveDept(Dept dept) {
		
		deptMapper.saveDept(dept);
		
	}

	@Override
	public void updateDept(Dept dept) {
		deptMapper.updateDept(dept);
		
	}

	@Override
	public void deleteDeptById(int id) {
		deptMapper.deleteDeptById(id);
		
	}

	@Override
	public Dept getDeptById(int id) {
		
		return deptMapper.getDeptById(id);
	}

	@Override
	public List<Dept> getDepts(PageBean pageBean) {
		
		return deptMapper.getDepts((pageBean.getPage()-1)*pageBean.getRows(),pageBean.getRows());
	}

	@Override
	public void deleteDepts(int[] ids) {
		deptMapper.deleteDepts(ids);
		
	}

	@Override
	public List<Dept> getDeptsByDname(String dname) {
		return deptMapper.getDeptsByDname(dname);
	}

	@Override
	public int getDeptsSize() {
		return deptMapper.getDeptsSize();
	}


	
	
	
	
}
