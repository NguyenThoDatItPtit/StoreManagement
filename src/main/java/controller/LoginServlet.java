package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import dao.UserDAO;
import model.User;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String u = req.getParameter("username");
		String p = req.getParameter("password");

		User user = new UserDAO().login(u, p);

		if (user != null) {
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("home.jsp");
		} else {
			resp.sendRedirect("login.jsp");
		}
	}
}