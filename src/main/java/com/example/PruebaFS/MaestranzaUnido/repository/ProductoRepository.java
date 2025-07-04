package com.example.PruebaFS.MaestranzaUnido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PruebaFS.MaestranzaUnido.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
