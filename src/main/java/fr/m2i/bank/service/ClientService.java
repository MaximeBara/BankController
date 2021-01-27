package fr.m2i.bank.service;

import java.util.ArrayList;
import java.util.List;

import fr.m2i.bank.model.Client;

public class ClientService {

	private List<Client> clients = initClient();

	public ClientService() {
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

	/**
	 * CREATE Sauvegarde un client passé dans le body dans la liste de clients
	 * 
	 * @param le client à sauvegarder
	 * @return le client qui a été sauvegardé
	 */
	public Client save(Client client) {
		this.clients.add(client);
		return client;
	}

	/**
	 * READ Récupère tous les clients présents dans la liste
	 * 
	 * @return
	 */
	public List<Client> findAll() {
		return this.clients;
	}

	/**
	 * READ Récupère le client ayant pour id l'entier passé en paramètre
	 * 
	 * @param id : l'id du client
	 * @return le client correspondant
	 */
	public Client findById(int id) {
		return this.clients.get(id);
	}

	/**
	 * UPDATE Mets à jour le client concerné
	 * 
	 * @param id     : l'id du client à mettre à jour
	 * @param compte : le client modifié
	 * @return le client après les modifications
	 */
	public Client update(int id, Client client) {
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
	public Client delete(int id) {
		return this.clients.remove(id);
	}

}
