package com.magasin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.magasin.demo.repository.ProduitRepository;

@Controller
public class AccueilController {
	
	@Autowired
	ProduitRepository produitRepository;
	
	@GetMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("articles", produitRepository.findAll());
		return "index";
	}
}
