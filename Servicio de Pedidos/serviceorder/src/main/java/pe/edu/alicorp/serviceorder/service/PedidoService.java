package pe.edu.alicorp.serviceorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.alicorp.serviceorder.model.Pedido;
import pe.edu.alicorp.serviceorder.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPedido(Long codPedido){
        return pedidoRepository.findById(codPedido);
    }
}
