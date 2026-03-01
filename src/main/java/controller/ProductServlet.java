package controller;

import dao.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    ProductDAO dao = new ProductDAO();

    // ================= GET =================
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // ===== DELETE =====
        if ("delete".equals(action)) {

            int id =
                Integer.parseInt(request.getParameter("id"));

            dao.delete(id);

            response.sendRedirect("products");
        }

        // ===== EDIT =====
        else if ("edit".equals(action)) {

            int id =
                Integer.parseInt(request.getParameter("id"));

            Product p = dao.getById(id);

            request.setAttribute("product", p);
            request.getRequestDispatcher("product-edit.jsp")
                   .forward(request, response);
        }

        // ===== LIST =====
        else {

            List<Product> list = dao.getAll();
            request.setAttribute("list", list);

            request.getRequestDispatcher("product-list.jsp")
                   .forward(request, response);
        }
    }

    // ================= POST =================
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // ===== ADD PRODUCT =====
        if (action == null || action.isEmpty()) {

            String name = request.getParameter("name");

            double price =
                Double.parseDouble(request.getParameter("price"));

            double installment =
                Double.parseDouble(request.getParameter("installment"));

            int quantity =
                Integer.parseInt(request.getParameter("quantity"));

            int category =
                Integer.parseInt(request.getParameter("category"));

            String description =
                request.getParameter("description");

            Product p = new Product(
                    name,
                    price,
                    installment,
                    quantity,
                    category,
                    description
            );

            dao.insert(p);

            // reload list
            response.sendRedirect("products");
        }

        // ===== UPDATE =====
        else if ("update".equals(action)) {

            int id =
                Integer.parseInt(request.getParameter("id"));

            String name =
                request.getParameter("name");

            double price =
                Double.parseDouble(request.getParameter("price"));

            int quantity =
                Integer.parseInt(request.getParameter("quantity"));

            Product p =
                new Product(id, name, price, quantity);

            dao.update(p);

            response.sendRedirect("products");
        }
    }
}