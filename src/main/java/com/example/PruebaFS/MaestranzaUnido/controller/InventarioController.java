package com.example.PruebaFS.MaestranzaUnido.controller;

import com.example.PruebaFS.MaestranzaUnido.model.Inventario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private static List<Inventario> inventario = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong();

    @GetMapping
    public List<Inventario> listar() {
        return inventario;
    }

    @PostMapping
    public Inventario agregar(@RequestBody Inventario producto) {
        producto.setId(idCounter.incrementAndGet());
        if (producto.getCantidad() <= 0) {
            producto.setEstado("Agotado");
        } else {
            producto.setEstado("Disponible");
        }
        inventario.add(producto);
        return producto;
    }

    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Long id, @RequestBody Inventario actualizado) {
        Optional<Inventario> productoOpt = inventario.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (productoOpt.isPresent()) {
            Inventario producto = productoOpt.get();
            producto.setNombre(actualizado.getNombre());
            producto.setCategoria(actualizado.getCategoria());
            producto.setCantidad(actualizado.getCantidad());
            if (actualizado.getCantidad() <= 0) {
                producto.setEstado("Agotado");
            } else {
                producto.setEstado("Disponible");
            }
            return producto;
        } else {
            actualizado.setId(id);
            inventario.add(actualizado);
            return actualizado;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        inventario.removeIf(p -> p.getId().equals(id));
    }
}
