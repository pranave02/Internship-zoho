import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public void insert_row(Connection conn, Integer id, String first_name, String last_name,
                           String email, String gender, Integer flat_no) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO owner_info (id, first_name,last_name, email , gender, flat_no) " +
                    "values('%d','%s','%s','%s','%s','%d');", id, first_name, last_name, email, gender, flat_no);
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet read(Connection conn, String ans) {
        Statement statement;
        try {
            String query = String.format("select owner_info.*,maintenance_info.cost from owner_info JOIN maintenance_info on owner_info.flat_no=maintenance_info.flat_no where maintenance_info.paid = '%s'",ans);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public ResultSet occupied(Connection conn, Integer ans) {
        Statement statement;
        try {
            String query = String.format("select owner_info.* from owner_info,flat_info where owner_info.flat_no =flat_info.flat_no and flat_info.bedrooms=%d",ans);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public ResultSet vacent(Connection conn, Integer ans) {
        Statement statement;
        try {
            String query = String.format("select flat_info.flat_no,flat_info.flat_cost, maintenance_info.cost as \"maintenance_cost\" from flat_info JOIN maintenance_info on maintenance_info.flat_no = flat_info.flat_no where flat_info.bedrooms = '%d' and flat_info.vacent='yes'",ans);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
