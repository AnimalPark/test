package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dept;
import model.Emp;

public class EmpDAOImpl extends BaseDAO implements EmpDAO {

	public static final String EMP_SELECT_ALL_SQL = "SELECT * FROM EMP ORDER BY EMPNO DESC";
	public static final String EMP_SELECT_BY_EMPNO_SQL = "SELECT * FROM EMP WHERE EMPNO = ?";
	public static final String EMP_INSERT_SQL = "INSERT INTO EMP VALUES (SEQ_EMP.NEXTVAL ,? ,? ,SYSDATE, ?, ?)";
	public static final String EMP_UPDATE_SQL = "UPDATE EMP SET ENAME = ?, JOB = ?, SAL = ?, DEPTNO = ? WHERE EMPNO = ?";
	public static final String EMP_DELETE_BY_EMPNO_SQL = "DELETE FROM EMP WHERE EMPNO = ?";
	public static final String EMP_SELECT_BY_DATE_SQL = "SELECT * FROM EMP WHERE HIREDATE BETWEEN ? AND ? ORDER BY EMPNO DESC";
	public static final String EMP_DEPTLIST_SQL = "SELECT * FROM DEPT ORDER BY DNAME";

	@Override
	public List<Emp> selectAll() {
		List<Emp> emps = new ArrayList<Emp>();
		Emp emp = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(EMP_SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				emp = new Emp();
				emp.setEmpno(resultSet.getInt("EMPNO"));
				emp.setEname(resultSet.getString("ENAME"));
				emp.setJob(resultSet.getString("JOB"));
				emp.setHiredate(resultSet.getString("HIREDATE").split("\\s")[0]);
				emp.setSal(resultSet.getInt("SAL"));
				emp.setDeptno(resultSet.getInt("DEPTNO"));
				emps.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return emps;
	}

	@Override
	public Emp selectByempno(int empno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Emp emp = new Emp();
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(EMP_SELECT_BY_EMPNO_SQL);
			preparedStatement.setInt(1, empno);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				emp = new Emp();
				emp.setEmpno(resultSet.getInt("EMPNO"));
				emp.setEname(resultSet.getString("ENAME"));
				emp.setJob(resultSet.getString("JOB"));
				emp.setHiredate(resultSet.getString("HIREDATE").split("\\s")[0]);
				emp.setSal(resultSet.getInt("SAL"));
				emp.setDeptno(resultSet.getInt("DEPTNO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return emp;
	}

	@Override
	public List<Dept> deptList() {
		List<Dept> depts = new ArrayList<Dept>();
		Dept dept = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(EMP_DEPTLIST_SQL);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				dept = new Dept();
				dept.setDeptno(resultSet.getInt("DEPTNO"));
				dept.setDname(resultSet.getString("DNAME"));
				dept.setLoc(resultSet.getString("LOC"));
				depts.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return depts;
	}

	@Override
	public boolean insert(Emp emp) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result = false;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(EMP_INSERT_SQL);
			preparedStatement.setString(1, emp.getEname());
			preparedStatement.setString(2, emp.getJob());
			preparedStatement.setInt(3, emp.getSal());
			preparedStatement.setInt(4, emp.getDeptno());
			int chk = preparedStatement.executeUpdate();
			if (chk != 0)
				result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return result;
	}

	@Override
	public boolean update(Emp emp) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result = false;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(EMP_UPDATE_SQL);
			preparedStatement.setString(1, emp.getEname());
			preparedStatement.setString(2, emp.getJob());
			preparedStatement.setInt(3, emp.getSal());
			preparedStatement.setInt(4, emp.getDeptno());
			preparedStatement.setInt(5, emp.getEmpno());
			int chk = preparedStatement.executeUpdate();
			if (chk != 0)
				result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return result;
	}

	@Override
	public boolean deleteByempno(int empno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean result = false;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(EMP_DELETE_BY_EMPNO_SQL);
			preparedStatement.setInt(1, empno);
			int chk = preparedStatement.executeUpdate();
			if (chk != 0)
				result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return result;
	}

	@Override
	public List<Emp> selectBydate(String date1, String date2) {
		List<Emp> emps = new ArrayList<Emp>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Emp emp = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(EMP_SELECT_BY_DATE_SQL);
			preparedStatement.setString(1, date1);
			preparedStatement.setString(2, date2);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				emp = new Emp();
				emp.setEmpno(resultSet.getInt("EMPNO"));
				emp.setEname(resultSet.getString("ENAME"));
				emp.setJob(resultSet.getString("JOB"));
				emp.setHiredate(resultSet.getString("HIREDATE").split("\\s")[0]);
				emp.setSal(resultSet.getInt("SAL"));
				emp.setDeptno(resultSet.getInt("DEPTNO"));
				emps.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return emps;
	}

}
