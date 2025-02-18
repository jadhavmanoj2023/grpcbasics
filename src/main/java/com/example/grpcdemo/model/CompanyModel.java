package com.example.grpcdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "companies")
public class CompanyModel {

    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String gst;
    private String regAdd;

    // No-args constructor
    public CompanyModel() {
    }

    // All-args constructor
    public CompanyModel(String id, String name, String email, String phone, String gst, String regAdd) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gst = gst;
        this.regAdd = regAdd;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGst() {
        return gst;
    }

    public String getRegAdd() {
        return regAdd;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public void setRegAdd(String regAdd) {
        this.regAdd = regAdd;
    }

    // Optional: Override toString() for better readability
    @Override
    public String toString() {
        return "CompanyModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gst='" + gst + '\'' +
                ", regAdd='" + regAdd + '\'' +
                '}';
    }
}
