package com.example.edutech.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edutech.model.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {

}
