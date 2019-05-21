import java.sql.*;

public class Main {

    private final static String url = "jdbc:postgresql://localhost:5432/2019-05-20_AM_CW";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

            ex1(conn);
            ex2(conn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void ex1(Connection conn){
        try
        {
            String SQL = "INSERT INTO Boxes(Code,Contents,Value,Warehouse) VALUES('0901','Paper',90.1,4);";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
//            stmt.executeQuery(SQL);
            System.out.println(rs.getString(0));
//            while (rs.next())
//            {
//                System.out.println(rs.getInt("code"));
//            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void ex2(Connection conn){
        try
        {
            String SQL = "Select warehouse, avg(value) from boxes group by warehouse;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next())
            {
                System.out.print(rs.getString(0)+"  ");
                System.out.print(rs.getString(1)+"\n");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        connect();
    }
}
