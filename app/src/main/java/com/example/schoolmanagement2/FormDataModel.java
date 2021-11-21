package com.example.schoolmanagement2;

public class FormDataModel {
    String StudentName;
    String FatherName;
    String MotherName;
    String AdharCardNumber;
    String EmailId;
    String DOB;
    String FatherOccupation;
    String BankAccNumber;
    String Category;
    String FamilyId;
    String Address;
    String City;
    String gender;

    public FormDataModel() {
    }

    public FormDataModel(String studentName, String fatherName, String motherName, String adharCardNumber, String emailId, String DOB, String fatherOccupation, String bankAccNumber, String category, String familyId, String address, String city, String gender) {
        StudentName = studentName;
        FatherName = fatherName;
        MotherName = motherName;
        AdharCardNumber = adharCardNumber;
        EmailId = emailId;
        this.DOB = DOB;
        FatherOccupation = fatherOccupation;
        BankAccNumber = bankAccNumber;
        Category = category;
        FamilyId = familyId;
        Address = address;
        City = city;
        this.gender = gender;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getAdharCardNumber() {
        return AdharCardNumber;
    }

    public void setAdharCardNumber(String adharCardNumber) {
        AdharCardNumber = adharCardNumber;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getFatherOccupation() {
        return FatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        FatherOccupation = fatherOccupation;
    }

    public String getBankAccNumber() {
        return BankAccNumber;
    }

    public void setBankAccNumber(String bankAccNumber) {
        BankAccNumber = bankAccNumber;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getFamilyId() {
        return FamilyId;
    }

    public void setFamilyId(String familyId) {
        FamilyId = familyId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
