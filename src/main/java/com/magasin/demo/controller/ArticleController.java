package com.magasin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.magasin.demo.MyServices;
import com.magasin.demo.entity.Produit;
import com.magasin.demo.repository.ProduitRepository;



@Controller
public class ArticleController {
	
	@Autowired
	ProduitRepository produitRepository;

	@GetMapping("/article/articles")
	public String articles(ModelMap model) {
		model.addAttribute("articles", produitRepository.findAll());
		return "articles/index";
	}

	@GetMapping("/article/new")
	public String newArticle(ModelMap model) {
		model.addAttribute("article", new Produit());
		return "articles/new";
	}

	@PostMapping("/article/add")
	public String addArticle(
			@ModelAttribute("article") Produit produit, 
			@RequestParam("logo") MultipartFile multipartFile
			) {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		
		if( !fileName.isEmpty() ) {
			String uploadDir = "src\\main\\resources\\static\\images\\articles\\";
			
			MyServices.uploadFile(fileName, uploadDir, multipartFile);

			produit.setImage(fileName);
			
			produitRepository.save(produit);
			
			
		return "redirect:/article/articles";
			
		}
		
			return "articles/index";
		 
	}
	
	@GetMapping("/article/update/{id}")
	public String update( ModelMap model, @PathVariable int id) {

		Produit article = produitRepository.findById(id).get();
		
		System.out.println("art " + article);
		model.addAttribute("article", article);
		
		return "articles/new";
	}
	
	@GetMapping("/article/delete/{id}")
	public String delete(RedirectAttributes redirectAttributes, Produit article) {
		produitRepository.delete(article);
		System.out.println(article);
		redirectAttributes.addFlashAttribute("success", "article supprimé avec succès ! ");
		
		return "redirect:/article/articles";
	}

}







