package com.example.PruebaFS.MaestranzaUnido.service;

import org.springframework.stereotype.Service;

import com.example.PruebaFS.MaestranzaUnido.model.Pedido;
import com.example.PruebaFS.MaestranzaUnido.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repo;

    public PedidoService(PedidoRepository repo) {
        this.repo = repo;
    }

    public List<Pedido> listar() {
        return repo.findAll();
    }

    public Pedido guardar(Pedido pedido) {
        return repo.save(pedido);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return repo.findById(id);
    }
}
