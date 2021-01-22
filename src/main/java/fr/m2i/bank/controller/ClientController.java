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

import fr.m2i.bank.model.Client;

@RestController
@RequestMapping("clients")
public class ClientController {

	private List<Client> clients = initClient();

	/**
	 * CREATE Sauvegarde un client passé dans le body dans la liste de clients
	 * 
	 * @param le client à sauvegarder
	 * @return le client qui a été sauvegardé
	 */
	@PostMapping()
	public Client save(@RequestBody Client client) {
		this.clients.add(client);
		return client;
	}

	/**
	 * READ Récupère tous les clients présents dans la liste
	 * 
	 * @return
	 */
	@GetMapping()
	public List<Client> findAll() {
		return this.clients;
	}

	/**
	 * READ Récupère le client ayant pour id l'entier passé en paramètre
	 * 
	 * @param id : l'id du client
	 * @return le client correspondant
	 */
	@GetMapping("/{id}")
	public Client findById(@PathVariable int id) {
		return this.clients.get(id);
	}

	/**
	 * UPDATE Mets à jour le client concerné
	 * 
	 * @param id     : l'id du client à mettre à jour
	 * @param compte : le client modifié
	 * @return le client après les modifications
	 */
	@PutMapping("/{id}")
	public Client update(@PathVariable int id, @RequestBody Client client) {
		Client newClient = this.findById(id);
		newClient.setNom(client.getNom());
		newClient.setPrenom(client.getPrenom());
		newClient.setAge(client.getAge());
		return newClient;
	}

	/**
	 * DELETE Supprime le client ayant comme id celui passé en paramètre
	 * 
	 * @param id : l'id du client à supprimer
	 * @return la liste de client après la suppression
	 */
	@DeleteMapping("/{id}")
	public Client delete(@PathVariable int id) {
		return this.clients.remove(id);
	}

	public List<Client> initClient() {
		List<Client> clients = new ArrayList<Client>();
		clients.add(new Client(123456, "Di", "Mension", 25));
		clients.add(new Client(234567, "Culture", "Shock", 22));
		clients.add(new Client(345678, "Wil", "Kinson", 23));
		clients.add(new Client(456789, "BlackSun", "Empire", 30));
		clients.add(new Client(567890, "London", "Elektricity", 32));
		return clients;
	}

}