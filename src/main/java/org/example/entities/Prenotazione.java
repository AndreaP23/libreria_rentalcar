package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name="PRENOTAZIONE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prenotazione implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prenotazione_id")
    private Long prenotazioneId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //ManyToOne di default è Eager
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veicolo_id")
    private Veicolo veicolo;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;
    
    @Column(name = "note")
    private String note;
}

