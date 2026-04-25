"""
Cybersécurité pour débutants - Concepts fondamentaux
Sujets couverts :
  1. Analyse de la force d'un mot de passe
  2. Chiffrement César (cryptographie classique)
  3. Fonctions de hachage (MD5 et SHA-256)
  4. Encodage Base64
"""

import hashlib
import base64
import re
import string


# ─────────────────────────────────────────────
# 1. ANALYSEUR DE MOT DE PASSE
# ─────────────────────────────────────────────

def analyser_mot_de_passe(mdp: str) -> dict:
    """Évalue la robustesse d'un mot de passe selon plusieurs critères."""
    criteres = {
        "longueur_ok":      len(mdp) >= 8,
        "majuscule":        bool(re.search(r"[A-Z]", mdp)),
        "minuscule":        bool(re.search(r"[a-z]", mdp)),
        "chiffre":          bool(re.search(r"\d", mdp)),
        "caractere_special": bool(re.search(r"[!@#$%^&*(),.?\":{}|<>]", mdp)),
    }
    score = sum(criteres.values())
    niveaux = {5: "Fort", 4: "Moyen", 3: "Faible", 2: "Très faible", 1: "Dangereux", 0: "Inutilisable"}
    return {"criteres": criteres, "score": score, "niveau": niveaux.get(score, "Inutilisable")}


# ─────────────────────────────────────────────
# 2. CHIFFREMENT CÉSAR
# ─────────────────────────────────────────────

def chiffrement_cesar(texte: str, decalage: int, dechiffrer: bool = False) -> str:
    """Chiffre ou déchiffre un texte avec le chiffrement de César."""
    if dechiffrer:
        decalage = -decalage
    resultat = []
    for car in texte:
        if car.isalpha():
            base = ord('A') if car.isupper() else ord('a')
            resultat.append(chr((ord(car) - base + decalage) % 26 + base))
        else:
            resultat.append(car)
    return "".join(resultat)


# ─────────────────────────────────────────────
# 3. FONCTIONS DE HACHAGE
# ─────────────────────────────────────────────

def hacher(texte: str) -> dict:
    """Génère les empreintes MD5 et SHA-256 d'un texte."""
    encodé = texte.encode()
    return {
        "md5":    hashlib.md5(encodé).hexdigest(),
        "sha256": hashlib.sha256(encodé).hexdigest(),
    }


# ─────────────────────────────────────────────
# 4. ENCODAGE BASE64
# ─────────────────────────────────────────────

def encoder_base64(texte: str) -> str:
    return base64.b64encode(texte.encode()).decode()

def decoder_base64(texte_b64: str) -> str:
    return base64.b64decode(texte_b64.encode()).decode()


# ─────────────────────────────────────────────
# DÉMONSTRATION
# ─────────────────────────────────────────────

def separateur(titre: str):
    print(f"\n{'═' * 50}")
    print(f"  {titre}")
    print('═' * 50)


def demo_mot_de_passe():
    separateur("1. ANALYSEUR DE MOT DE PASSE")
    mots_de_passe = ["123456", "Password", "P@ssw0rd!", "X!9kL#mQ2"]
    for mdp in mots_de_passe:
        res = analyser_mot_de_passe(mdp)
        print(f"\n  Mot de passe : {mdp!r}")
        print(f"  Niveau       : {res['niveau']}  (score {res['score']}/5)")
        for critere, ok in res["criteres"].items():
            etat = "✓" if ok else "✗"
            print(f"    [{etat}] {critere}")


def demo_cesar():
    separateur("2. CHIFFREMENT DE CÉSAR")
    message = "Bonjour le Monde"
    decalage = 13
    chiffre   = chiffrement_cesar(message, decalage)
    dechiffre = chiffrement_cesar(chiffre, decalage, dechiffrer=True)
    print(f"\n  Message original : {message}")
    print(f"  Décalage         : {decalage}")
    print(f"  Message chiffré  : {chiffre}")
    print(f"  Message déchiffré: {dechiffre}")
    print("\n  ⚠ Le chiffrement César est très faible (26 combinaisons seulement).")
    print("  Un attaquant peut le casser par force brute en quelques secondes.")


def demo_hachage():
    separateur("3. FONCTIONS DE HACHAGE")
    messages = ["password", "Password", "Bonjour !"]
    for msg in messages:
        h = hacher(msg)
        print(f"\n  Texte  : {msg!r}")
        print(f"  MD5    : {h['md5']}")
        print(f"  SHA256 : {h['sha256']}")
    print("\n  ⚠ MD5 est obsolète pour la sécurité (collisions connues).")
    print("  Utilisez SHA-256 ou SHA-3 pour les applications modernes.")
    print("  Un seul caractère différent change complètement l'empreinte (effet avalanche).")


def demo_base64():
    separateur("4. ENCODAGE BASE64")
    message = "Ceci est un message secret"
    encodé  = encoder_base64(message)
    décodé  = decoder_base64(encodé)
    print(f"\n  Original : {message}")
    print(f"  Encodé   : {encodé}")
    print(f"  Décodé   : {décodé}")
    print("\n  ⚠ Base64 n'est PAS du chiffrement — c'est juste de l'encodage.")
    print("  N'importe qui peut décoder un message Base64 sans clé.")


def conclusion():
    separateur("POINTS CLÉS À RETENIR")
    points = [
        "Un bon mot de passe : ≥ 12 caractères, majuscules, chiffres, symboles.",
        "Ne jamais réutiliser le même mot de passe sur plusieurs sites.",
        "Les hachages sont à sens unique : on ne peut pas retrouver le texte d'origine.",
        "SHA-256 est sûr ; MD5 et SHA-1 sont obsolètes pour la sécurité.",
        "Base64 = encodage, PAS chiffrement. N'offre aucune confidentialité.",
        "Le chiffrement symétrique (AES) et asymétrique (RSA) sont les standards modernes.",
    ]
    for i, point in enumerate(points, 1):
        print(f"\n  {i}. {point}")
    print()


if __name__ == "__main__":
    print("\n" + "=" * 50)
    print("  CYBERSÉCURITÉ — CONCEPTS DE BASE (Python)")
    print("=" * 50)
    demo_mot_de_passe()
    demo_cesar()
    demo_hachage()
    demo_base64()
    conclusion()
