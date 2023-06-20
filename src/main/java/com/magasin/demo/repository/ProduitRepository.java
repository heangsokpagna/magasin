package com.magasin.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magasin.demo.entity.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Integer>{

}

