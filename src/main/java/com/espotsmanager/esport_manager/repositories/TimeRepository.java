package com.espotsmanager.esport_manager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espotsmanager.esport_manager.models.Time;
@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
	
	List<Time> findAllById(List<Long> ids);
	
}