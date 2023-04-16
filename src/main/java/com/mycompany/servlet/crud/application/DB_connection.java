/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet.crud.application;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DB_connection {
    Connection connection;

     
   
       public static void forName(String className){
           
       }
    
    public  Connection obtain_connection() {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DB_connection.class.getName()).log(Level.SEVERE, null, ex);
            }
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
            System.out.println("connection succesfull");
            return con;
        } catch (SQLException ex) {
            System.out.println("Connection error read the Log");
            Logger.getLogger(DB_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public int insert(crud_DB_utils a) {
        int status = 0;
        connection = obtain_connection();

        try {
            PreparedStatement insert_Statement;
            insert_Statement = connection.prepareStatement("Insert into crud_operation Value(?,?,?)");
            insert_Statement.setInt(1, a.getid());
            insert_Statement.setString(2, a.get_title());
            insert_Statement.setString(3, a.get_description());
            status = insert_Statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
   public ArrayList<crud_DB_utils> read(){
       connection = obtain_connection();
       ArrayList list = new ArrayList<>();
        try {
            PreparedStatement read_ = connection.prepareStatement("Select *From crud_operation");
            ResultSet result = read_.executeQuery();
            while(result.next()){
                crud_DB_utils e = new crud_DB_utils();
                e.setid(result.getInt(1));
                e.set_title(result.getString(2));
                e.set_description(result.getString(3));
                list.add(e);
                
            }
                 
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
   }
   
   public int update(crud_DB_utils e){
       int status = 0;
       connection = obtain_connection();
        try {
            PreparedStatement update_  = connection.prepareStatement("Update crud_operation SET   title=?, description=? where id = ? ");
            update_.setString(1, e.get_title());
            update_.setString(2, e.get_description());
            update_.setInt(3, e.getid());
            status = update_.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB_connection.class.getName()).log(Level.SEVERE, null, ex);
        }return status;
   }
   
   public int delete(crud_DB_utils d){
       int status =0;
       connection = obtain_connection();
        try {
            PreparedStatement delete_ = connection.prepareStatement("Delete From crud_operation where id = ?");
            delete_.setInt(1, d.getid());
            status = delete_.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB_connection.class.getName()).log(Level.SEVERE, null, ex);
        }return status;
     
   }

}
