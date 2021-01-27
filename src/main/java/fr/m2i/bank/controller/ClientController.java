package fr.m2i.bank.controller;

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
import fr.m2i.bank.service.ClientService;

@RestController
@RequestMapping("clients")
public class ClientController {
	
	private ClientService clientService = new ClientService();

	@PostMapping()
	public Client createClient(@RequestBody Client client) {
		return this.clientService.save(client);
	}
	
	@GetMapping()
	public List<Client> getAllClients() {
		return this.clientService.findAll();
	}
	
	@GetMapping("/{id}")
	public Client getClient(@PathVariable int id) {
		return this.clientService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Client updateClient(@PathVariable int id, @RequestBody Client client) {
		return this.clientService.update(id, client);
	}
	
	@DeleteMapping("/{id}")
	public Client deleteClient(@PathVariable int id) {
		return this.clientService.delete(id);
	}
	
}