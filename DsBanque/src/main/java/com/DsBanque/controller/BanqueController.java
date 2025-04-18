 package com.DsBanque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DsBanque.entitie.Compte;
import static com.DsBanque.DsBanqueApplication.comptes;

@Controller
public class BanqueController {

  @RequestMapping("comptes")
    public String listeComptes(Model model) {
        model.addAttribute("comptes",comptes);
        return "listeComptes";
    }

    @PostMapping("/comptes/add")
    public String ajouter(@RequestParam("titulaire") String titulaire,
    		@RequestParam("solde")double solde)
    {
    	int id = comptes.size()+1;
    	id++;
    	Compte c = new Compte (titulaire,solde);
    	c.setId(id);
    	comptes.add(c);
    	return "redirect:/comptes";
    }

    @GetMapping("/ajouter")
    public String add() {

        return "ajouterCompte";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable int id, Model model) {
        for (Compte c : comptes) {
            if (c.getId() == id) {
                model.addAttribute("c", c);
              
            }
        }
        return "detailsCompte";
    }

    @PostMapping("/depot/{id}")
    public String depot(@PathVariable("id") int id, @RequestParam("montant") double montant) {
        for (Compte c : comptes) {
            if (c.getId() == id && montant > 0) {
                c.setSolde(c.getSolde() + montant);
                break;
            }
        }
        return "redirect:/details/"+id ;
    }
    @PostMapping("/retrait/{id}")
    public String retrait(@PathVariable int id, @RequestParam("montant") double montant) {
        for (Compte c : comptes) {
            if (c.getId() == id && montant > 0 && c.getSolde() >= montant) {
                c.setSolde(c.getSolde() - montant);
                break;
            }
        }
        return "redirect:/details/"+id;
    }
    @Controller
    public class AuthController {

    	@GetMapping("/login")
    	public String login() {
    		return "login";}
    	}
}
