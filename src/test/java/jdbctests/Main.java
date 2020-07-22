package jdbctests;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbUrl ="jdbc:oracle:thin:@100.25.26.177:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";
        //create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         //create statement object
        Statement statement = connection.createStatement();
        //run query and get the result in resultset object
      //  ResultSet resultSet = statement.executeQuery("select * from regions");
        ResultSet resultSet1=statement.executeQuery("select first_name,last_name,salary from employees");
        while (resultSet1.next()){
            System.out.println(resultSet1.getString(1) + " " + resultSet1.getString("last_name") + "-" + resultSet1.getString(3));


        }
        //move to pointer to first row

//        resultSet.next();
//
//        System.out.println(resultSet.getString(1)+" "+resultSet.getString("region_name"));
//        resultSet.next();
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString(1) + " " + resultSet.getString("region_name"));
//        }
            //closing all connections
        resultSet1.close();
        statement.close();
        connection.close();


    }
}
