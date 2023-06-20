package com.magasin.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListePanier {
	private Panier panier;
	private Produit produit;
	private int quantite;
}
