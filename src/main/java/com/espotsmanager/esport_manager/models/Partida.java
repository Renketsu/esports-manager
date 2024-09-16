package com.espotsmanager.esport_manager.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Partida {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataPartida;
	
	@ManyToOne
	private Time timeA;
	@ManyToOne
	private Time timeB;
	
	private Integer scoreTimeA;
	private Integer scoreTimeB;
	
	@ManyToOne
	private Torneio torneio;

}
