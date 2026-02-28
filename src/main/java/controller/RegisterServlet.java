package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import dao.UserDAO;
import model.User;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		UserDAO dao = new UserDAO();

		if (username == null || password == null || email == null || phone == null || username.isEmpty()
				|| password.isEmpty() || email.isEmpty() || phone.isEmpty()) {

			req.setAttribute("error", "Vui lòng nhập đầy đủ thông tin!");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			return;
		}

		if (dao.isUserExists(username, email, phone)) {

			req.setAttribute("error", "Username hoặc Email hoặc SĐT đã tồn tại!");

			req.getRequestDispatcher("register.jsp").forward(req, resp);
			return;
		}

		User u = new User(username, password, email, phone);

		boolean success = dao.register(u);

		if (success) {
			resp.sendRedirect("login.jsp");
		} else {
			req.setAttribute("error", "Đăng ký thất bại!");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}
}