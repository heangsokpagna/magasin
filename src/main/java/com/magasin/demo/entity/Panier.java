package com.magasin.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Panier {
	private Integer id;
	private LocalDateTime datePanier = LocalDateTime.now();
	private Personne client;
}
