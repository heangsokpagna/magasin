package com.magasin.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailCommande {
	@Id
	private int quantite;
	private double prix;
	
	@ManyToOne
	@JoinColumn(name = "commande")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name = "produit")
	private Produit produit;
}
