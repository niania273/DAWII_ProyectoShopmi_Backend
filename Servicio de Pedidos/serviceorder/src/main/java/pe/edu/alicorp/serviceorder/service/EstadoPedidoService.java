package pe.edu.alicorp.serviceorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.alicorp.serviceorder.model.EstadoPedido;
import pe.edu.alicorp.serviceorder.repository.EstadoPedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoPedidoService {
    @Autowired
    private EstadoPedidoRepository repository;

    public List<EstadoPedido> findAllActive(){
        return repository.findByEstado(true);
    }

    public Optional<EstadoPedido> findById(Long id){
        return repository.findById(id);
    }
}
