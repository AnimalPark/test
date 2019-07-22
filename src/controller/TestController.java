package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAOImpl;
import model.Dept;
import model.Emp;


@WebServlet(name = "TestController", urlPatterns = { "/emp_add", "/emp_list","/emp_insert","/emp_detail","/emp_delete","/emp_update","/emp_search"} )

public class TestController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println(uri);
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		System.out.println(action);
		EmpDAOImpl impl = null;
		
		req.setCharacterEncoding("utf-8");
		
		if(action.equals("emp_add")) {
			impl = new EmpDAOImpl();
			List<Dept> dept = impl.deptList();
			req.setAttribute("deptlist", dept);
			RequestDispatcher rd = req.getRequestDispatcher("jsp/form/empInsertForm.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("emp_list")) {
			impl = new EmpDAOImpl();
			List<Emp> emps = impl.selectAll();
			req.setAttribute("emplist", emps);
			RequestDispatcher rd = req.getRequestDispatcher("jsp/form/empListForm.jsp");
			rd.forward(req, resp);
		}
		
		else if(action.equals("emp_insert")) {
			Emp emp = new Emp();
			impl = new EmpDAOImpl();
			emp.setEname(req.getParameter("ename"));
			emp.setJob(req.getParameter("job"));
			emp.setSal(Integer.parseInt(req.getParameter("sal")));
			emp.setDeptno(Integer.parseInt(req.getParameter("deptno")));
			
			boolean result = impl.insert(emp);
			System.out.println(result);
			RequestDispatcher rd = req.getRequestDispatcher("emp_add");
			rd.forward(req, resp);
		}
		else if(action.equals("emp_detail")) {
			impl = new EmpDAOImpl();
			int empno = Integer.parseInt(req.getParameter("empnoindex"));
			Emp emp = impl.selectByempno(empno);
			
			List<Dept> dept = impl.deptList();
			req.setAttribute("deptlist", dept);
			
			req.setAttribute("selectedemp", emp);
			RequestDispatcher rd = req.getRequestDispatcher("jsp/form/empDetailForm.jsp");
			rd.forward(req, resp);
		}
		
		else if(action.equals("emp_update")) {
			impl = new EmpDAOImpl();
			int num = Integer.parseInt(req.getParameter("updateno"));
			System.out.println(num);
			Emp emp = new Emp();
			emp.setEmpno(num);
			emp.setEname(req.getParameter("ename"));
			emp.setJob(req.getParameter("job"));
			emp.setSal(Integer.parseInt(req.getParameter("sal")));
			emp.setDeptno(Integer.parseInt(req.getParameter("deptno")));
			impl.update(emp);
			RequestDispatcher rd = req.getRequestDispatcher("emp_list");
			rd.forward(req, resp);
		}
		
		else if(action.equals("emp_delete")) {
			impl = new EmpDAOImpl();
			int num = Integer.parseInt(req.getParameter("deleteno"));
			System.out.println(num);
			impl.deleteByempno(num);
			RequestDispatcher rd = req.getRequestDispatcher("emp_list");
			rd.forward(req, resp);
		}
		
		else if(action.equals("emp_search")) {
			impl = new EmpDAOImpl();
			String d1 = req.getParameter("datefirst");
			String d2 = req.getParameter("datesecond");
			
			System.out.println(d1 + "  " + d2);
			List<Emp> emps = impl.selectBydate(d1, d2);

			System.out.println(emps.toString());
			
			req.setAttribute("emplist", emps);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/form/empListForm.jsp");
			rd.forward(req, resp);
		}
	}
}
