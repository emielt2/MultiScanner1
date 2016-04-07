package DAO_PACKAGE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteJDBC_Select_RESULT_VALUES {
    int returnvalue=0;
    public static int selectfree() {
        Connection c = null;
        Statement stmt = null;
        int returnvalue=-1;//-1 means nothing free
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MultiDB.db");
            System.out.println("Opened database successfully");
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
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Table created successfully");
        return returnvalue;


    }
}