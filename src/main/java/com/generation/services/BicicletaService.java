package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.generation.models.Bicicleta;
import com.generation.repositories.BicicletaRepository;

public class BicicletaService {
	@Autowired
	BicicletaRepository bicicletaRepository;

	//guardar bicicleta
	public void guardarBicicleta(@Valid Bicicleta bicicleta) {
		bicicletaRepository.save(bicicleta);
		
	}
	//obtener una lista de bicicletas
	public List<Bicicleta> findAll() {
		
		return bicicletaRepository.findAll();
	}
	public Bicicleta buscarId(Long id) {
		return bicicletaRepository.findById(id).get();//.get() especifica el tipo de datos que necesitamos
	}
}