
package Controler;


import Model.Entry;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

public class SearchEntries {
    List<Entry> Entries = new ArrayList<>();
    
    public List<Entry> getAllEntries(){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from entries");
            while(rs.next()){
                System.out.println("Entry ID="+rs.getInt("id")+", Address="+rs.getString("address")+", city="+rs.getString("city")+", Country="+rs.getString("country"));                 
                Entries.add(new Entry(rs.getInt("id"), rs.getInt("user"), rs.getString("address"), rs.getString("city"),rs.getString("country")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
                try {
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return Entries;
    }
    
    
    
    
}
