package com.example.sigca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sigca.entity.Tipo;
@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {

}
