package com.espotsmanager.esport_manager.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JogadorDTO {
	@NotBlank(message = "O nome do jogador é obrigatório")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
	private String nome;
	private String posicao;
	private List<Long> timesIds;
	

}
