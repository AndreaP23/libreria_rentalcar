package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "VEICOLO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veicolo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "veicolo_id")
    private Long veicoloId;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modello")
    private String modello;

    @Column(name = "anno")
    private int anno;

    @Column(name = "targa", unique = true)  
    private String targa;

    @Column(name = "disponibilita")
    private int disponibilita;  
  

    @OneToMany(mappedBy = "veicolo")
    private List<Prenotazione> prenotazioni;
    
}
