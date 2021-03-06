/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Client;
import dao.ObjectDAO;

/**
 *
 * @author PaulinaMaciej
 */

@WebServlet(urlPatterns = "/clientsList")
public class ClientListServlet extends HttpServlet{

    @Inject
    private ObjectDAO<Client> dao;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> clients = dao.getObjects();
        
        req.setAttribute("clientsList", clients);
        
        //getServletContext().getRequestDispatcher("/usersList.jsp").forward(req, resp);
        req.getRequestDispatcher("clientsList.jsp").forward(req, resp);
    }
    
    
}
