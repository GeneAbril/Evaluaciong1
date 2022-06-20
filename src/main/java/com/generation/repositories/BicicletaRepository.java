package com.generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.models.Bicicleta;

@Repository
public interface BicicletaRepository extends JpaRepository<Bicicleta, Long>{

}