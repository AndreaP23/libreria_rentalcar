package org.example.dao;

import org.example.entities.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo,Long> {

	

}
