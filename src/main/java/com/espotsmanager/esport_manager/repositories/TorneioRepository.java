package com.espotsmanager.esport_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espotsmanager.esport_manager.models.Torneio;
@Repository
public interface TorneioRepository extends JpaRepository<Torneio, Long> {
	
}
