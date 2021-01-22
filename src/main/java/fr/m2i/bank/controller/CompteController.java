package fr.m2i.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.bank.model.Compte;

@RestController
@RequestMapping("comptes")
public class CompteController {

	private List<Compte> comptes = initCompte();

	/**
	 * CREATE Sauvegarde un compte passé dans le body dans la liste de comptes
	 * 
	 * @param le compte à sauvegarder
	 * @return le compte qui a été sauvegardé
	 */
	@PostMapping()
	public Compte save(@RequestBody Compte compte) {
		this.comptes.add(compte);
		return compte;
	}

	/**
	 * READ Récupère tous les comptes présents dans la liste
	 * 
	 * @return
	 */
	@GetMapping()
	public List<Compte> findAll() {
		return this.comptes;
	}

	/**
	 * READ Récupère le compte ayant pour id l'entier passé en paramètre
	 * 
	 * @param id : l'id du compte
	 * @return le compte correspondant
	 */
	@GetMapping("/{id}")
	public Compte findById(@PathVariable int id) {
		return this.comptes.get(id);
	}

	/**
	 * UPDATE Mets à jour le compte concerné
	 * 
	 * @param id     : l'id du compte à mettre à jour
	 * @param compte : le compte modifié
	 * @return le compte après les modifications
	 */
	@PutMapping("/{id}")
	public Compte update(@PathVariable int id, @RequestBody Compte compte) {
		Compte newCompte = this.findById(id);
		newCompte.setNumero(compte.getNumero());
		newCompte.setSolde(compte.getSolde());
		return newCompte;
	}

	/**
	 * DELETE Supprime le compte ayant comme id celui passé en paramètre
	 * 
	 * @param id : l'id du compte à supprimer
	 * @return la liste de comptes après la suppression
	 */
	@DeleteMapping("/{id}")
	public Compte delete(@PathVariable int id) {
		return this.comptes.remove(id);
	}

	public List<Compte> initCompte() {
		List<Compte> comptes = new ArrayList<>();
		comptes.add(new Compte(123456, 300.0));
		comptes.add(new Compte(234567, 400.0));
		comptes.add(new Compte(345678, 500.0));
		comptes.add(new Compte(456789, 600.0));
		comptes.add(new Compte(567890, 700.0));
		return comptes;
	}

}