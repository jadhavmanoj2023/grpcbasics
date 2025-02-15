package com.example.grpcdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyModel {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String gst;
    private String regAdd;
}
