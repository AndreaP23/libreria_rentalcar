package org.example.dao;

import org.example.entities.Prenotazione;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long>, JpaSpecificationExecutor<Prenotazione> {

	@Query("SELECT p FROM Prenotazione p WHERE p.dataPrenotazione = CURRENT_DATE ORDER BY p.prenotazioneId ASC")
	Page<Prenotazione> findAllByToday(Pageable var1);


	boolean existsByVeicolo_VeicoloId(Long veicoloId);

}

