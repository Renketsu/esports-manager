package com.espotsmanager.esport_manager.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TimeDTO {
	@NotBlank(message = "O nome do time é obrigatório")
	private String nome;
	private List<Long> jogadoresIds;
	
}
