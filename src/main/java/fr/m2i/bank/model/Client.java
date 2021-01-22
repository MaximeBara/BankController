package fr.m2i.bank.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.m2i.bank.exception.BanqueException;

public class Client {

	public static final int MAX_COMPTES = 5;
	private String nom;
	private String prenom;
	private int age;
	private int numero;
	private int nbComptes = 0;
	private List<Compte> comptes = new ArrayList<Compte>(MAX_COMPTES);

	public Client() {
	}

	public Client(int unNumero, String unNom, String unPrenom, int unAge) {
		this.numero = unNumero;
		this.nom = unNom;
		this.prenom = unPrenom;
		this.age = unAge;
	}

	public void ajouterCompte(Compte unCompte) throws BanqueException {
		if (nbComptes < MAX_COMPTES) {
			this.comptes.add(unCompte);
			nbComptes++;
		} else
			throw new BanqueException("Impossible d'ouvrir un compte supplémentaire.");
	}

	public Compte getCompte(int numeroCompte) {
		for (Compte compte : comptes) {
			if (compte != null && compte.getNumero() == numeroCompte) {
				return compte;
			}
		}
		System.out.println("Le compte avec le numéro " + numeroCompte + " n'existe pas dans notre base de données.");
		return null;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the comptes
	 */
	public Compte[] getComptes() {
		return (Compte[]) this.comptes.toArray();
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(Compte[] comptes) {
		this.comptes = Arrays.asList(comptes);
	}

	public int getNbComptes() {
		return nbComptes;
	}

	public void setNbComptes(int nbComptes) {
		this.nbComptes = nbComptes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numero;
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (age != other.age)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numero != other.numero)
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", numero=" + numero + "]";
	}

}