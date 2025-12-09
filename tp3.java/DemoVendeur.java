// Auteur: Ousmane Diallo, Alphonse Sandwidi

package tp3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DemoVendeur {
    private ArrayList<Vendeur> vendeurs;

    // Constructeur de la classe DemoVendeur
    public DemoVendeur(String fileName) {
        vendeurs = new ArrayList<>();
        boolean firstLineRead = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!firstLineRead) {
                    firstLineRead = true;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length >= 7) {
                    vendeurs.add(new Vendeur(
                            Integer.parseInt(data[0]),
                            Double.parseDouble(data[6])
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour afficher la liste des vendeurs par ordre croissant de leurs identificateurs
    public void afficherVendeursParId() {
        Collections.sort(vendeurs, Comparator.comparingInt(Vendeur::getId));
        for (Vendeur vendeur : vendeurs) {
            System.out.println(vendeur.getId() + " " + vendeur.getMontantVentes());
        }
    }

    // Méthode pour afficher la liste des vendeurs par ordre croissant de leurs montants annuels de ventes
    public void afficherVendeursParVentes() {
        Collections.sort(vendeurs, Comparator.comparingDouble(Vendeur::getMontantVentes));
        for (Vendeur vendeur : vendeurs) {
            System.out.println(vendeur.getId() + " " + vendeur.getMontantVentes());
        }
    }

    // Méthode pour afficher les informations du vendeur avec le montant annuel de ventes le plus élevé
    public void afficherInfoVendeurAvecPlusDeVentes() {
        Collections.sort(vendeurs, Comparator.comparingDouble(Vendeur::getMontantVentes).reversed());
        for (Vendeur vendeur : vendeurs) {
            System.out.println(vendeur.getId() + " " + vendeur.getMontantVentes());
        }
    }

    // Méthode pour afficher les informations du vendeur avec le montant annuel de ventes le moins élevé
    public void afficherInfoVendeurAvecMoinsDeVentes() {
        Collections.sort(vendeurs, Comparator.comparingDouble(Vendeur::getMontantVentes));
        for (Vendeur vendeur : vendeurs) {
            System.out.println(vendeur.getId() + " " + vendeur.getMontantVentes());
        }
    }

    // Méthode principale
    public static void main(String[] args) {
        DemoVendeur demoVendeur = new DemoVendeur("src/tp3/vendeurs.txt");
        int choix;

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("1. Afficher la liste des vendeurs par ordre croissant de leurs identificateurs");
                System.out.println("2. Afficher la liste des vendeurs par ordre croissant de leurs montants annuels de ventes");
                System.out.println("3. Afficher les informations du vendeur avec le montant annuel de ventes le plus élevé");
                System.out.println("4. Afficher les informations du vendeur avec le montant annuel de ventes le moins élevé");
                System.out.println("0. Quitter");
                System.out.print("Entrez votre choix : ");

                try {
                    choix = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer un nombre valide.");
                    choix = -1;
                }

                switch (choix) {
                    case 1:
                        demoVendeur.afficherVendeursParId();
                        break;
                    case 2:
                        demoVendeur.afficherVendeursParVentes();
                        break;
                    case 3:
                        demoVendeur.afficherInfoVendeurAvecPlusDeVentes();
                        break;
                    case 4:
                        demoVendeur.afficherInfoVendeurAvecMoinsDeVentes();
                        break;
                    case 0:
                        System.out.println("Fermeture...");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }

                if (demoVendeur.getVendeurs().isEmpty()) {
                    System.out.println("La liste des vendeurs est vide. Veuillez vérifier le fichier de données.");
                }

            } while (choix != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthode getter pour récupérer la liste des vendeurs
    public ArrayList<Vendeur> getVendeurs() {
        return vendeurs;
    }
}
/*Execution 
1. Afficher la liste des vendeurs par ordre croissant de leurs identificateurs
2. Afficher la liste des vendeurs par ordre croissant de leurs montants annuels de ventes
3. Afficher les informations du vendeur avec le montant annuel de ventes le plus élevé
4. Afficher les informations du vendeur avec le montant annuel de ventes le moins élevé
0. Quitter
Entrez votre choix : 1
100103 180000.0
100218 150000.0
100257 100000.0
100575 180000.0
100587 70000.0
100650 140000.0
100659 80000.0
100706 200000.0
100707 120000.0
100711 100000.0
100712 80000.0
100820 100000.0
100859 220000.0
100879 60000.0
100881 80000.0
100883 160000.0
100910 120000.0
100914 120000.0
100916 180000.0
100960 100000.0
100987 40000.0
518044 60000.0
530060 70000.0
1. Afficher la liste des vendeurs par ordre croissant de leurs identificateurs
2. Afficher la liste des vendeurs par*/
