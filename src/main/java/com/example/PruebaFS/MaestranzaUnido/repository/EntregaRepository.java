package com.example.PruebaFS.MaestranzaUnido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PruebaFS.MaestranzaUnido.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
