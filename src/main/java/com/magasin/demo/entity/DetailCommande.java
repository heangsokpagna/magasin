package com.magasin.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailCommande {
	private Commande commande;
	private Produit produit;
	private int quantite;
	private double prix;
}
