package com.cosi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cosi.vo.Dept;


public interface DeptMapper {

	public void saveDept(Dept dept);
	public void updateDept(Dept dept);
	public void deleteDeptById(int id);
	public Dept getDeptById(int id);
	public void deleteDepts(int[] ids);
	public List<Dept> getDepts(@Param("currentPage") int currentPage,@Param("rows") int rows);
	public List<Dept> getDeptsByDname(String dname);
	public int getDeptsSize();
	
}
