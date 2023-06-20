package com.magasin.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String prenom;
	private String nom;
	private String login;
	private String mdp;
	private String sexe;
	private int statut;
	private String email;
	private LocalDateTime dateInscription = LocalDateTime.now();
	
	@OneToMany(mappedBy = "user")
	private List<Commande> commandes = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Panier> panier = new ArrayList<>();
	
	

}
