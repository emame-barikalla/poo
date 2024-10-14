
# TP Git et Git Flow

## Objectifs
Ce TP a pour but de :
- Se familiariser avec Git, un système de gestion de version décentralisé.
- Apprendre à gérer des projets et collaborer avec d'autres développeurs en utilisant Git et Git Flow.

## Étapes du TP

### Partie 1 : Préparation de l'environnement Git
1. **Création de clé SSH :**
   ```bash
   ssh-keygen -t rsa -b 4096 -C votreadresse@email.com
   cat ~/.ssh/id_rsa.pub
   ```
   Ajoutez la clé SSH générée à votre compte GitHub ou GitLab.

2. **Configuration de Git :**
   ```bash
   git config --global user.name "Votre Nom"
   git config --global user.email "votreadresse@email.com"
   ```

3. **Tester la connexion SSH :**
   ```bash
   ssh -T git@github.com  # Ou pour GitLab : ssh -T git@gitlab.com
   ```

### Partie 2 : Création d'un nouveau projet
1. Créez un nouveau projet sur GitHub ou GitLab, et notez l'URL SSH du dépôt.
2. Clonez le projet localement :
   ```bash
   git clone git@github.com:votre-nom-utilisateur/mon-projet.git
   cd mon-projet
   ```

### Partie 3 : Travailler avec les fichiers
1. Créez un fichier `index.html` et ajoutez-y du contenu :
   ```bash
   touch index.html
   echo "Contenu de votre fichier" > index.html
   git add index.html
   git commit -m "Premier commit : ajout de index.html"
   ```

2. Visualisez l'historique des commits :
   ```bash
   git log
   ```

### Partie 4 : Collaborer avec Git
1. **Créer une branche pour une fonctionnalité :**
   ```bash
   git branch ma-fonctionnalite
   git checkout ma-fonctionnalite
   ```

2. **Modifier, valider et pousser vers le dépôt distant :**
   ```bash
   git add .
   git commit -m "Modification de ma-fonctionnalite"
   git push origin ma-fonctionnalite
   ```

3. **Gérer les conflits :**
   - Simulez un conflit, résolvez-le, puis :
   ```bash
   git add .
   git commit -m "Résolution du conflit"
   ```

### Partie 5 : Utilisation de Git Flow
1. **Initialiser Git Flow :**
   ```bash
   git flow init
   ```

2. **Créer et finir une fonctionnalité :**
   ```bash
   git flow feature start ma-fonctionnalite
   # Effectuer des modifications, puis terminer la fonctionnalité
   git flow feature finish ma-fonctionnalite
   ```

3. **Créer une version :**
   ```bash
   git flow release start ma-version
   ```

4. **Créer un correctif :**
   ```bash
   git flow hotfix start mon-correctif
   ```

## Conclusion
Ce TP couvre les étapes clés pour utiliser Git et Git Flow dans la gestion de versions et la collaboration sur des projets. En suivant ces étapes, vous pouvez structurer votre travail, gérer les versions, et travailler efficacement en équipe.
