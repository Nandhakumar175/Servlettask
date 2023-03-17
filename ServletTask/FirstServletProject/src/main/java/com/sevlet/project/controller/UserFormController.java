package com.sevlet.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.servlet.project.dp.DataBaseUtil;
import com.servlet.project.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserFormController
 */
@WebServlet("/UserFormController")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userObj=DataBaseUtil.getAllUsers();
		request.setAttribute("details", userObj);
		request.getRequestDispatcher("UserList.jsp").include(request, response);
	}

}
