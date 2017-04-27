/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Beans.FormBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author pavan
 */
public class DataAccess {

    public boolean SingUp(FormBeans beans) {
        boolean flag=false;
        try{
       Connection con=new DataConnection().getConnection();
       
       PreparedStatement pstmt=con.prepareStatement("insert into users(uname,fname,password,email,mobile,age,gender) values(?,?,?,?,?,?,?)");
       pstmt.setString(1, beans.getUname());
       pstmt.setString(2,beans.getFname());
       pstmt.setString(3,beans.getPassword());
       pstmt.setString(4, beans.getEmail());
       pstmt.setLong(5,beans.getMobile());
       pstmt.setInt(6, beans.getAge());
       pstmt.setString(7, beans.getGender());
       
       int i=pstmt.executeUpdate();
       
       if(i!=0){
       flag=true;
       }
        }catch(Exception e){
            flag=false;
            e.printStackTrace();
        }
               
        
        return flag;
    }
    
}
