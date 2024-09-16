package com.espotsmanager.esport_manager.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Torneio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String nome;
	private String formato;
	private LocalDate dataInicio;
	
	@OneToMany(mappedBy = "torneio")
	private List<Partida> partidas;
}
