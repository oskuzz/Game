/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author osku0
 */
public class DB1 {

    static int id;
    private static Connection conn;

    public DB1(String urlToDataBase) throws ClassNotFoundException, SQLException {

        String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
        Class.forName(driver);
        conn = DriverManager.getConnection("jdbc:ucanaccess://" + urlToDataBase);
        System.out.println("Connected");
    }

    public DB1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void getID() throws SQLException {
        String query = "SELECT ID FROM Login ORDER BY ID ASC";

        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery(query);
        while (rs.next()) {
            int ID = rs.getInt(1);
            id = ID;
            id++;
        }

    }

    public static void toDB(String City, String Name) {
        try {
            Statement sta = conn.createStatement();
            System.out.println(id);
            sta.executeUpdate("INSERT INTO Games (GameID, CityName, PlayerName) VALUES ('" + id + "', '" + City + "', '" + Name + "');");

            System.out.println("Inserted into database");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
