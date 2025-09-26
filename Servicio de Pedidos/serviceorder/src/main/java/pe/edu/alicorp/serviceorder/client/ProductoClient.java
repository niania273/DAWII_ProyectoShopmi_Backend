package pe.edu.alicorp.serviceorder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient( name = "product-service", url = "http://localhost:8082")
public interface ProductoClient {

    //@GetMapping("/productos/get")
    // public List<ProductDTO> getProductosByPedido(Long codpedido);
}
