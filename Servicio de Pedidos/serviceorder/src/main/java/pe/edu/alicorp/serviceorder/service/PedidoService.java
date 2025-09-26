package pe.edu.alicorp.serviceorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.alicorp.serviceorder.model.Pedido;
import pe.edu.alicorp.serviceorder.repository.PedidoRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Optional<Pedido> findById(Long codPedido){
        return pedidoRepository.findById(codPedido);
    }

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido create(Pedido object){
        return pedidoRepository.save(object);
    }

    public Pedido update(Long codPedido, Long codEstado){
        Pedido exist = pedidoRepository.findById(codEstado).orElseThrow(() -> new NoSuchElementException("Pedido no encontrado"));
        exist.setCodestado(codEstado);
        return pedidoRepository.save(exist);
    }

    public boolean delete(Long codPedido, Long codEstado){
        Pedido exist = pedidoRepository.findById(codEstado).orElseThrow(() -> new NoSuchElementException("Pedido no encontrado"));
        exist.setEstped(false);
        return (pedidoRepository.save(exist) != null);
    }
}
