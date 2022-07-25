package com.pranave.maintenance_app;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class DbFunctions {
	 static Connection conn = null;
	 public Connection connect_to_db(String dbname, String user, String pass) {
	        try {
	            Class.forName("org.postgresql.Driver");
	            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
	            if (conn != null) {
	                System.out.println("Connection Established");
	            } else {
	                System.out.println("Connection failed");
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return conn;
	    }
	 public DbFunctions()
	 {
     if(conn == null )
     {
    	 try {
    		    String lokasi = "D:/projects/zoho-internship";
    		            FileReader fr = new FileReader(lokasi);
    		            BufferedReader br = new BufferedReader(fr);
    		            String db = null, user = null, pass = null,line;
    		            while ((line = br.readLine()) != null) {
   		                    db = line.split(" ")[0];
    		                user = line.split(" ")[1];
    		                pass = line.split(" ")[2];
    		                Connection conn = connect_to_db(db,user,pass);
    		           }
     
	        }catch(Exception e) {System.out.println(e);}
     }
	 }
	 
	 public List<test> getValues_map()
	 {
		 List<test> values = new ArrayList<>();
	        Statement statement;
	        try {
	            String query = String.format("SELECT * FROM map");
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            while(rs.next())
	            {
	            	test t = new test();
	            	t.setId(rs.getInt(1));
	            	t.setFlat_no(rs.getInt(2));
	            	values.add(t);
	            }
	        return values;
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	 }
	 public List<flat_info> getValues_flats()
	 {
		 List<flat_info> values = new ArrayList<>();
	        Statement statement;
	        try {
	            String query = String.format("select flat_info.*,cost as Maintenance_cost from flat_info JOIN maintenance_info on flat_info.flat_no = maintenance_info.flat_no where vacent='yes' ;");
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            while(rs.next())
	            {
	            	flat_info i = new flat_info();
	            	i.setFlat_no(rs.getInt(1));
	            	i.setBedrooms(rs.getInt(2));
	            	i.setFlat_cost(rs.getLong(4));
	            	i.setMaintenance(rs.getLong(5));
	            	values.add(i);
	            }
	        return values;
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	 }
	 public List<owner_info> getValues_ownersinfo()
	 {
		 List<owner_info> values = new ArrayList<>();
	        Statement statement;
	        try {
	            String query = String.format("SELECT * FROM owner_info");
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            while(rs.next())
	            {
	                owner_info i = new owner_info();
	                i.setId(rs.getInt(1));
	                i.setFirst_name(rs.getString(2));
	                i.setLast_name(rs.getString(3));
	                i.setEmail(rs.getString(4));
	                i.setGender(rs.getString(5));
	            	values.add(i);
	            }
	        return values;
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	 }
	 public owner_info getValues_ownerinfo(Integer a)
	 {
	        try {
	            String query = String.format("SELECT * FROM owner_info where id =?");
	            PreparedStatement statement = conn.prepareStatement(query);
	            statement.setInt(1, a);
	            ResultSet rs = statement.executeQuery();
	                owner_info i = new owner_info();
	                while(rs.next())
	                {
	                i.setId(rs.getInt(1));
	                i.setFirst_name(rs.getString(2));
	                i.setLast_name(rs.getString(3));
	                i.setEmail(rs.getString(4));
	                i.setGender(rs.getString(5));
	                }
	        return i;
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	 }
	 public void create_owner(owner_info a)
	 {
		 try {
	            String query = String.format("INSERT INTO owner_info values(?,?,?,?,?)");
	            PreparedStatement st = conn.prepareStatement(query);
	            st.setInt(1,a.getId());
	            st.setString(2, a.getFirst_name());
	            st.setString(3, a.getLast_name());
	            st.setString(4, a.getEmail());
	            st.setString(5, a.getGender());
	            st.executeUpdate();

	        } catch (Exception e) {
	            System.out.println(e);
	        } 
	 }
	 public void delete_owner(int id)
	 {
		 try {
	            String query = String.format("DELETE FROM owner_info WHERE id=?");
	            PreparedStatement st = conn.prepareStatement(query);
	            st.setInt(1,id);
	            st.executeUpdate();

	        } catch (Exception e) {
	            System.out.println(e);
	        } 
	 }
	 public void update_flat(test a)
	 {
		 try {
	            String query = String.format("UPDATE map set id =? where flat_no = ?");
	            PreparedStatement st = conn.prepareStatement(query);
	            st.setInt(1,a.getId());
	            st.setInt(2,a.getFlat_no());
	            st.executeUpdate();

	        } catch (Exception e) {
	            System.out.println(e);
	        } 
	 }
	 public List<Owner_flatinfo> getValues_ownersflatinfo()
	 {
		 List<Owner_flatinfo> values = new ArrayList<>();
	        Statement statement;
	        try {
	            String query = String.format(" SELECT owner_info.*,flat_no from owner_info JOIN map on owner_info.id = map.id ;");
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            while(rs.next())
	            {
	                Owner_flatinfo i = new Owner_flatinfo();
	                i.setId(rs.getInt(1));
	                i.setFirst_name(rs.getString(2));
	                i.setLast_name(rs.getString(3));
	                i.setEmail(rs.getString(4));
	                i.setGender(rs.getString(5));
	                i.setFlat_no(rs.getInt(6));
	            	values.add(i);
	            }
	        return values;
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	 }
	 public List<Owner_flatinfo> getValues_ownersflatinfo_mtnc(String a)
	 {
		 List<Owner_flatinfo> values = new ArrayList<>();
	        Statement statement;
	        try {
	            String query = String.format("select owner_info.*,flat_no from owner_info JOIN map on owner_info.id = map.id where flat_no in(select flat_no  from maintenance_info where paid = '%s');",a);
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(query);
	            while(rs.next())
	            {
	                Owner_flatinfo i = new Owner_flatinfo();
	                i.setId(rs.getInt(1));
	                i.setFirst_name(rs.getString(2));
	                i.setLast_name(rs.getString(3));
	                i.setEmail(rs.getString(4));
	                i.setGender(rs.getString(5));
	                i.setFlat_no(rs.getInt(6));
	            	values.add(i);
	            }
	        return values;
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	 }
}
