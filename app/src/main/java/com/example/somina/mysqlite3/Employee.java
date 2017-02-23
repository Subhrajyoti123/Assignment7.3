package com.example.somina.mysqlite3;

import java.sql.Blob;

public class Employee {

    int id;
    String employeeName;
    String employeeAge;


    byte[] employeeimageInByte;

    public Employee(){

    }

    public Employee(int id,String employeeName,String employeeAge,byte employeeimageInByte[]){
        this.id = id;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeimageInByte = employeeimageInByte;
    }
    public Employee(String employeeName,String employeeAge,byte employeeimageInByte[]){
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeimageInByte = employeeimageInByte;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }


    public byte[] getEmployeeimageInByte() {
        return employeeimageInByte;
    }

    public void setEmployeeimageInByte(byte[] employeeimageInByte) {
        this.employeeimageInByte = employeeimageInByte;
    }


}
