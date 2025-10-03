package pe.edu.alicorp.commondto.dto;

import java.time.LocalDateTime;

public record ProductoDTO(
        long codproducto,
        long codcategoria,
        String imgproducto,
        String nomproducto,
        String descripcion,
        double preuni,
        int stock,
        boolean estproducto,
        LocalDateTime fechacreacion,
        LocalDateTime fechaactualiza
) {}