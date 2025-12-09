// Auteur: Ousmane Diallo, Alphonse Sandwidi

package tp3;

public class ColiAssure extends Coli {
    private double tauxAssurance;

    // Constructeur de la classe ColiAssure
    public ColiAssure(int poids, int valeur, double tauxAssurance) {
        super(poids, valeur);
        this.tauxAssurance = tauxAssurance;
    }

    // Méthode getter pour récupérer le taux d'assurance
    public double getTauxAssurance() {
        return tauxAssurance;
    }

    // Méthode setter pour définir le taux d'assurance
    public void setTauxAssurance(double tauxAssurance) {
        this.tauxAssurance = tauxAssurance;
    }

    // Surcharge de la méthode affiche pour inclure le taux d'assurance
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Taux d'assurance : " + tauxAssurance + " %");
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
