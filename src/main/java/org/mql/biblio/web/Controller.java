package org.mql.biblio.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.mql.biblio.models.Author;
import org.mql.biblio.web.actions.AuthorAction;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String prefix = "/views/";
	private String suffix = ".jsp" ; 
	
	private AuthorAction action ; 
	
	private String source ;
	@Override
	public void init() throws ServletException { // remplace constructeur
		/*
		 * instanciation 
		 * paramtrage
		 */
		source = getInitParameter("source") ; 
		action = new AuthorAction() ; 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().endsWith("/test")) {
			PrintWriter out = response.getWriter();
			out.println("<h1>Biblio controller</h1>");
			out.println("<ol>");
			out.println("<li>Data Source "+source+"</li>");
			out.println("</ol>");
		}
		else {
			String view = "error" ; 
			if(request.getRequestURI().endsWith("/search-author")) {
				view = action.searchAuthor() ; // v
				Author model = action.getAuthor() ; // m et servlet = c
				request.setAttribute("model", model) ;
			}
			
			getServletContext().getRequestDispatcher(prefix + view + suffix).forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
