package dao;

import java.util.List;

import model.Dept;

public interface DeptDAO {
	public List<Dept> selectAll();
	public Dept selectBybookid(int deptno);
	public List<Dept> publisherList();
	public boolean insert(Dept dept);
	public boolean update(Dept dept);
	public boolean deleteBybookid(int deptno);
}
