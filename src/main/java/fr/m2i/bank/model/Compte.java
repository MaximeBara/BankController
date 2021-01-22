package fr.m2i.bank.model;

import fr.m2i.bank.exception.BanqueException;

public class Compte {

	private double solde;
	private int numero;

	public Compte() {
	}

	public Compte(int unNumero, double unSoldeInitial) {
		this.numero = unNumero;
		this.solde = unSoldeInitial;
	}

	public void ajouter(double unMontant) {
		this.solde += unMontant;
	}

	public void retirer(double unMontant) throws BanqueException {
		this.solde -= unMontant;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	private void setSolde(double solde) {
		this.solde = solde;
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
	private void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		long temp;
		temp = Double.doubleToLongBits(solde);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Compte other = (Compte) obj;
		if (numero != other.numero)
			return false;
		if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compte [solde=" + solde + ", numero=" + numero + "]";
	}

}