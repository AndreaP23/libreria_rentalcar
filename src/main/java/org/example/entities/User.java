package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "\"user\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = 149790289743555628L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name="nome")
	private String nome;

	@Column(name="cognome")
	private String cognome;

	@Column(name="email", unique = true)
	private String email;

	@Column(name = "phone")
	private String telefono;

	@Column(name="password")
	private String password;

	@Column(name = "data_nascita")
	private LocalDate dataNascita;

	@Column(name = "ruolo_id")
	private Integer ruolo;

	@OneToMany(mappedBy= "user", fetch = FetchType.LAZY)
	private List<Prenotazione> prenotazioni;

	public List<String> getRuoli() {
		if (ruolo == 1) {
			return List.of("ROLE_1"); // SuperUser
		} else if (ruolo == 2) {
			return List.of("ROLE_2"); // Customer
		}
		return List.of();
	}
}
