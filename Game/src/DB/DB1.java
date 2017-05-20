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
    static int Games;
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
        String query = "SELECT GameID FROM Games ORDER BY GameID ASC";

        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery(query);
        while (rs.next()) {
            id = rs.getInt(1);
            id++;

        }

    }

    public static void getGames() throws SQLException {
        String query = "SELECT Games FROM User ORDER BY Games ASC";

        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery(query);
        while (rs.next()) {
            Games = rs.getInt(1);
            Games++;

        }
        toGames();
    }

    public static void toGames() throws SQLException {
        try {
            Statement sta = conn.createStatement();
            sta.executeUpdate("UPDATE User SET Games = ('" + Games + "') WHERE ID = 0");

            System.out.println("Inserted into database");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static int LoadGame() throws SQLException {
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery("SELECT LoadGame FROM User");
        while (rs.next()) {
            int Game = rs.getInt(1);
            return Game;
        }
        return 0;
    }

    public static void LoadGame2(int luku) throws SQLException {
        try {
            Statement sta = conn.createStatement();
            sta.executeUpdate("UPDATE User SET LoadGame = ('" + luku + "') WHERE ID = 0");

            System.out.println("Inserted into database");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void toDB(String City, String Name, int vaikeus, int aloitusKassa) {
        try {
            Statement sta = conn.createStatement();

            sta.executeUpdate("INSERT INTO Games (GameID, CityName, PlayerName, Difficulty, StartMoney) VALUES ('" + id + "', '" + City + "', '" + Name + "', '" + vaikeus + "', '" + aloitusKassa + "' );");

            System.out.println("Inserted into database");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
