package dao;

import java.util.List;

import model.Dept;
import model.Emp;


public interface EmpDAO {
	public List<Emp> selectAll();
	public Emp selectByempno(int empno);
	public List<Emp> selectBydate(String date1, String date2);
	public List<Dept> deptList();
	public boolean insert(Emp emp);
	public boolean update(Emp emp);
	public boolean deleteByempno(int empno);
}
