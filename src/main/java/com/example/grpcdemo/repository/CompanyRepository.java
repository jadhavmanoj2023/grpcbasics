package com.example.grpcdemo.repository;

import com.example.grpcdemo.model.CompanyModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<CompanyModel,String> {
}
