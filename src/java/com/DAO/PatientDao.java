/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Beans.FormBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pavan
 */
public class PatientDao {
PreparedStatement pstmt;
Connection con;

    public boolean loginValidation(String userName,String password) {
        boolean flag=false;
        try{
            con=new DataConnection().getConnection();
            pstmt=con.prepareStatement("select uname from users where uname=? and password=?");
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            ResultSet res=pstmt.executeQuery();
            String name="";
            while(res.next()){
                name=res.getString("uname");
                flag=true;
            }
            if(name.equals(userName)){
             flag=true;   
            }
        }catch(Exception e){
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<FormBeans> AppointmentHistory(String userName) {
        ArrayList<FormBeans> history=null;
        try{
        con=new DataConnection().getConnection();
        pstmt=con.prepareStatement("select* from booking where uname=?");
        pstmt.setString(1, userName);
        ResultSet res=pstmt.executeQuery();
        history=new ArrayList<FormBeans>();
        while(res.next()){
            FormBeans beans=new FormBeans();
            beans.setPatientName(res.getString("name"));
            beans.setPatientAge(res.getInt("age"));
            beans.setBookDate(res.getString("date"));
            beans.setProblemType(res.getString("problem"));
            beans.setPatientDepartment(res.getString("department"));
            beans.setPatientGender(res.getString("gender"));
            beans.setStatus(res.getString("status"));
            history.add(beans);
        }
        
        }catch(Exception e){
           // history=null;
            e.printStackTrace();
        }
        return history;
    }

    public ArrayList<FormBeans> Profile(String userName) {
         ArrayList<FormBeans> profile=null;
        try{
        con=new DataConnection().getConnection();
        pstmt=con.prepareStatement("select* from users where uname=?");
        pstmt.setString(1, userName);
        ResultSet res=pstmt.executeQuery();
        profile=new ArrayList<FormBeans>();
        while(res.next()){
            FormBeans beans=new FormBeans();
           beans.setFname(res.getString("fname"));
           beans.setUname(res.getString("uname"));
           beans.setEmail(res.getString("email"));
           beans.setMobile(res.getLong("mobile"));
           beans.setAge(res.getInt("age"));
           beans.setGender(res.getString("gender"));
           
            profile.add(beans);
        }
        }catch(Exception e){
            profile=null;
            e.printStackTrace();
        }
        return profile;
    }

    public ArrayList<FormBeans> Medicines(String userName) {
          ArrayList<FormBeans> medicine=null;
        try{
        con=new DataConnection().getConnection();
        pstmt=con.prepareStatement("select* from medicines");
      
        ResultSet res=pstmt.executeQuery();
        medicine=new ArrayList<FormBeans>();
        while(res.next()){
            FormBeans beans=new FormBeans();
           beans.setMedicineName(res.getString("mname"));
           beans.setMedicineCompany(res.getString("mcompany"));
           beans.setHospitalBranch(res.getString("hbranch"));
           beans.setExpireDate(res.getString("edate"));
           beans.setManufacturingDate(res.getString("mdate"));
           beans.setLableName(res.getString("lname"));
           
            medicine.add(beans);
        }
        }catch(Exception e){
            medicine=null;
            e.printStackTrace();
        }
        return medicine;
    }

    public ArrayList<FormBeans> StaffInformation(String userName) {
          ArrayList<FormBeans> staff=null;
        try{
        con=new DataConnection().getConnection();
        pstmt=con.prepareStatement("select* from staff");
     
        ResultSet res=pstmt.executeQuery();
       staff=new ArrayList<FormBeans>();
        while(res.next()){
            FormBeans beans=new FormBeans();
                
           beans.setName(res.getString("name"));
           beans.setExperience(res.getString("exp"));
           beans.setDepartment(res.getString("department"));
           beans.setDateOfJoin(res.getString("djoining"));
           beans.setEmpType(res.getString("emptype"));
           beans.setGenderStaf(res.getString("gender"));
           
            staff.add(beans);
        }
        }catch(Exception e){
            staff=null;
            e.printStackTrace();
        }
        return staff;
    }

    public boolean BookSlot(FormBeans beans,String uname) {
        boolean bookSlot=false;
        try{
        con=new DataConnection().getConnection();
        
        pstmt=con.prepareStatement("select* from booking where date=?");
        
        pstmt.setString(1, beans.getBookDate());
        
        ResultSet result=pstmt.executeQuery();
        int count=0;
        while(result.next()){
            count++;
        }
        if(count<=10){
            pstmt=con.prepareStatement("insert into booking(name,uname,age,department,date,gender,problem,status,deleted) values(?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, beans.getPatientName());
            pstmt.setString(2, uname);
            pstmt.setInt(3,beans.getPatientAge());
            pstmt.setString(4, beans.getPatientDepartment());
            pstmt.setString(5, beans.getBookDate());
            pstmt.setString(6, beans.getPatientGender());
            pstmt.setString(7, beans.getProblemType());
            pstmt.setString(8, "Waiting");
            pstmt.setInt(9,0);
            
            int i=pstmt.executeUpdate();
            
            if(i!=0){
                bookSlot=true;
            }        
            
        }else{
            bookSlot=false;
        }
        
        }catch(Exception e){
             e.printStackTrace(); 
            return bookSlot;
        
        }
        return bookSlot;
    }

    
    
}
