package com.example.gateserver.controller;

import com.example.gateserver.dto.ResultDto;
import com.example.gateserver.dto.TransferDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class GateController {

    private final LoadBalancerClient loadBalancerClient;

    private final DiscoveryClient discoveryClient;

    public GateController(DiscoveryClient discoveryClient, LoadBalancerClient loadBalancerClient) {
        this.discoveryClient = discoveryClient;
        this.loadBalancerClient = loadBalancerClient;
    }

    @GetMapping("/{a}/{b}/{calc}")
    public ResponseEntity<ResultDto> calculatorEndPoint(@PathVariable("a") int a,
                                                        @PathVariable("calc") String jenisPerhitungan,
                                                        @PathVariable("b") int b) {
        ServiceInstance serviceInstance;
        TransferDto transferDto = new TransferDto();
        transferDto.setA(a);
        transferDto.setB(b);


        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            System.out.println("Service: " + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);

            for (ServiceInstance instance : instances) {
                System.out.println("Instance: " + instance.getServiceId()
                        + " - Host: " + instance.getHost()
                        + " - Port: " + instance.getPort());
            }
        }

        switch (jenisPerhitungan) {
            case "layang-layang":
                serviceInstance = loadBalancerClient.choose("\"layang-layang-server\"");
                break;
            case "persegi-panjang":
                serviceInstance = loadBalancerClient.choose("\"persegi-panjang-server\"");
                break;
            default:
                serviceInstance = loadBalancerClient.choose("\"segitiga-server\"");
        }

        String selectedUrl = serviceInstance.getUri().toString();
        String baseUrl = selectedUrl + "/calc";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultDto> response = restTemplate.postForEntity(baseUrl, transferDto, ResultDto.class);
        ResultDto resultDto = response.getBody();
        return ResponseEntity.ok(resultDto);
    }
}
