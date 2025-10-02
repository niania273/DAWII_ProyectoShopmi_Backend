package pe.edu.alicorp.servicecatalog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.alicorp.servicecatalog.entity.Categoria;
import pe.edu.alicorp.servicecatalog.repository.CategoriaRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CategoriaService {

    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    public List<Categoria> listar() {
        return repo.findAll();
    }

    public Categoria guardar(Categoria c) {
        return repo.save(c);
    }

    public Categoria buscarPorId(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new NoSuchElementException("Categoria no encontrada: " + id));
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Categoria no encontrada: " + id);
        }
        repo.deleteById(id);
    }
}
