/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.SQLException;

public class DB2 {
    private DB1 stMan;

    public DB2() throws ClassNotFoundException, SQLException {
        stMan = new DB1("Game.accdb");
    }

    public DB1 getStorageManager() {
        return stMan;
    }

}

