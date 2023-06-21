package com.magasin.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime dateCmd = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "user")
	private Personne user;
	
	@OneToMany(mappedBy = "commande")
	private List<DetailCommande> commande = new ArrayList<>();
	
	@Override
	public String toString() {
		return "Commande: id: " + id +" date: " + dateCmd;  
	}
}
