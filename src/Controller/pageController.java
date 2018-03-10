package Controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pageController
 */
public class pageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: Page Controller "+"\n").append(request.getContextPath());
		/* PrintWriter out = response.getWriter(); 
		out.println("action get starts");
		String action = request.getParameter("action");
		
		if(action==null)
		{
			request.getRequestDispatcher("HotelWebsite/login.jsp").forward(request, response);
		}else 
		{
		out.println("action="+action);
		}*/
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 PrintWriter out = response.getWriter(); 
		response.getWriter().append("POST at: Page Controller "+"\n").append(request.getContextPath());
		 out.println("Page Controller action post starts");
		 
		String action = request.getParameter("action");
		if(action!=null)
		 {
		out.println("action="+action);
		
		if((action.equals("login"))||(action.equals("signup"))||(action.equals("viewRoomsU"))||(action.equals("bookRoomU")))
			//Checking user actions
		 {
			 request.getRequestDispatcher("userController").forward(request, response);
		 }
		else if((action.equals("addARoom"))||(action.equals("editRoom")))
		//Checking Admin Actions
		{
			
		}
		else if((action.equals("logout")))
		//Checking Common Actions
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		 }
		
		else
		 {// if action is null redirecting back to login page
			 request.getRequestDispatcher("login.jsp").forward(request, response);
			 
			 
		 }
		
		
		
		
		doGet(request, response);
	}

}
