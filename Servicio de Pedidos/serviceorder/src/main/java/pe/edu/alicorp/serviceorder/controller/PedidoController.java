package pe.edu.alicorp.serviceorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.alicorp.commondto.dto.PedidoDetalleResponseDTO;
import pe.edu.alicorp.commondto.dto.PedidoResponseDTO;
import pe.edu.alicorp.commondto.dto.ProductoPedidoResponseDTO;
import pe.edu.alicorp.serviceorder.mapper.PedidoMapper;
import pe.edu.alicorp.serviceorder.model.Pedido;
import pe.edu.alicorp.serviceorder.service.DetallePedidoService;
import pe.edu.alicorp.serviceorder.service.EstadoPedidoService;
import pe.edu.alicorp.serviceorder.service.PedidoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private EstadoPedidoService estadoPedidoService;
    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("/ListarPedidos/{id}")
    public ResponseEntity<List<PedidoResponseDTO>> listarPedidos(){
        //UsuarioClient para obtener cliente
        //UsuarioDTO usuarioDTO = usuarioClient
        return ResponseEntity.ok(pedidoService.listarPedidos().stream().map(pedido ->
                        PedidoMapper.toDTO(
                                pedido,
                                "cliente",
                                detallePedidoService.getCantidadTotalByPedido(pedido.getCodpedido())
                        )
                )
                .collect(Collectors.toList()));
    }

    /*@GetMapping("/ObtenerPedido/{codPedido}")
    public ResponseEntity<PedidoDetalleResponseDTO> obtenerPedido(@PathVariable Long codPedido){
        Pedido pedido = pedidoService.obtenerPedido(codPedido).orElseThrow();
        List<ProductoPedidoResponseDTO> productos;

    }*/

}
