package com.espotsmanager.esport_manager.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TorneioDTO {
	private String nome;
	private String formato;
	private LocalDate dataInicio;
	
}
