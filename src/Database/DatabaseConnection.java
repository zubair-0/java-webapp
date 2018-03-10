package Database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class DatabaseConnection {
	public DataSource datasourceConnect(DataSource ds) throws ServletException{
		try {
			InitialContext initContext = new InitialContext();
			Context env = (Context) initContext.lookup("java:comp/env");
			ds = (DataSource) env.lookup("jdbc/hotelwebsitedb");			
		} catch (NamingException e) {
			throw new ServletException();
		}
		
		return ds;
	}
}

