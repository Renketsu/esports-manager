package com.espotsmanager.esport_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espotsmanager.esport_manager.models.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
	
}