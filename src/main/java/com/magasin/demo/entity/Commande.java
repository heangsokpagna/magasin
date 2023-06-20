package com.magasin.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
	private Integer id;
	private LocalDateTime dateCmd = LocalDateTime.now();
	private Personne client;
}
