// Auteur: Ousmane Diallo, Alphonse Sandwidi

package tp3;

public class TestColi {
	public static void main(String[] args) {
        // Création d'objets Coli avec différents paramètres
        Coli coli1 = new Coli(5, 1000);
        coli1.calculFraisExpedition(); // Calcul des frais d'expédition pour coli1
        coli1.affiche(); // Affichage des détails de coli1

        Coli coli2 = new Coli(25, 5000);
        coli2.calculFraisExpedition(); // Calcul des frais d'expédition pour coli2
        coli2.affiche(); // Affichage des détails de coli2

        Coli coli3 = new Coli(40, 10000);
        coli3.calculFraisExpedition(); // Calcul des frais d'expédition pour coli3
        coli3.affiche(); // Affichage des détails de coli3

        // Création d'objets ColiAssure avec différents paramètres
        ColiAssure coliAssure1 = new ColiAssure(5, 1000, 5.95);
        coliAssure1.calculFraisExpedition(); // Calcul des frais d'expédition pour coliAssure1
        coliAssure1.affiche(); // Affichage des détails de coliAssure1

        ColiAssure coliAssure2 = new ColiAssure(25, 5000, 7.95);
        coliAssure2.calculFraisExpedition(); // Calcul des frais d'expédition pour coliAssure2
        coliAssure2.affiche(); // Affichage des détails de coliAssure2

        ColiAssure coliAssure3 = new ColiAssure(40, 10000, 9.95);
        coliAssure3.calculFraisExpedition(); // Calcul des frais d'expédition pour coliAssure3
        coliAssure3.affiche(); // Affichage des détails de coliAssure3
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
