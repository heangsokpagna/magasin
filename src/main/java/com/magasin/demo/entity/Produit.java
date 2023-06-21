package com.magasin.demo.entity;

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

public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	private double prix;
	private String description;
	private String image;
	private int quantite;
	

	@OneToMany(mappedBy = "produit")
	private List<ListePanier> panier = new ArrayList<>();
	
	@OneToMany(mappedBy = "produit")
	private List<DetailCommande> produit = new ArrayList<>();
	
	public String getImageChemin() {
		return "/images/articles/" + image;
	}
}
