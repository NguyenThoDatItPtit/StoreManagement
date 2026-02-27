package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import dao.UserDAO;
import model.User;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		User u = new User(req.getParameter("username"), req.getParameter("password"), req.getParameter("email"),
				req.getParameter("phone"));

		new UserDAO().register(u);

		resp.sendRedirect("login.jsp");
	}
}