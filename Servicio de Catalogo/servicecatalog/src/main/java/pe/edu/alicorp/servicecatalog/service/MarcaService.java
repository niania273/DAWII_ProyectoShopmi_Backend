package pe.edu.alicorp.servicecatalog.service;

import org.springframework.stereotype.Service;
import pe.edu.alicorp.servicecatalog.entity.Marca;
import pe.edu.alicorp.servicecatalog.repository.MarcaRepository;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository repo;

    public MarcaService(MarcaRepository repo) {
        this.repo = repo;
    }

    public List<Marca> listar() {
        return repo.findAll();
    }

    public Marca guardar(Marca m) {
        return repo.save(m);
    }

    public Marca buscarPorId(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
