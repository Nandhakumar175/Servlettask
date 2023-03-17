package com.sevlet.project.controller;
import java.util.UUID;

import java.io.IOException;


import com.servlet.project.dp.DataBaseUtil;
import com.servlet.project.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserListController
 */
@WebServlet("/UserListController")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  
		String Name = request.getParameter("Name");
		String FatherName = request.getParameter("fatherName");
		String Phone = request.getParameter("phone");
		String Email = request.getParameter("email");
		String City = request.getParameter("city");
		String State = request.getParameter("state");
		String Pincode = request.getParameter("pincode");
		
		System.out.println(Name+".........."+FatherName+"..........."+Phone+"......."+Email+"........."+City+"........"+State+"......."+Pincode);
		User myuser=new User();
		myuser.setId(UUID.randomUUID());
		myuser.setName(Name);
		myuser.setFatherName(FatherName);
		myuser.setPhone(Phone);
		myuser.setEmail(Email);
		myuser.setCity(City);
		myuser.setState(State);
		myuser.setPincode(Pincode);
		DataBaseUtil.save(myuser);
		//request.setAttribute("myuser", myuser);
		//DataBaseUtil.save(myuser);
	//	request.getRequestDispatcher("UserList.jsp").include(request, response);
		response.sendRedirect("UserFormController");

	}

}
