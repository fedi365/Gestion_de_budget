# 🛠️ Tâches Pratiques CI/CD pour "Gestion de Budget"

Voici une série d'exercices concrets à appliquer directement sur votre projet Java Spring Boot. Nous allons utiliser **GitHub Actions** car c'est le plus simple pour commencer et il est intégré à GitHub.

Si vous n'avez pas encore mis ce projet sur GitHub, c'est la première étape !

---

## 🟢 ÉTAPE 1 : Préparer le Terrain

### Tâche 1.1 : Vérifier la compilation locale

Avant d'automatiser, on doit être sûr que ça marche sur votre machine.

1.  Ouvrez un terminal dans le dossier du projet `Gestion_de_budget`.
2.  Lancez la commande : `./mvnw clean package` (ou `mvnw clean package` sur Windows Cmd).
3.  **Objectif** : Vous devez voir `BUILD SUCCESS` à la fin. Si ça rate, corrigez le code avant de continuer.

---

## 🟡 ÉTAPE 2 : Votre Premier Pipeline "Hello World"

### Tâche 2.1 : Créer le dossier des workflows

GitHub Actions cherche ses configurations dans un dossier précis.

1.  À la racine du projet, créez un dossier `.github`. (Attention au point au début !)
2.  Dans `.github`, créez un dossier `workflows`.
3.  Chemin final : `Gestion_de_budget/.github/workflows/`

### Tâche 2.2 : Créer le fichier YAML

1.  Créez un fichier nommé `01-hello.yml` dans ce dossier.
2.  Copiez-y ce contenu minimal :

```yaml
name: Mon Premier Pipeline

on: [push] # Se déclenche à chaque modification du code

jobs:
  dire-bonjour:
    runs-on: ubuntu-latest
    steps:
      - name: Dire coucou
        run: echo "Bonjour, CI/CD !"
```

3.  Faites un `git add`, `git commit` et `git push`.
4.  Allez sur votre page GitHub, onglet **"Actions"**.
5.  **Objectif** : Voir le pipeline passer au vert 🟢 et lire "Bonjour, CI/CD !" dans les logs.

---

## 🟠 ÉTAPE 3 : Compiler le Projet Java (CI)

Maintenant, faisons quelque chose d'utile : vérifier que le code compile sur un autre ordinateur (le serveur de GitHub).

### Tâche 3.1 : Créer le pipeline de Build

1.  Créez un nouveau fichier `.github/workflows/02-build-java.yml`.
2.  Contenu à insérer :

```yaml
name: Build Java Spring Boot

on:
  push:
    branches: [main] # Se lance seulement sur la branche main
  pull_request:
    branches: [main]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      # 1. Récupérer le code
      - uses: actions/checkout@v3

      # 2. Installer Java 21 (votre version)
      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          java-version: "21"
          distribution: "temurin"
          cache: maven

      # 3. Lancer la compilation (sans les tests pour l'instant)
      - name: Build with Maven
        run: ./mvnw clean package -DskipTests
```

3.  **Objectif** : Push sur GitHub et vérifier que le projet compile bien sur leurs serveurs.

---

## 🔴 ÉTAPE 4 : Intégrer les Tests Automatisés

Un pipeline qui compile c'est bien, un pipeline qui teste c'est mieux !

### Tâche 4.1 : Activer les tests

1. Modifiez le fichier `02-build-java.yml`.
2. Changez la ligne de build pour inclure les tests :

```yaml
# Avant : run: ./mvnw clean package -DskipTests
# Après :
- name: Run Tests
  run: ./mvnw test
```

3. **Attention** : Comme vous utilisez une base de données (PostgreSQL/H2), les tests peuvent échouer s'ils cherchent une vraie base de données.
   - _Astuce_ : Spring Boot utilise souvent H2 (base en mémoire) pour les tests par défaut. Vérifiez que vos tests sont configurés pour utiliser H2 ou qu'ils sont indépendants.

---

## 🟣 ÉTAPE 5 : Sauvegarder l'Artifact (Le JAR)

Une fois le build fini, la machine virtuelle de GitHub est détruite. Si on veut récupérer le fichier `.jar`, il faut le demander explicitement.

### Tâche 5.1 : Uploader l'artifact

1. Ajoutez cette étape à la fin de votre fichier `02-build-java.yml` (après le build/test) :

```yaml
- name: Upload Artifact
  uses: actions/upload-artifact@v4
  with:
    name: mon-application-jar
    path: target/*.jar
    retention-days: 1
```

2. **Objectif** : Après le succès du pipeline sur GitHub, vous devriez voir un bouton pour télécharger "mon-application-jar" en bas de la page du résumé du run.

---

## 🔵 ÉTAPE 6 : (Bonus) Qualité du Code

Empêchons le code "moche" de passer !

### Tâche 6.1 : Ajouter un Job de vérification

Ajoutez un job simple qui vérifie que le code ne contient pas de choses bizarres (exemple simpliste).

```yaml
check-quality:
  runs-on: ubuntu-latest
  steps:
    - uses: actions/checkout@v3
    - name: Chercher des TODO laissés
      run: |
        # Cette commande échoue si elle trouve "TODO" dans le code
        ! grep -r "TODO" src/
```

_(Note : C'est un exemple brutal, en vrai on utilise des outils comme Checkstyle ou SonarQube)._
