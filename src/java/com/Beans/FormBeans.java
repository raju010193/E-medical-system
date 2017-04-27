/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Beans;

/**
 *
 * @author pavan
 */
public class FormBeans {
    
    //SingUP form beans
    
    private String fname;
    private String uname;
    private String email;
    private String gender;
    private String password;
    private long mobile;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    //end SignUp
    
    //Stafff
    
    private String name;
    private String experience;
    private String dateOfJoin;
    private String department;
    private String genderStaf;
    private String empType;

    public String getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getGenderStaf() {
        return genderStaf;
    }

    public void setGenderStaf(String genderStaf) {
        this.genderStaf = genderStaf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //end staff
    //medicine 
    private String medicineName;
    private String medicineCompany;
    private String hospitalBranch;
    private String manufacturingDate;
    private String ExpireDate;
    private String lableName;

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String ExpireDate) {
        this.ExpireDate = ExpireDate;
    }

    public String getHospitalBranch() {
        return hospitalBranch;
    }

    public void setHospitalBranch(String hospitalBranch) {
        this.hospitalBranch = hospitalBranch;
    }

    public String getLableName() {
        return lableName;
    }

    public void setLableName(String lableName) {
        this.lableName = lableName;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getMedicineCompany() {
        return medicineCompany;
    }

    public void setMedicineCompany(String medicineCompany) {
        this.medicineCompany = medicineCompany;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
    
    //end medicine
    // Book Appointment
    
    private String patientName;
    private int patientAge;
    private String patientGender;
    private String patientDepartment;
    private String bookDate;
    private String problemType;
    private int id;
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientDepartment() {
        return patientDepartment;
    }

    public void setPatientDepartment(String patientDepartment) {
        this.patientDepartment = patientDepartment;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }
    //end book appointment
    
    //add blood
    private String donorName;
    private int donorAge;
    private String donorDateOfBirth;
    private String group;
    private String donorEmail;
    private String donorCity;
    private long donorMobile;
    private String donorGender;

    public String getDonorCity() {
        return donorCity;
    }

    public void setDonorCity(String donorCity) {
        this.donorCity = donorCity;
    }

    public String getDonorGender() {
        return donorGender;
    }

    public void setDonorGender(String donorGender) {
        this.donorGender = donorGender;
    }
    

    public String getDonorDateOfBirth() {
        return donorDateOfBirth;
    }

    public void setDonorDateOfBirth(String donorDateOfBirth) {
        this.donorDateOfBirth = donorDateOfBirth;
    }

    

  
    public int getDonorAge() {
        return donorAge;
    }

    public void setDonorAge(int donorAge) {
        this.donorAge = donorAge;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public long getDonorMobile() {
        return donorMobile;
    }

    public void setDonorMobile(long donorMobile) {
        this.donorMobile = donorMobile;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    
}
