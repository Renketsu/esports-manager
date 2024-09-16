package com.espotsmanager.esport_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espotsmanager.esport_manager.dto.TorneioDTO;
import com.espotsmanager.esport_manager.models.Torneio;
import com.espotsmanager.esport_manager.repositories.TorneioRepository;

@Service
public class TorneioService {
	
	private final TorneioRepository torneioRepository;
	
	@Autowired
	public TorneioService(TorneioRepository toorneioRepository) {
		this.torneioRepository = toorneioRepository;
	}
	
	public Torneio criarTorneio(TorneioDTO torneioDto) {
		Torneio torneio = new Torneio();
		torneio.setNome(torneioDto.getNome());
		torneio.setFormato(torneioDto.getFormato());
		torneio.setDataInicio(torneioDto.getDataInicio());
		return torneioRepository.save(torneio);
	}
	
	public List<Torneio> listarTorneios(){
		return torneioRepository.findAll();
	}
	
	public Optional<Torneio> buscarTorneioPorId(Long id){
		return torneioRepository.findById(id);
	}

}
