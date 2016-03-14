/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.customersbyservlet.controller;

import bi.eja.customersbyservlet.model.Customer;
import bi.eja.customersbyservlet.model.CustomersFacade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danecek
 */
@WebServlet(name = "FrontController", urlPatterns = {"*.do"})
public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String name = request.getParameter("name");
        if (name.length()>= 3) {
            CustomersFacade.INST.add(new Customer(name));
            response.sendRedirect("Customers");
        } else {
            request.setAttribute("errormessage", "Short name");          
            RequestDispatcher d = getServletContext().getRequestDispatcher("/Customers");
            d.forward(request, response);
        }
    }

}
