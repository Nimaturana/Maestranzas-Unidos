package com.example.PruebaFS.MaestranzaUnido.controller;

import org.springframework.web.bind.annotation.*;

import com.example.PruebaFS.MaestranzaUnido.model.Usuario;
import com.example.PruebaFS.MaestranzaUnido.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository repo;

    public UsuarioController(UsuarioRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return repo.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario datos) {
    return repo.findById(id).map(usuario -> {
        usuario.setNombre(datos.getNombre());
        usuario.setCorreo(datos.getCorreo());
        usuario.setDireccion(datos.getDireccion());
        usuario.setRol(datos.getRol());
        usuario.setTelefono(datos.getTelefono());
        return repo.save(usuario);
    }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
}

}  
