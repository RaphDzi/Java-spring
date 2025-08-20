package com.example.exercice3.controller;

import com.example.exercice3.model.Produit;
import com.example.exercice3.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/produit")
public class ProduitController {

    private ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public Map<Integer, Produit> getProduit() {return produitService.getProduitMap();}

    @PostMapping
    public void addProduit(@RequestBody Produit produit) { produitService.addProduit(produit);}
}
