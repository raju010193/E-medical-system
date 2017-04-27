/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pavan
 */
public class DataConnection {
    
  public Connection getConnection(){
    Connection con=null;
    
    try{
    
      Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_hospital", "root", "root");
            System.out.println("connected.....");
        
    }catch(Exception e){
    e.printStackTrace();
    }
    
    
    return con;
    
    }

}
