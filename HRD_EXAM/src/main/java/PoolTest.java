import java.sql.Connection;

public class PoolTest {

	public static void main(String[] args) {
		Connection conn = DBConnection.getConnection();
	}
}
