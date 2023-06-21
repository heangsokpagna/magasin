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
public class ListePanier {
	@Id
	private int quantite;
	private double prix;
	
	@ManyToOne
	@JoinColumn(name = "panier")
	private Panier panier;
	
	
	@ManyToOne
	@JoinColumn(name = "produit")
	private Produit produit;
}
