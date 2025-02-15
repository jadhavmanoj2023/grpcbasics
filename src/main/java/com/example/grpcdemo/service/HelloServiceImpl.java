package com.example.grpcdemo.service;


import com.example.grpc.hello.HelloRequest;
import com.example.grpc.hello.HelloResponse;
import com.example.grpc.hello.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        //Build response
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage("Hello," + request.getName() + "!")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
