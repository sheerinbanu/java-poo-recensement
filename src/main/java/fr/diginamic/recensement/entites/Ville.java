package fr.diginamic.recensement.entites;

import fr.diginamic.recensement.annotations.ToString;

import java.lang.reflect.Field;

/**
 * Représente une ville
 * 
 * @author DIGINAMIC
 *
 */
public class Ville implements EnsemblePop {

	/** codeRegion : code de la région */
	private String codeRegion;
	/** nomRegion : nom de la région */
	@ToString(uppercase = true)
	private String nomRegion;
	/** codeDepartement : code du département */
	private String codeDepartement;
	/** code INSEE de la ville */
	@ToString
	private String codeVille;
	/** nom de la ville */
	@ToString (uppercase = true)
	private String nom;
	/** population totale */
	@ToString
	private int population;

	/**
	 * Constructeur
	 * 
	 * @param codeRegion code de la région
	 * @param nomRegion nom de la région
	 * @param codeDepartement code du département
	 * @param codeVille code INSEE de la ville
	 * @param nom nom de la ville
	 * @param population population totale
	 */
	public Ville(String codeRegion, String nomRegion, String codeDepartement, String codeVille, String nom,
			int population) {
		super();
		this.codeRegion = codeRegion;
		this.nomRegion = nomRegion;
		this.codeDepartement = codeDepartement;
		this.codeVille = codeVille;
		this.nom = nom;
		this.population = population;
	}

//	@Override
//	public String toString() {
//		return "Département n°" + codeDepartement + " - Ville : " + nom + " - " + population + " hab.";
//	}

	/**
	 * Getter
	 * 
	 * @return the codeRegion
	 */
	public String getCodeRegion() {
		return codeRegion;
	}

	/**
	 * Setter
	 * 
	 * @param codeRegion the codeRegion to set
	 */
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}

	/**
	 * Getter
	 * 
	 * @return the nomRegion
	 */
	public String getNomRegion() {
		return nomRegion;
	}

	/**
	 * Setter
	 * 
	 * @param nomRegion the nomRegion to set
	 */
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	/**
	 * Getter
	 * 
	 * @return the codeDepartement
	 */
	public String getCodeDepartement() {
		return codeDepartement;
	}

	/**
	 * Setter
	 * 
	 * @param codeDepartement the codeDepartement to set
	 */
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	/**
	 * Getter
	 * 
	 * @return the codeVille
	 */
	public String getCodeVille() {
		return codeVille;
	}

	/**
	 * Setter
	 * 
	 * @param codeVille the codeVille to set
	 */
	public void setCodeVille(String codeVille) {
		this.codeVille = codeVille;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the population
	 */
	@Override
	public int getPopulation() {
		return population;
	}

	/**
	 * Setter
	 * 
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Field[] fields = this.getClass().getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(ToString.class)) {
				field.setAccessible(true);
				try {
					String fieldValue = String.valueOf(field.get(this));
					if (field.getAnnotation(ToString.class).uppercase()) {
						fieldValue = fieldValue.toUpperCase();
					}
					result.append(field.getName())
							.append(": ")
							.append(fieldValue)
							.append("\n");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return result.toString();
	}
}
