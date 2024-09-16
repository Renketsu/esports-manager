package com.espotsmanager.esport_manager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espotsmanager.esport_manager.models.Jogador;
@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
	
	 List<Jogador> findByNomeContainingIgnoreCase(String nome);
	
}