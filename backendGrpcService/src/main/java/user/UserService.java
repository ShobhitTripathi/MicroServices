package user;

import filesHandler.CSVWriter1;
import io.grpc.stub.StreamObserver;
import model.UserInfo;
import org.benz.GrpcService.User;
import org.benz.GrpcService.userGrpc;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void getAllUsers(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside grpcService getAllUsers()");

//        String name = request.getName();
        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        // return success message
        response.setResponseCode(0).setResponseMessage("getAllUsers is SUCCESS");

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void addUser(User.UserRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside grpcService addUser()");
        UserInfo userInfo = new UserInfo();
        userInfo.setName(request.getName());
        userInfo.setDob(request.getDob());
        userInfo.setSalary(request.getSalary());
        userInfo.setAge(request.getAge());
        String fileType = request.getFileType();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        CSVWriter1 csv = new CSVWriter1();
        csv.writeDataLineByLine("D:\\csv\\test1.csv", userInfo);
        // return success message
        response.setResponseCode(0).setResponseMessage("SUCCESS");

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(User.UserRequest request, StreamObserver<User.APIResponse> responseObserver) {
        super.updateUser(request, responseObserver);
    }
}
