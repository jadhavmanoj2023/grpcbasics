package com.example.grpcdemo.service;

import com.example.grpc.company.Company;
import com.example.grpcdemo.model.CompanyModel;
import com.example.grpc.company.CompanyRequest;
import com.example.grpc.company.CompanyResponse;
import com.example.grpc.company.CompanyServiceGrpc;
import com.example.grpcdemo.repository.CompanyRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@GrpcService
public class CompanyServiceImpl extends CompanyServiceGrpc.CompanyServiceImplBase {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyServiceImpl() {
        System.out.println("✅ CompanyService is initialized and running!");
    }

    @Override
    public void getCompany(CompanyRequest request, StreamObserver<CompanyResponse> responseObserver) {

        Optional<CompanyModel> company = companyRepository.findById(request.getId());


        if(company.isPresent()){
          CompanyModel companyData = company.get();
            CompanyResponse response = CompanyResponse.newBuilder()
                    .setMessage("Company found")
                    .setCompany(Company.newBuilder()
                            .setId(companyData.getId())
                            .setName(companyData.getName())
                            .setEmail(companyData.getEmail())
                            .setPhone(companyData.getPhone())
                            .setRegAdd(companyData.getRegAdd())
                            .setGst(companyData.getGst())
                            .build())
                    .build();
            responseObserver.onNext(response);
        }else {
            responseObserver.onNext(CompanyResponse.newBuilder().setMessage("Company Not Found").build());
        }

        responseObserver.onCompleted();


    }

    @Override
    public void createCompany(Company request, StreamObserver<CompanyResponse> responseObserver) {
        // Convert gRPC request to MongoDB model
        CompanyModel company = new CompanyModel(null,
                request.getName(),
                request.getEmail(),
                request.getPhone(),
                request.getGst(),
                request.getRegAdd());
        CompanyModel savedCompany = companyRepository.save(company);

        //conver MongoDB model to gRPC response
        CompanyResponse response = CompanyResponse.newBuilder()
                .setMessage("Company Created Successfully")
                .setCompany(Company.newBuilder()
                        .setId(savedCompany.getId())
                        .setName(savedCompany.getName())
                        .setPhone(savedCompany.getPhone())
                        .setEmail(savedCompany.getEmail())
                        .setGst(savedCompany.getGst())
                        .setRegAdd(savedCompany.getRegAdd())
                        .build())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
