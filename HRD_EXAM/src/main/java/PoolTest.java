import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PoolTest {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:/pool");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
