/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

/**
 *
 * @author osku0
 */
public class NewGameHelp1 {

    public static String Vaikeus(int luku) {
        if (luku == 1) {
            return "Easy";
        } else if (luku == 2) {
            return "Normal";
        } else if (luku == 3) {
            return "Hard";
        }
        return "";
    }
    
    public static int alkuKassa(int luku){
        if (luku == 1) {
            return 50;
        } else if (luku == 2) {
            return 40;
        } else if (luku == 3) {
            return 30;
        }
        return 0;
    }
}
