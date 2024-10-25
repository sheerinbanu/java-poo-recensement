package fr.diginamic.recensement.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Departement;
import fr.diginamic.recensement.entites.ExceptionFonctionnelle;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws ExceptionFonctionnelle {

        String choix = null;
        String saisieMin = null;
        String saisieMax = null;
        try {
            System.out.println("Quel est le code du département recherché ? ");
            choix = scanner.nextLine();

            if (choix== null){
                throw new ExceptionFonctionnelle("Le code du département ne peut pas être nul ou vide");
            }

            System.out.println("Choississez une population minimum (en milliers d'habitants): ");
            saisieMin = scanner.nextLine();


            System.out.println("Choississez une population maximum (en milliers d'habitants): ");
            saisieMax = scanner.nextLine();
        } catch (InputMismatchException e) {
			throw new ExceptionFonctionnelle("Afficher uniquement un chiffre !");
        }


        int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;

		if(min<0 || max<0){
			throw new ExceptionFonctionnelle("Le minimum ou maximum  habitant ne peut pas être négatif");
		}
		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}

	}


}
