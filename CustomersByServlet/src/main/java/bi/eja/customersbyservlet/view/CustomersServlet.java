/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.customersbyservlet.view;

import bi.eja.customersbyservlet.model.Customer;
import bi.eja.customersbyservlet.model.CustomersFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Customers"})
public class CustomersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Customers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Customers Table</h1>");
            out.println("<table border = \"1\">");
            for (Customer c : CustomersFacade.INST.getAll()) {
                out.println("<tr>");
                out.println("<td>");
                out.println(c.getId());
                out.println("</td>");
                out.println("<td>");
                out.print(c.getName());
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            out.println("<form action=\"add.do\" method=\"POST\">");
            String e = (String) request.getAttribute("errormessage");
            if (e != null) {
                out.println(e);
            }
            out.println("<input type=\"text\" name=\"name\" value=\""+ request.getParameter("name") + "\"/>");
            out.println("<input type=\"submit\" value=\"Add\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
