// Auteur: Ousmane Diallo, Alphonse Sandwidi

package tp3;

public class Coli {
    private int poids;
    private int valeur;

    // Constructeur de la classe Coli
    public Coli(int poids, int valeur) {
        this.poids = poids;
        this.valeur = valeur;
    }

    // Méthode getter pour récupérer le poids
    public int getPoids() {
        return poids;
    }

    // Méthode setter pour définir le poids
    public void setPoids(int poids) {
        this.poids = poids;
    }

    // Méthode getter pour récupérer la valeur
    public int getValeur() {
        return valeur;
    }

    // Méthode setter pour définir la valeur
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    // Méthode pour calculer les frais d'expédition
    public void calculFraisExpedition() {
        int fraisExpedition = 0;

        if (poids <= 5) {
            fraisExpedition = 10;
        } else if (poids <= 25) {
            fraisExpedition = 20;
        } else {
            fraisExpedition = 30;
        }

        System.out.println("Frais d'expédition : " + fraisExpedition + " €");
    }

    // Méthode pour afficher les informations du colis
    public void affiche() {
        System.out.println("Poids : " + poids + " kg");
        System.out.println("Valeur : " + valeur + " €");
        System.out.println("----------------------------------------");
    }
}
/* Execution 
Frais d'expédition : 10 €
Poids : 5 kg
Valeur : 1000 €
----------------------------------------
Frais d'expédition : 20 €
Poids : 25 kg
Valeur : 5000 €
----------------------------------------
Frais d'expédition : 30 €
Poids : 40 kg
Valeur : 10000 €
----------------------------------------
Frais d'expédition : 10 €
Poids : 5 kg
Valeur : 1000 €
----------------------------------------
Taux d'assurance : 5.95 %
----------------------------------------
Frais d'expédition : 20 €
Poids : 25 kg
Valeur : 5000 €
----------------------------------------
Taux d'assurance : 7.95 %
----------------------------------------
Frais d'expédition : 30 €
Poids : 40 kg
Valeur : 10000 €
----------------------------------------
Taux d'assurance : 9.95 %
----------------------------------------
*/
