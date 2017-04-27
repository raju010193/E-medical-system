/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Beans.FormBeans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author pavan
 */
public class AdminDao {

    PreparedStatement pstmt;
    Connection con;
    ResultSet result;

    public boolean addStaff(FormBeans bean) {
        boolean flag = false;
        try {
            con = new DataConnection().getConnection();
            pstmt = con.prepareStatement("insert into staff(name,exp,department,djoining,emptype,gender) values(?,?,?,?,?,?)");

            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getExperience());
            pstmt.setString(3, bean.getDepartment());
            pstmt.setString(4, bean.getDateOfJoin());
            pstmt.setString(5, bean.getEmpType());
            pstmt.setString(6, bean.getGenderStaf());

            int i = pstmt.executeUpdate();
            if (i != 0) {

                flag = true;
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }



        return flag;
    }
//add medicine information

    public boolean addMedicine(FormBeans beans) {
        boolean flag = false;
        try {
            con = new DataConnection().getConnection();
            pstmt = con.prepareStatement("insert into medicines(mname,mcompany,hbranch,mdate,edate,lname)values(?,?,?,?,?,?)");
            pstmt.setString(1, beans.getMedicineName());
            pstmt.setString(2, beans.getMedicineCompany());
            pstmt.setString(3, beans.getHospitalBranch());
            pstmt.setString(4, beans.getManufacturingDate());
            pstmt.setString(5, beans.getExpireDate());
            pstmt.setString(6, beans.getLableName());

            int i = pstmt.executeUpdate();

            if (i != 0) {
                flag = true;
            }

        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }

        return flag;
    }

    public ArrayList<FormBeans> PatientRequests() {
        ArrayList<FormBeans> requests = null;
        try {
            con = new DataConnection().getConnection();
            pstmt = con.prepareStatement("select* from booking ORDER BY id DESC");



            //  pstmt=con.prepareStatement("SELECT * FROM booking ORDER BY id DESC;");

            ResultSet res = pstmt.executeQuery();
            requests = new ArrayList<FormBeans>();
            while (res.next()) {

                FormBeans beans = new FormBeans();

                if (res.getInt("deleted") == 0) {
                    beans.setPatientName(res.getString("name"));
                    beans.setPatientAge(res.getInt("age"));
                    beans.setBookDate(res.getString("date"));
                    beans.setProblemType(res.getString("problem"));
                    beans.setPatientDepartment(res.getString("department"));
                    beans.setPatientGender(res.getString("gender"));
                    beans.setId(res.getInt("id"));
                    beans.setStatus(res.getString("status"));
                    requests.add(beans);
                }
            }

        } catch (Exception e) {
            // history=null;
            e.printStackTrace();
        }
        return requests;
    }

    public boolean AcceptRequest(int id) {
        boolean accept = false;
        try {
            con = new DataConnection().getConnection();
            pstmt = con.prepareStatement("update booking set status=? where id=?");

            pstmt.setString(1, "Accepted");
            pstmt.setInt(2, id);

            int i = pstmt.executeUpdate();

            if (i != 0) {
                accept = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accept;
    }

    public boolean DeleteRequest(int id) {
        boolean delete = false;
        try {
            con = new DataConnection().getConnection();
            pstmt = con.prepareStatement("update booking set deleted=? where id=?");

            pstmt.setInt(1, 1);
            pstmt.setInt(2, id);

            int i = pstmt.executeUpdate();

            if (i != 0) {
                delete = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }

    public boolean addBlood(FormBeans beans) {
        boolean flag = false;
        try {
            con = new DataConnection().getConnection();

            //pstmt = con.prepareStatement("insert into blood(dname,dage,group,dob,mobile,email,city,gender)values(?,?,?,?,?,?,?,?);");
                
pstmt=con.prepareStatement("insert into blood(dname,dage,dgroup,dob,mobile,email,city,gender)values(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, beans.getDonorName());
            pstmt.setInt(2, beans.getDonorAge());
            pstmt.setString(3, beans.getGroup());
            pstmt.setString(4, beans.getDonorDateOfBirth());
            pstmt.setLong(5, beans.getDonorMobile());
            pstmt.setString(6, beans.getDonorEmail());
            pstmt.setString(7, beans.getDonorCity());
            pstmt.setString(8, beans.getDonorGender());

            System.out.print(beans.getDonorEmail() + " " + beans.getDonorCity() + " " + beans.getDonorGender());
            int i = pstmt.executeUpdate();

            if (i != 0) {
                flag = true;
            }

        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }

        return flag;
    }

    public ArrayList<FormBeans> DonorInformation() {
      
        ArrayList<FormBeans> blood=null;
        try{
        con=new DataConnection().getConnection();
        pstmt=con.prepareStatement("select* from blood");
       ResultSet res= pstmt.executeQuery();
        blood=new ArrayList<FormBeans>();
        while(res.next()){
             FormBeans beans=new FormBeans();
             beans.setDonorName(res.getString("dname"));
             beans.setDonorAge(res.getInt("dage"));
             beans.setDonorCity(res.getString("city"));
             beans.setGroup(res.getString("dgroup"));
             beans.setDonorDateOfBirth(res.getString("dob"));
             beans.setDonorMobile(res.getLong("mobile"));
             beans.setDonorEmail(res.getString("email"));
             beans.setDonorGender(res.getString("gender"));
             
             blood.add(beans);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return blood;
    }

    public ArrayList<FormBeans> getOtherBranches(String branchName) {
        
        ArrayList<FormBeans> branch=null;
        try{
        con=new DataConnection().getConnection();
        pstmt=con.prepareStatement("select* from medicines where hbranch=?");
        pstmt.setString(1, branchName);
       ResultSet res= pstmt.executeQuery();
        branch=new ArrayList<FormBeans>();
        while(res.next()){
             FormBeans beans=new FormBeans();
             beans.setMedicineName(res.getString("mname"));
             beans.setMedicineCompany(res.getString("mcompany"));
             beans.setManufacturingDate(res.getString("mdate"));
             beans.setExpireDate(res.getString("edate"));
             beans.setHospitalBranch(res.getString("hbranch"));
            
             beans.setLableName(res.getString("lname"));
             
             branch.add(beans);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return branch;
    }

    public ArrayList<FormBeans> getUsers() {
        ArrayList<FormBeans> users=new ArrayList<FormBeans>();
        try{
            con=new DataConnection().getConnection();
            
            pstmt=con.prepareStatement("select* from users");
            result=pstmt.executeQuery();
            while(result.next()){
                 FormBeans beans=new FormBeans();
           beans.setFname(result.getString("fname"));
           beans.setUname(result.getString("uname"));
           beans.setEmail(result.getString("email"));
           beans.setMobile(result.getLong("mobile"));
           beans.setAge(result.getInt("age"));
           beans.setGender(result.getString("gender"));
           users.add(beans);
            }
        }
        catch(Exception w){
            w.printStackTrace();
        }
        
        return users;
                
    }

    public ArrayList<FormBeans> staff() {
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
}
