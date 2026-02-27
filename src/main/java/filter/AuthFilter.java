package filter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/products")
public class AuthFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("user") != null) {

			chain.doFilter(request, response);

		} else {
			((HttpServletResponse) response).sendRedirect("login.jsp");
		}
	}
}