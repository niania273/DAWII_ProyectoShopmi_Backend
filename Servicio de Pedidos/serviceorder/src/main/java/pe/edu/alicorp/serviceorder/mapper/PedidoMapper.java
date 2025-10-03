package pe.edu.alicorp.serviceorder.mapper;

import pe.edu.alicorp.commondto.dto.PedidoResponseDTO;
import pe.edu.alicorp.serviceorder.model.Pedido;

public class PedidoMapper {

    public static PedidoResponseDTO toDTO(Pedido pedido, String cliente, String nomEstado, int cantidadTotal){
        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
        pedidoResponseDTO.setCodPedido(pedido.getCodpedido());
        pedidoResponseDTO.setFecPed(pedido.getFecped());
        pedidoResponseDTO.setCliente(cliente);
        pedidoResponseDTO.setPrecioTotal(pedido.getPreciototal());
        pedidoResponseDTO.setNomEstado(nomEstado);
        pedidoResponseDTO.setCantidadTotal(cantidadTotal);
        return pedidoResponseDTO;
    }
}
