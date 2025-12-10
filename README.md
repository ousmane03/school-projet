# school-projet
Gestion de Colis et Colis Assurés

Cette partie met en pratique la programmation orientée objet.

Coli.java
Classe représentant un colis avec :
un poids (en livres)
un mode d’expédition : Air (A), Terre (T) ou Économique (E)
des frais calculés automatiquement selon une grille tarifaire

La classe inclut :
un constructeur basé sur le poids et le mode
une méthode pour calculer les frais d’expédition
une méthode d’affichage des informations
ColiAssure.java
Classe dérivée de Coli ajoutant :
des frais d’assurance basés sur les frais initiaux
un calcul du coût total (expédition + assurance)
Elle démontre l’utilisation de l’héritage et l’extension d’une classe parent.

TestColi.java
Programme de test qui :
crée plusieurs objets Coli et ColiAssure
varie les poids et les modes d’expédition
affiche les résultats pour valider les calculs

2. Gestion de Vendeurs (Collections + Fichiers)
Cette partie se concentre sur la manipulation de données à l’aide des collections et de la lecture de fichiers.

Vendeur.java
Classe représentant un vendeur avec :
un identifiant (int)
un montant annuel des ventes (double)
des méthodes d’accès et de modification

DemoVendeur.java
Programme qui :
lit un fichier contenant une liste de vendeurs
stocke les données dans une collection d’objets Vendeur
propose un menu interactif permettant :
Affichage trié par identifiant
Affichage trié par montant annuel des ventes
Affichage du vendeur avec le plus haut montant
Affichage du vendeur avec le montant le plus bas

Quitter l’application
Ce programme permet de pratiquer le tri, la recherche et la gestion de collections.

Objectifs du projet
Maîtrise de l’héritage en Java
Extension de classes et ajout de comportements
Manipulation de listes et tris personnalisés
Lecture de fichiers texte
Conception orientée objet
Mise en place de tests simples
