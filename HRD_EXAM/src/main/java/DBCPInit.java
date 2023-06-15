

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//@WebServlet(name = "DBCPInit", urlPatterns = { "/" })
public class DBCPInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DBCPInit() {
    }

	public void init(ServletConfig config) throws ServletException {
		try {
    		System.out.println("DBCP Init Call");
			Class.forName(config.getInitParameter("driver"));
			//Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
