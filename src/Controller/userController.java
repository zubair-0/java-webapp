package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Servlet;
import java.sql.SQLException;

import Model.User;
import Model.Validation;
/**
 * Servlet implementation class userController
 */
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DataSource ds;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userController() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			InitialContext initContext = new InitialContext();

			Context env = (Context) initContext.lookup("java:comp/env");

			ds = (DataSource) env.lookup("jdbc/hotelwesitedb");

		} catch (NamingException e) {
			throw new ServletException();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getParameter("action");
		PrintWriter out = response.getWriter(); 
		out.println("User Controller");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServletException();
		}
		
		User user = new User(conn);

		PrintWriter out = response.getWriter(); 
		String action=request.getParameter("action");
		if(action!=null)
		{
			if(action.equals("login"))
			{
				out.println("Logging in");
				//----------------------------------------------Validating Fields------------------------------------------
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				
				if(Validation.isEmpty(email))// if email is not valid
				{
					request.setAttribute("errorMessage", "Please enter a valid Email");
				}
				else if(Validation.isEmpty(password))// if password is not valid
				{
					request.setAttribute("errorMessage", "Please enter a valid Password");
				} else {
					try {
						if(!user.login(email, password))// if user is not valid
						{
							request.setAttribute("errorMessage", "Account does not exists");
						}
						else// Everything is in order then allow login
						{
							
							HttpSession session = request.getSession();
							session.setAttribute("email", email);
							
							request.getRequestDispatcher("viewRooms.jsp").forward(request, response);
						}
					} catch (SQLException e) {
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
			else if(action.equals("signup"))
			{
				out.println("Signing Up");
				boolean check = false;
				
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String confirmPassword = request.getParameter("repeatPassword");
				String cnic = request.getParameter("cnic");

				if (Validation.isEmpty(name)) {// check for blank email
					request.setAttribute("errorMessage", "Invalid Name");
				} else {
					if (Validation.isEmpty(email)) {// check for blank subject
						request.setAttribute("errorMessage", "Invlaid Email.");
					} else {
						if (Validation.isEmpty(password)) {
							request.setAttribute("errorMessage", "Invalid Password.");
						} else {
							if(Validation.isEmpty(confirmPassword)) {
								request.setAttribute("errorMessage", "Passwords do not match.");
							} else {
								if(Validation.isEmpty(cnic)) {
									request.setAttribute("errorMessage", "Invalid CNIC.");
								} else {
									if(!Validation.checkMail(email)) {
										request.setAttribute("errorMessage", "Invalid Email.");
									} else {
										try {
											if (user.exists(email)) { // This email address already exists in the user database.
												request.setAttribute("errorMessage", "An account with this email address already exists");
											} else { // We create create the account.
												user.signup(email, password, name);
											}
										} catch (SQLException e) {
											e.printStackTrace();
										}
									}
								}
							}
						}
					}					
				}
			}
			
		}
		else
		{
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}

}
