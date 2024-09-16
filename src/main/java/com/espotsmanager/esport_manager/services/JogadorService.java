package com.espotsmanager.esport_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espotsmanager.esport_manager.dto.JogadorDTO;
import com.espotsmanager.esport_manager.models.Jogador;
import com.espotsmanager.esport_manager.models.Time;
import com.espotsmanager.esport_manager.repositories.JogadorRepository;
import com.espotsmanager.esport_manager.repositories.TimeRepository;

@Service
public class JogadorService {
	
	private final JogadorRepository jogadorRepository;
	private final TimeRepository timeRepository;
	
	  @Autowired
	    public JogadorService(JogadorRepository jogadorRepository, TimeRepository timeRepository) {
	        this.jogadorRepository = jogadorRepository;
	        this.timeRepository = timeRepository;
	    }
	
	public Jogador criarJogador(JogadorDTO jogadorDTO) {
		Jogador jogador = new Jogador();
		jogador.setNome(jogadorDTO.getNome());
		jogador.setPosicao(jogadorDTO.getPosicao());
		 if (jogadorDTO.getTimesIds() != null && !jogadorDTO.getTimesIds().isEmpty()) {
	            List<Time> times = timeRepository.findAllById(jogadorDTO.getTimesIds());
	            jogador.setTimes(times);
	        }
		return jogadorRepository.save(jogador);
	}
	
	public Optional<Jogador> buscarJogadorPorId(long id){
		return jogadorRepository.findById(id);
	}
	
	public List<Jogador> buscarPorNome(String nome) {
        return jogadorRepository.findByNomeContainingIgnoreCase(nome);
    }
	
	/*
	 * public List<Time> buscarTimesPorJogador(Long jogadorId) { Jogador jogador =
	 * jogadorRepository.findById(jogadorId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Jogador não encontrado com ID: " + jogadorId));
	 * 
	 * return jogador.getTimes(); }
	 */

}
