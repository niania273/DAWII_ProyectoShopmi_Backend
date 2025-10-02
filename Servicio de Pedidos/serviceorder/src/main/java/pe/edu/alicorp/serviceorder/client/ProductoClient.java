package pe.edu.alicorp.serviceorder.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient( name = "serviceproduct", url = "http://localhost:8083")
public interface ProductoClient {
}
