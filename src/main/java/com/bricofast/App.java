package com.bricofast;

import com.bricofast.exception.LocationException;
import com.bricofast.model.Catalogue;
import com.bricofast.model.Outil;
import com.bricofast.service.LocationService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogue catalogue = new Catalogue();
        LocationService service = new LocationService(catalogue);
        boolean quitter = false;

        while (!quitter) {
            System.out.println("=====================================");
            System.out.println("   Mini systeme de location d'outils ");
            System.out.println("=====================================");
            System.out.println("1. Lister les outils");
            System.out.println("2. Louer un outil");
            System.out.println("3. Retourner un outil");
            System.out.println("4. Quitter");
            System.out.print("Votre choice : ");

            String line = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Choix invalide.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.println("\n------ Liste des outils ------");
                        for (Outil outil : catalogue.getOutils()) {
                            System.out.println(outil.getId() + " - " + outil.getNom() + "- Disponible: "+ outil.isDisponible());
                        }
                        System.out.println("------------------------------\n");
                        break;
                    case 2:
                        System.out.println("Entrez l'index de l'outil que vous souhaitez louer: ");
                        String indexToStock = scanner.nextLine();
                        int indexInt = Integer.parseInt(indexToStock);


                        System.out.println("Entrez le nombre de jour de location: ");
                        String nbrDeJour = scanner.nextLine();
                        int nbrDeJourInt = Integer.parseInt(nbrDeJour);

                        double totalPrice = service.rentOutil(indexInt, nbrDeJourInt);
                        Outil rentedOutil = catalogue.getOutilById(indexInt);

                        System.out.println("\n---------- Recapitulatif ----------");
                        System.out.println("Outil : " + rentedOutil.getNom());
                        System.out.println("Duree : " + nbrDeJourInt + " jour(s)");
                        System.out.println("Prix par jour : " + rentedOutil.getPrixParJour()  + " €");
                        System.out.println("Prix total : " + totalPrice + " €");
                        System.out.println("-----------------------------------\n");
                        break;
                    case 3:
                        System.out.println("Entrez l'index de l'outil que vous souhaitez retourner: ");
                        String indexToReturn = scanner.nextLine();
                        int indInt = Integer.parseInt(indexToReturn);

                        service.returnOutil(indInt);

                        Outil returnedOutil = catalogue.getOutilById(indInt);

                        System.out.println("Outil " + returnedOutil.getNom() + " retourne. Il est maintenant disponible.\n");
                        break;
                    case 4:
                        quitter = true;
                        System.out.println("Vous quittez le système de location");
                        break;
                    default:
                        System.out.println("Choix invalide");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Valeur numerique invalide");
            } catch (LocationException e) {
                System.out.println(e.getMessage() + "\n");
            }


        }
        scanner.close();
    }
}
