package com.cosi.iservice;

import java.util.List;

import com.cosi.vo.Dept;
import com.cosi.vo.PageBean;

public interface IDeptService {

	public void saveDept(Dept dept);
	public void updateDept(Dept dept);
	public void deleteDeptById(int id);
	public Dept getDeptById(int id);
	public List<Dept> getDepts(PageBean pageBean);
	public void deleteDepts(int[] ids);
	public List<Dept> getDeptsByDname(String dname);
	public int getDeptsSize();
	
}
