package pe.edu.alicorp.serviceorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.alicorp.serviceorder.model.DetallePedido;
import pe.edu.alicorp.serviceorder.repository.DetallePedidoRepository;

import java.util.List;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public int getCantidadTotalByPedido(Long codPedido){
        List<DetallePedido> detallePedidos = detallePedidoRepository.findByCodPedido(codPedido);
        int total = 0;
        for (DetallePedido detalle : detallePedidos) {
            total += detalle.getCantidad();
        }
        return total;
    }

}
