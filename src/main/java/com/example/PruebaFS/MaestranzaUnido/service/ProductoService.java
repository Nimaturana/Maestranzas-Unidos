package com.example.PruebaFS.MaestranzaUnido.service;

import org.springframework.stereotype.Service;

import com.example.PruebaFS.MaestranzaUnido.model.Producto;
import com.example.PruebaFS.MaestranzaUnido.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Producto guardar(Producto producto) {
        return repo.save(producto);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return repo.findById(id);
    }
}
