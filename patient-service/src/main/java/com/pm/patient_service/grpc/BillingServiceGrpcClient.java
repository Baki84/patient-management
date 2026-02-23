package com.pm.patient_service.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class BillingServiceGrpcClient
{
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    public BillingServiceGrpcClient(
    @Value("${billing.service.grpc.address:localhost}") String serverAddress,
            @Value("${billing.service.grpc.port:9001}") int serverPort)
    {
        log.info("Connecting to Buildung service GRPC service at {}:{}", serverAddress, serverPort);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort).
                usePlaintext().build();

        blockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }
    public BillingResponse createBillingAccount(String patientId,String name,String email){
        BillingRequest request = BillingRequest.newBuilder().setPatientId(patientId)
                .setName(name).setEmail(email).build();
        BillingResponse response = blockingStub.createBillingAccount(request);
        log.info("Received response from billing service via GRPC: {}", response);
        return response;
    }
}
