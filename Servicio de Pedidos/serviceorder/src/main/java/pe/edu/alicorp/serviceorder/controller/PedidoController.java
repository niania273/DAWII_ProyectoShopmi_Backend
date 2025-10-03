package pe.edu.alicorp.serviceorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.alicorp.commondto.dto.PedidoDetalleResponseDTO;
import pe.edu.alicorp.commondto.dto.PedidoResponseDTO;
import pe.edu.alicorp.commondto.dto.ProductoPedidoResponseDTO;
import pe.edu.alicorp.commondto.dto.UsuarioDTO;
import pe.edu.alicorp.serviceorder.client.UsuarioClient;
import pe.edu.alicorp.serviceorder.mapper.PedidoMapper;
import pe.edu.alicorp.serviceorder.model.EstadoPedido;
import pe.edu.alicorp.serviceorder.model.Pedido;
import pe.edu.alicorp.serviceorder.service.DetallePedidoService;
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
    @Autowired
    private DetallePedidoService detallePedidoService;
    @Autowired
    private UsuarioClient usuarioClient;

    @GetMapping("/ListarPedidos/{id}")
    public ResponseEntity<List<PedidoResponseDTO>> listarPedidos(){
        List<Pedido> listaPedidos = pedidoService.findAll();
        List<PedidoResponseDTO> response = listaPedidos.stream()
                                            .map(pedido -> {
                                                UsuarioDTO usuario = usuarioClient.obtenerUsuario(pedido.getCodusuario());
                                                String nombreCompleto = usuario.getNomUsuario() + " " + usuario.getApeUsuario();
                                                String nombreEstado = estadoPedidoService.findById(pedido.getCodEstado())
                                                        .map(EstadoPedido::getNomEstado)
                                                        .orElse("Desconocido");
                                                int cantidadTotal = detallePedidoService.getCantidadTotalByPedido(pedido.getCodpedido());
                                                return PedidoMapper.toDTO(pedido, nombreCompleto, nombreEstado, cantidadTotal);
                                            }).toList();

        return ResponseEntity.ok(response);
    }

    /*@GetMapping("/ObtenerPedido/{codPedido}")
    public ResponseEntity<PedidoDetalleResponseDTO> obtenerPedido(@PathVariable Long codPedido){
        Pedido pedido = pedidoService.obtenerPedido(codPedido).orElseThrow();
        List<ProductoPedidoResponseDTO> productos;

    }*/

}
