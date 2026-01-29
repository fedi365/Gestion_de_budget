# 🗺️ Parcours d'Apprentissage CI/CD (Continuous Integration / Continuous Delivery)

Ce guide est conçu pour vous accompagner étape par étape dans l'apprentissage du CI/CD. Cochez les cases au fur et à mesure de votre progression.

## 🟢 NIVEAU 0 – PRÉREQUIS

Avant de parler CI/CD, il est crucial de maîtriser les bases.

- [ ] **1. Bases du développement logiciel**
  - [ ] Comprendre le cycle de vie d’une application (Dév -> Test -> Prod).
  - [ ] Distinguer les environnements (Pourquoi ne pas tester en prod ?).
  - [ ] Comprendre la différence entre Build (compilation) et Runtime (exécution).
  - [ ] Comprendre le "Semantic Versioning" (v1.0.0, v1.1.0).

- [ ] **2. Git (INDISPENSABLE)**
  - [ ] Maîtriser les commandes de base : `git clone`, `add`, `commit`, `push`, `pull`.
  - [ ] Comprendre les branches : `main` (stable), `dev` (inté), `feature/*` (travail).
  - [ ] Savoir faire une Pull Request (PR) ou Merge Request (MR).
  - [ ] Savoir résoudre des conflits de fusion simples.

- [ ] **3. Bases système**
  - [ ] Être à l'aise avec la ligne de commande (Bash/PowerShell).
  - [ ] Comprendre les fichiers et les permissions (lecture/écriture/exécution).
  - [ ] Comprendre ce qu'est une variable d’environnement.

- [ ] **4. Bases réseau & web**
  - [ ] Comprendre HTTP (requêtes/réponses).
  - [ ] Comprendre la notion de Port.
  - [ ] Distinguer Serveur vs Client.

---

## 🟡 NIVEAU 1 – CONCEPTS FONDAMENTAUX CI/CD

Comprendre la théorie avant la pratique.

- [ ] **1. Qu’est-ce que CI/CD ?**
  - [ ] Comprendre le problème : Tester et déployer à la main est lent et dangereux.
  - [ ] Comprendre la solution : Automatiser tout ce qui peut l'être après chaque changement de code.

- [ ] **2. CI vs CD**
  - [ ] **CI (Continuous Integration)** : L'art d'intégrer le code souvent.
    - _But_ : Tester, analyser, vérifier que le code ne casse rien.
  - [ ] **CD (Continuous Delivery / Deployment)** : L'art de livrer le code.
    - _Delivery_ : Prêt à être déployé manuellement à tout moment.
    - _Deployment_ : Déployé automatiquement en production.
  - [ ] Mémoriser le flux : `Code` → `Test` → `Build` → `Deploy`.

- [ ] **3. Le Pipeline**
  - [ ] Comprendre qu'un pipeline est un scénario automatique.
  - [ ] Savoir ce qui déclenche un pipeline : `push`, `pull request`, `tag` (version), ou lancement `manuel`.

- [ ] **4. Vocabulaire**
  - [ ] **Pipeline** : Le processus complet.
  - [ ] **Job** : Une grande étape logique (ex: "Tests", "Build").
  - [ ] **Step** : Une action précise dans un job (ex: "npm install").
  - [ ] **Runner** : La machine qui exécute le pipeline.
  - [ ] **Artifact** : Le fichier produit par le pipeline (ex: le fichier .jar ou .exe).

---

## 🟠 NIVEAU 2 – PREMIER PIPELINE (DÉBUTANT)

Passons à la pratique !

- [ ] **1. Choisir sa plateforme**
  - [ ] Créer un compte ou un projet sur GitHub (pour GitHub Actions) ou GitLab (pour GitLab CI).
  - _Conseil : GitHub Actions est très populaire et facile pour débuter._

- [ ] **2. Créer son premier pipeline "Hello World"**
  - [ ] Objectif simple : Afficher "Bonjour !" à chaque `push`.
  - [ ] Créer le fichier de configuration (ex: `.github/workflows/main.yml` ou `.gitlab-ci.yml`).

- [ ] **3. Comprendre la structure YAML**
  - [ ] Définir l'événement déclencheur (`on: push`).
  - [ ] Définir un job (`jobs: say-hello`).
  - [ ] Définir les étapes (`steps` : `run: echo "Bonjour"`).
  - [ ] Faire attention à l'indentation (les espaces comptent en YAML !).

---

## 🟠 NIVEAU 3 – JOBS, STEPS & RUNNERS

Complexifions un peu le script.

- [ ] **1. Créer plusieurs Jobs**
  - [ ] Créer un job de "Test" et un job de "Build".
  - [ ] Faire en sorte que le job "Build" ne se lance que si "Test" réussit (notion de dépendance).

- [ ] **2. Utiliser des Steps plus avancés**
  - [ ] Lancer des commandes shell réelles (ex: `javac` ou `npm test`).
  - [ ] Utiliser des actions pré-faites (ex: `actions/checkout@v2` pour récupérer le code).

- [ ] **3. Comprendre les Runners**
  - [ ] Faire tourner un job sur `ubuntu-latest`.
  - [ ] Essayer de changer l'OS du runner (ex: `windows-latest`).

---

## 🔴 NIVEAU 4 – VARIABLES, SECRETS & SÉCURITÉ

Gérer les données sensibles sans les exposer.

- [ ] **1. Variables d’environnement**
  - [ ] Définir une variable non sensible dans le YAML.
  - [ ] L'afficher dans un step avec `echo`.

- [ ] **2. Secrets (TRÈS IMPORTANT)**
  - [ ] Comprendre qu'on ne met **JAMAIS** de mot de passe dans le code.
  - [ ] Créer un secret dans les paramètres du repo (ex: `MY_API_KEY`).
  - [ ] L'utiliser dans le pipeline via la syntaxe de la plateforme (ex: `${{ secrets.MY_API_KEY }}`).

---

## 🟣 NIVEAU 5 – ARTIFACTS & CACHE

Optimiser et sauvegarder le travail.

- [ ] **1. Gérer les Artifacts**
  - [ ] Créer un fichier dans un job (ex: compiler le code java en .jar).
  - [ ] "Uploader" cet artifact pour le rendre disponible une fois le pipeline fini.
  - [ ] Le télécharger depuis l'interface web pour vérifier.

- [ ] **2. Utiliser le Cache**
  - [ ] Comprendre que télécharger les dépendances à chaque fois est lent.
  - [ ] Configurer le cache pour les dépendances (ex: dossier `.m2` pour Maven ou `node_modules`).
  - [ ] Vérifier que le 2ème lancement du pipeline est plus rapide.

---

## 🔵 NIVEAU 6 – BUILD & DEPLOY

Le but final : mettre en ligne.

- [ ] **1. Build Automatisé**
  - [ ] Automatiser la command `mvn clean package` ou `npm run build`.
  - [ ] Vérifier que le build passe au vert.

- [ ] **2. Docker (Optionnel mais recommandé)**
  - [ ] Construire une image Docker dans le pipeline.
  - [ ] La pousser vers un registre (Docker Hub ou GitHub Packages).

- [ ] **3. Déploiement**
  - [ ] Simuler un déploiement : Se connecter à un serveur distant via SSH dans le pipeline (en utilisant des secrets pour la clé SSH !).
  - [ ] _Ou_ Déployer vers un cloud (Heroku, Vercel, AWS) via leurs outils CLI.

---

## 🟤 NIVEAU 7 – ENVIRONNEMENTS & STRATÉGIES

Gérer la production vs le développement.

- [ ] **1. Environnements**
  - [ ] Créer des règles : Si branche `dev` -> déployer sur serveur de test.
  - [ ] Si branche `main` -> déployer en production (avec précautions !).

- [ ] **2. Rollback**
  - [ ] Réfléchir à la question : "Si le déploiement casse tout, comment je reviens en arrière rapidement ?"

---

## ⚫ NIVEAU 8 – TESTS, QUALITÉ & OBSERVABILITÉ

Rendre le pipeline robuste.

- [ ] **1. Types de tests**
  - [ ] Intégrer les tests unitaires (rapides).
  - [ ] Intégrer les tests d'intégration (plus lents).

- [ ] **2. Qualité de Code**
  - [ ] Ajouter un linter (Checkstyle, ESLint) pour vérifier le style du code.
  - [ ] Faire échouer le pipeline si le code est mal écrit.

- [ ] **3. Notifications**
  - [ ] Recevoir un mail ou un message Slack quand le pipeline échoue.
