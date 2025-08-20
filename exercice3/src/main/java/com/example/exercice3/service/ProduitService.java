package com.example.exercice3.service;

import com.example.exercice3.model.Produit;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProduitService {

    private HttpSession session;
    private int cpt = 1;

    public ProduitService(HttpSession session) {
        this.session = session;
    }

    public void addProduit(Produit p) {
        Map<Integer, Produit> map = (Map<Integer, Produit>) session.getAttribute("produitMap");
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(cpt++, p);
        session.setAttribute("produitMap", map);
    }

    public Map<Integer, Produit> getProduitMap() {return (Map<Integer, Produit>) session.getAttribute("produitMap");}
}
