package DAO_PACKAGE;

import java.sql.*;

public class SQLiteJDBC_Insert_RESULT_VALUES {
    static Connection c = null;

    public static void openConnection() {

        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MultiDB.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("FAILEDx1");
            System.exit(0);
        }
    }

    public static void closeConnection() {
        try {
            c.close();
            System.out.println("Closed database successfully");
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
    public static void takebrowser(int insertvalue, String fullid, String takenstring) {
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



    //-----------------------------------------------------------------------------------------
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "delete from RESULT_VALUES";
            stmt.executeUpdate(sql);
            System.out.println("Records from RESULT_VALUES deleted successfully");
            sql = "INSERT INTO RESULT_VALUES " +
                    "VALUES" +
                    "(0,'AFA','EUR', '1.1','1.2')," +
                    "(1, 'EUR', 'QAR', '1.12345','1.0')," +
                    "(2, 'USD','EUR','3.1','3.2')," +
                    "(3, 'QAR', 'EUR','4','4.1')";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("FAILEDx3");
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}