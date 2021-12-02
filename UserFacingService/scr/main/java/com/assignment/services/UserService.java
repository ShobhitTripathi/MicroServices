package com.benz.assignment.services;

import com.benz.assignment.model.UserInfo;
import com.benz.assignment.service2.User;
import com.benz.assignment.service2.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;

@Service
public class UserService {

    //service1 : get all user details
    public String getAllUsers() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
        // stubs - generate from proto
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.Empty request = User.Empty.newBuilder().build().newBuilder().build();
        Iterator<User.APIResponse> response = userStub.getAllUsers(request);

        System.out.println(response.toString());
        return response.toString();

    }

    //service1 : get user details
    public String getUser(String name) {
        String uri = "http://localhost:8082/getUserInfo/{name}";
        RestTemplate rest = new RestTemplate();
        String result = rest.getForObject(uri, String.class, name);
        return "get user";
    }

    //Service1: to add user
    public String addUser(UserInfo userInfo) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
        // stubs - generate from proto
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.UserRequest request = User.UserRequest.newBuilder().build().newBuilder().
                setName(userInfo.getName()).
                setDob(userInfo.getDob()).
                setSalary(userInfo.getSalary()).
                setAge(userInfo.getAge()).
                setFileType(userInfo.getFileType())
                .build();
        User.APIResponse response = userStub.addUser(request);

        System.out.println(response.getResponseMessage());
        return response.getResponseMessage();
    }

    //service1: to update the details from given user
    public String updateUser(UserInfo userInfo, String name) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).useTransportSecurity().build();
        // stubs - generate from proto
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.UserRequest request = User.UserRequest.newBuilder().build().newBuilder().
                setName(userInfo.getName()).
                setDob(userInfo.getDob()).
                setSalary(userInfo.getSalary()).
                setAge(userInfo.getAge()).
                setFileType(userInfo.getFileType())
                .build();
        User.APIResponse response = userStub.addUser(request);

        System.out.println(response.getResponseMessage());
        return response.getResponseMessage();
    }
}
