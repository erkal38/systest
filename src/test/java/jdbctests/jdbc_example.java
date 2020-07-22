package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;

public class jdbc_example {
    String dbUrl = "jdbc:oracle:thin:@100.25.26.177:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from departments");

        resultSet.last();
        System.out.println(resultSet.getRow());
        resultSet.beforeFirst();
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }

//        while (resultSet.next()){
//            System.out.println(resultSet.getString(2));
//        }
//         resultSet.last();
//        System.out.println(resultSet.getRow());
//        System.out.println("=================================");
//        ResultSet resultSet1 = statement.executeQuery("select * from departments");
//        while (resultSet1.next()){
//            System.out.println(resultSet1.getString(2));
//        }
//        resultSet1.last();
//        System.out.println(resultSet1.getRow());

        resultSet.close();
        statement.close();
        connection.close();

    }
    @Test
    public void metaData() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from departments");
        DatabaseMetaData metaData = connection.getMetaData();
        String userName = metaData.getUserName();
        System.out.println(userName);
        System.out.println(metaData.getDriverVersion());
        System.out.println(metaData.getDriverName());
        System.out.println(metaData.getDatabaseProductVersion());
        System.out.println(metaData.getDatabaseProductName());


    }
}