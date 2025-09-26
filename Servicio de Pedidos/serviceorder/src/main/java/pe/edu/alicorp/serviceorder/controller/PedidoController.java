package pe.edu.alicorp.serviceorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.alicorp.commondto.dto.PedidoDTO;
import pe.edu.alicorp.serviceorder.model.EstadoPedido;
import pe.edu.alicorp.serviceorder.service.EstadoPedidoService;
import pe.edu.alicorp.serviceorder.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private EstadoPedidoService estadoPedidoService;

//    @GetMapping("/obtenerpedidos/{id}")
//    public List<PedidoDTO> obtenerPedidos(){
//        //Obtener nombre del cliente
//
//        return pedidoService.findAll()
//                .stream()
//                .map(pedido -> {
//                    String nomEstado = estadoPedidoService.findById(pedido.getCodestado())
//                            .map(EstadoPedido::getNomEstado)
//                            .orElse("");
//
//                    return new PedidoDTO(
//                            pedido.getCodpedido(),
//                            pedido.getFecped(),
//                            pedido.getPreciototal(),
//                            nomEstado,
//                            pedido.isEstped()
//                    );
//                })
//                .toList();
//    }


}
