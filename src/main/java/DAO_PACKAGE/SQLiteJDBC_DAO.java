package DAO_PACKAGE;

import java.sql.*;

/**
 * Created by E on 03/04/2016.
 */
public class SQLiteJDBC_DAO {
    static Connection c = null;

    public static void openConnection() {

        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MultiDB.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("FAILED SQL");
            System.exit(0);
        }
    }

    public static void closeConnection() {
        try {
            c.close();
            //System.out.println("Closed database successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getLastID() {
        openConnection();
        String sql;
        int LastID = 0;
        try {
            Statement stmt = c.createStatement();


            sql = "select max (id) from BROWSER_SHARING";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                LastID = rs.getInt("max (id)");
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LastID;
    }

    public static void resetTableBrowserSharing() {
        try {
            int LastID = getLastID();// = stmt.executeUpdate(sql);
            Statement stmt = null;
            openConnection();
            stmt = c.createStatement();
            String sql;
            sql = "DELETE FROM BROWSER_SHARING;";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO BROWSER_SHARING " +
                    "VALUES" +

                    //"('"+(insertvalue)+ "','13.03.2006 13.13','TAKEN')";//*/
                    "('" + 0 + "','NULL','FREE')," +
                    "('" + 1 + "','NULL','FREE')," +
                    "('" + 2 + "','NULL','FREE')," +
                    "('" + 3 + "','NULL','FREE')," +
                    "('" + 4 + "','NULL','FREE')," +
                    "('" + 5 + "','NULL','FREE'" +
                    ")";//*/
            System.out.println("STRING IS: " + sql);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            closeConnection();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("FAILEDx2");
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public static void takeBrowser(int insertvalue, String fullid, String takenstring) {
        try {
            int LastID = getLastID();// = stmt.executeUpdate(sql);
            Statement stmt = null;
            openConnection();
            stmt = c.createStatement();
            String sql;
            sql = "UPDATE BROWSER_SHARING " +
                    "SET FULLID="+ "'"+ fullid + "',STATUS='"+takenstring+"'"+
                    "WHERE " + "ID = " + insertvalue;
            System.out.println("STRING IS: " + sql);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            closeConnection();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("FAILEDx2");
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public static int findFree() {
        //Connection c = null;

        int returnvalue=-1;//-1 means nothing is free at the moment
        try {
            openConnection();
            Statement stmt = null;
            stmt = c.createStatement();
            String sql;
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM BROWSER_SHARING ORDER BY ID DESC;");
            while (rs.next()) {
                System.out.println("HERE");
                try{
                    if(rs.getString("STATUS").equals("FREE")) returnvalue= rs.getInt("ID");
                    //System.out.println("minid = " + minid );
                }
                catch (Exception e){
                }
            }
            stmt.close();
            c.close();
            closeConnection();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Table created successfully");
        return returnvalue;


    }
    public static void giveback(int insertvalue, String fullid, String freestring) {
        try {
            //int LastID = getLastID();// = stmt.executeUpdate(sql);
            Statement stmt = null;
            openConnection();
            stmt = c.createStatement();
            String sql;
            sql = "UPDATE BROWSER_SHARING " +
                    "SET FULLID="+ "'"+ fullid + "',STATUS='"+freestring+"'"+
                    "WHERE " + "ID = " + insertvalue;
            System.out.println("STRING IS: " + sql);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            closeConnection();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("FAILEDx2");
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

}
