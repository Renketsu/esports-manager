package com.espotsmanager.esport_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espotsmanager.esport_manager.dto.TimeDTO;
import com.espotsmanager.esport_manager.models.Jogador;
import com.espotsmanager.esport_manager.models.Time;
import com.espotsmanager.esport_manager.repositories.JogadorRepository;
import com.espotsmanager.esport_manager.repositories.TimeRepository;

@Service
public class TimeService {
	
	 private final TimeRepository timeRepository;
	    private final JogadorRepository jogadorRepository;

	    //private static final Logger logger = LoggerFactory.getLogger(TimeService.class);

	    @Autowired
	    public TimeService(TimeRepository timeRepository, JogadorRepository jogadorRepository) {
	        this.timeRepository = timeRepository;
	        this.jogadorRepository = jogadorRepository;
	    }
	
	public Time criarTime(TimeDTO timeDto) {
		Time time =  new Time();
		time.setNome(timeDto.getNome());
		 if (timeDto.getJogadoresIds() != null && !timeDto.getJogadoresIds().isEmpty()) {
	           // logger.info("Time terá jogadores com IDs: {}", timeDTO.getJogadoresIds());
	            List<Jogador> jogadores = jogadorRepository.findAllById(timeDto.getJogadoresIds());
	            time.setJogadores(jogadores);
	        } else {
	           // logger.warn("Nenhum jogador fornecido. Adicionando jogador padrão ao time.");

	            Jogador jogadorPadrao = new Jogador();
	            jogadorPadrao.setNome("Jogador Padrão");
	            jogadorPadrao.setPosicao("Indefinido");
	            jogadorRepository.save(jogadorPadrao); 

	            time.getJogadores().add(jogadorPadrao);
	        }

	        return timeRepository.save(time);
	    }
	
	public Optional<Time> buscarTimePorId(long id){
		return timeRepository.findById(id);
	}
	
		/*
		 * public List<Jogador> buscarJogadoresPorTime(Long timeId) {
		 * logger.info("Buscando jogadores do time com ID: {}", timeId);
		 * 
		 * Time time = timeRepository.findById(timeId) .orElseThrow(() -> new
		 * ResourceNotFoundException("Time não encontrado com ID: " + timeId));
		 * 
		 * return time.getJogadores(); }
		 */

}
