import java.sql.*;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws SQLException {


        Connection connection=null;
        DbHelper helper=new DbHelper();
        PreparedStatement statement=null;
        ResultSet resultSet;

        try {
            String sql="delete from sakila.actor where first_name=? ";
            connection=helper.getConnection();
            statement= connection.prepareStatement(sql);

            statement.setString(1,"TAHA");
            int result=statement.executeUpdate();
            System.out.println("Kayıt silindi");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            helper.showErrorMessage(e);
            throw new RuntimeException(e);
        }finally {
            statement.close();
            connection.close();
        }





    }

public static void selectdemo() throws SQLException {


    Connection connection=null;
    DbHelper helper=new DbHelper();
    Statement statement=null;
    ResultSet resultSet;

    try {

        connection=helper.getConnection();
        statement= connection.createStatement();
        resultSet= statement.executeQuery("SELECT * FROM sakila.actor;");
        ArrayList<Actor> actors=new ArrayList<Actor>();
        while (resultSet.next()){
            actors.add(new Actor(resultSet.getString("first_name"), resultSet.getString("last_name") ));
        }
        System.out.println(actors.size());

    } catch (SQLException e) {
        System.out.println(e.getMessage());
        helper.showErrorMessage(e);
        throw new RuntimeException(e);
    }finally {
        connection.close();
    }


}

public static void insertData() throws SQLException {


    Connection connection=null;
    DbHelper helper=new DbHelper();
    PreparedStatement statement=null;
    ResultSet resultSet;

    try {
        String sql="insert into actor(first_name,last_name) values(?,?) ";
        connection=helper.getConnection();
        statement= connection.prepareStatement(sql);
        statement.setString(1,"TONY");
        statement.setString(2,"STARK");

        int result=statement.executeUpdate();
        System.out.println("Kayıt eklendi");


    } catch (SQLException e) {
        System.out.println(e.getMessage());
        helper.showErrorMessage(e);
        throw new RuntimeException(e);
    }finally {
        statement.close();
        connection.close();
    }



}

public void updateData() throws SQLException{
    Connection connection=null;
    DbHelper helper=new DbHelper();
    Statement statement=null;
    ResultSet resultSet;

    try {

        connection=helper.getConnection();
        statement= connection.createStatement();
        resultSet= statement.executeQuery("SELECT * FROM sakila.actor;");
        ArrayList<Actor> actors=new ArrayList<Actor>();
        while (resultSet.next()){
            actors.add(new Actor(resultSet.getString("first_name"), resultSet.getString("last_name") ));
        }
        System.out.println(actors.size());

    } catch (SQLException e) {
        System.out.println(e.getMessage());
        helper.showErrorMessage(e);
        throw new RuntimeException(e);
    }finally {
        connection.close();
    }



}






}












