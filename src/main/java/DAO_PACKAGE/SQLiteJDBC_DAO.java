package DAO_PACKAGE;

import com.ETMS1.FunctionsDaoETS2;
import com.ETMS1.GUI;

import java.sql.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by E on 03/04/2016.
 */
public class SQLiteJDBC_DAO {
    static Connection c = null;
    static public Lock lockobject = new ReentrantLock();
    static public Lock lockobject2 = new ReentrantLock();

    public static void openConnection() {

        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");

            c = DriverManager.getConnection("jdbc:sqlite:F:\\JAVA_CURSUS_OCP\\FolderToTestMAVEN2\\MultiScanner1\\MultiDB.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
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

    public static void resetTableBrowserSharing(int totalspots) {
        try {
            int LastID = getLastID();// = stmt.executeUpdate(sql);
            Statement stmt = null;
            openConnection();
            stmt = c.createStatement();
            String sql;
            sql = "DELETE FROM BROWSER_SHARING;";
            stmt.executeUpdate(sql);
            //int totalspots = 2;
            sql = "INSERT INTO BROWSER_SHARING " +
                    //"VALUES" +
                    "VALUES";

            //"('"+(insertvalue)+ "','13.03.2006 13.13','TAKEN')";//*/
            for (int i = 0; i < totalspots - 1; i++) {
                sql = sql + "('" + i + "','NULL','FREE'),";
            }
                    /*"('" + 0 + "','NULL','FREE')," +
                    "('" + 1 + "','NULL','FREE')," +
                    "('" + 2 + "','NULL','FREE')," +
                    "('" + 3 + "','NULL','FREE')," +
                    "('" + 4 + "','NULL','FREE')," +*/
            sql = sql + "('" + (totalspots - 1) + "','NULL','FREE'" + ")";
            //System.out.println("STRING IS: " + sql);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("FAILEDx4");
            System.exit(0);
        }
        System.out.println("resetTableBrowserSharing Records created successfully");
    }

    public static void takeBrowser(int insertvalue, String fullid, String takenstring) {
        try {
            int LastID = getLastID();// = stmt.executeUpdate(sql);
            Statement stmt = null;
            openConnection();
            stmt = c.createStatement();
            String sql;
            sql = "UPDATE BROWSER_SHARING " +
                    "SET FULLID=" + "'" + fullid + "',STATUS='" + takenstring + "'" +
                    "WHERE " + "ID = " + insertvalue;
            System.out.println("STRING IS: " + sql);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("FAILEDx5");
            System.exit(0);
        }
        System.out.println("takeBrowser Records created successfully");
    }

    public static int findFree() {
        //Connection c = null;
        System.out.println("GUI.GUIlockobject.toString()======" + GUI.GUIlockobject.toString());
        GUI.GUIlockobject.lock();
        SQLiteJDBC_DAO.lockobject2.lock();
        int returnvalue = -1;//-1 means nothing is free at the moment
        try {
            openConnection();
            Statement stmt = null;
            stmt = c.createStatement();
            String sql;
            ResultSet rs;
            //Thread.sleep(1000);
            rs = stmt.executeQuery("SELECT * FROM BROWSER_SHARING ORDER BY ID DESC;");
            while (rs.next()) {
                System.out.println("HERE");
                try {
                    if (rs.getString("STATUS").equals("FREE")) returnvalue = rs.getInt("ID");
                    //System.out.println("minid = " + minid );
                } catch (Exception e) {
                }
            }
            stmt.close();
            c.close();
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage() + "xxxxxxxx");
            System.exit(0);
        }
        //System.out.println("Table created successfully");
        SQLiteJDBC_DAO.lockobject2.unlock();
        GUI.GUIlockobject.unlock();
        return returnvalue;


    }


    /////------
    public static int takeFreeBrowser(String fullid) {
        int returnvalue = -1;
        //GUI.GUIlockobject.lock();
        try {
            int LastID = getLastID();// = stmt.executeUpdate(sql);
            Statement stmt = null;

            openConnection();
            stmt = c.createStatement();
            String sql;
            ResultSet rs;
            synchronized (lockobject) {
                //if(lockobject.tryLock()){
                //System.out.println("TRYLOCK--------------------------------------------");
                //c.wait();

                //}
                rs = stmt.executeQuery("SELECT * FROM BROWSER_SHARING ORDER BY ID DESC;");

                while (rs.next()) {
                    //System.out.println("HERENEXT");
                    try {
                        if (rs.getString("STATUS").equals("FREE")) {
                            returnvalue = rs.getInt("ID");
                            System.out.println("GIVING returnvalue=" + returnvalue + " " + new FunctionsDaoETS2().getDateString());

                            sql = "UPDATE BROWSER_SHARING " +
                                    "SET FULLID=" + "'" + fullid + "',STATUS='" + "TAKEN" + "'" +
                                    "WHERE " + "ID = " + returnvalue + " AND STATUS='FREE'";
                            System.out.println("STRING1 IS: " + sql);
                            int x = stmt.executeUpdate(sql);
                            System.out.println("updatestament gives = "+x);
                            stmt.close();
                            c.commit();
                            return returnvalue;


                            //break;
                        }
                        //System.out.println("minid = " + minid );
                    } catch (Exception e) {
                        System.out.println(e.getClass().getName() + ": " + e.getMessage() + "xxxx0001");
                        returnvalue=-1;
                    }
                }
                if (returnvalue != -1) {
                    sql = "UPDATE BROWSER_SHARING " +
                            "SET FULLID=" + "'" + fullid + "',STATUS='" + "TAKEN" + "'" +
                            "WHERE " + "ID = " + returnvalue;
                    System.out.println("STRING2 IS: " + sql);
                    stmt.executeUpdate(sql);
                    stmt.close();
                    c.commit();
                }
                //c.notify();
            }


            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());

            System.out.println("FAILEDx7");
            return returnvalue;
            //System.exit(0);
        }
        System.out.println("takeFreeBrowser Records created successfully");
        //lockobject.unlock();
        //GUI.GUIlockobject.unlock();
        return returnvalue;
    }

    public static int findFreeCopy() {
        //Connection c = null;
        System.out.println("GUI.GUIlockobject.toString()======" + GUI.GUIlockobject.toString());
        GUI.GUIlockobject.lock();
        SQLiteJDBC_DAO.lockobject2.lock();
        int returnvalue = -1;//-1 means nothing is free at the moment
        try {
            openConnection();
            Statement stmt = null;
            stmt = c.createStatement();
            String sql;
            ResultSet rs;
            //Thread.sleep(1000);
            rs = stmt.executeQuery("SELECT * FROM BROWSER_SHARING ORDER BY ID DESC;");
            while (rs.next()) {
                System.out.println("HERE");
                try {
                    if (rs.getString("STATUS").equals("FREE")) returnvalue = rs.getInt("ID");
                    //System.out.println("minid = " + minid );
                } catch (Exception e) {
                }
            }
            stmt.close();
            c.close();
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage() + "xxxxxxxx");
            System.exit(0);
        }
        //System.out.println("Table created successfully");
        SQLiteJDBC_DAO.lockobject2.unlock();
        GUI.GUIlockobject.unlock();
        return returnvalue;


    }

    /////------
    public static void giveback(int insertvalue, String fullid, String freestring) {
        try {
            //int LastID = getLastID();// = stmt.executeUpdate(sql);
            Statement stmt = null;
            openConnection();
            stmt = c.createStatement();
            String sql;
            sql = "UPDATE BROWSER_SHARING " +
                    "SET FULLID=" + "'" + fullid + "',STATUS='" + freestring + "'" +
                    "WHERE " + "ID = " + insertvalue;
            System.out.println("STRING IS: " + sql);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("FAILEDx3");
            System.exit(0);
        }
        System.out.println("giveback Records created successfully");
    }

}
