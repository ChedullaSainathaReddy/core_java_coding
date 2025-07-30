package com.crudoperations;

import java.io.IOException;
import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.vcube.com.crud2.Student;
//import com.vcube.com.crud2.StudentJDBC_DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentJDBC_CRUDSERVLET extends HttpServlet {
	 private StudentJDBC_DAO dao;

	    public void init() //lifecyle method of servlet
	    {
	        dao = new StudentJDBC_DAO();
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");
	        try {
	            switch (action == null ? "LIST" : action) {
	                case "NEW":
	                    showForm(request, response);
	                    break;
	                case "INSERT":
	                    insert(request, response);
	                    break;
	                case "EDIT":
	                    edit(request, response);
	                    break;
	                case "UPDATE":
	                    update(request, response);
	                    break;
	                case "DELETE":
	                    delete(request, response);
	                    break;
	                default:
	                    list(request, response);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	    private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        List<Student> list = dao.getAllStudents();
	        request.setAttribute("studentList", list);
	        RequestDispatcher rd = request.getRequestDispatcher("Student_JDBCViewLayer.jsp");
	        rd.forward(request, response);
	    }

	    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        RequestDispatcher rd = request.getRequestDispatcher("StudentJDBCUIForm.jsp");//textboxes
	        rd.forward(request, response);
	    }

	    private void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        Student s = new Student();
	        s.setName(request.getParameter("name"));
	        s.setEmail(request.getParameter("email"));
	        dao.insertStudent(s);
	        response.sendRedirect("StudentJDBC_CRUDSERVLET");
	    }

	    private void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Student s = dao.getStudent(id);
	        request.setAttribute("student", s);
	        RequestDispatcher rd = request.getRequestDispatcher("StudentJDBCUIForm.jsp");//textboxes
	        rd.forward(request, response);
	    }

	    private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        Student s = new Student();
	        s.setId(Integer.parseInt(request.getParameter("id")));
	        s.setName(request.getParameter("name"));
	        s.setEmail(request.getParameter("email"));
	        dao.updateStudent(s);
	        response.sendRedirect("StudentJDBC_CRUDSERVLET");
	    }

	    private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        int id = Integer.parseInt(request.getParameter("id"));
	        dao.deleteStudent(id);
	        response.sendRedirect("StudentJDBC_CRUDSERVLET");
	    }

	}


