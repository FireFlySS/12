import java.sql.*;

public class Main {
    public static Connection connection;
    public static Statement statement;
    public static void main(String[] args) {
        try {
            connect();
            //           ResultSet rs = statement.executeQuery("SELECT * FROM main");



//           statement.executeUpdate("\n" +
//                   "INSERT INTO main(prodid,title,cost)\n" +
//                   "VALUES (15,'Maus', 100)");                    //добавляет значения в базу данных



//            ResultSetMetaData rsmd = rs.getMetaData();
//            for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
//                System.out.println(rsmd.getColumnName(i));
//
//            }
//            while (rs.next()){
//                System.out.println(rs.getInt(1 ) + " " + rs.getString("title"));  //выводит название столбцов и id + title
//            }

long t = System.currentTimeMillis();
            for (int i = 0; i <10000 ; i++) {
                statement.executeUpdate("INSERT INTO main(prodids,title,cost)\n" +
                        "VALUES (16,'tank', 1000)  ");
                
            }
            System.out.println(System.currentTimeMillis() - t);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                disconnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Shop.db");
        statement = connection.createStatement();
    }
    public static void disconnection() throws SQLException {
        connection.close();
    }
  }
