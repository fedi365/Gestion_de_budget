# Backlog des Services Métier - Gestion de Budget

Ce document liste les User Stories (US) et tâches techniques pour le développement de la couche Service (Business Logic) de l'application.

## Épic : Gestion des Catégories et Budgets

### [TICKET-001] Création du Service de gestion des Catégories

**Priorité :** Alta
**Type :** User Story
**Description :**
En tant qu'utilisateur, je souhaite pouvoir créer, modifier et supprimer des catégories de dépenses (ex: Alimentation, Loyer, Loisirs) afin d'organiser mon budget.

**Critères d'acceptation :**

- [ ] La méthode `createCategory` doit permettre d'ajouter une nouvelle catégorie.
- [ ] La méthode `getAllCategories` doit retourner la liste de toutes les catégories disponibles.
- [ ] La méthode `updateCategory` doit permettre de renommer une catégorie.
- [ ] La méthode `deleteCategory` doit supprimer une catégorie (et gérer les transactions liées, potentiellement via un "soft delete" ou une contrainte).
- [ ] Une catégorie par défaut "Autre" doit exister.

**Tâches techniques :**

- Créer l'interface `CategoryService`.
- Implémenter `CategoryServiceImpl`.
- Injecter `CategoryRepository`.

---

### [TICKET-002] Implémentation du Service de Budget

**Priorité :** Alta
**Type :** Feature
**Description :**
Implémenter la logique métier pour définir des limites de dépenses (budgets) par catégorie et suivre leur consommation.

**Critères d'acceptation :**

- [ ] Créer une méthode pour définir un plafond mensuel pour une catégorie donnée.
- [ ] Créer une méthode pour vérifier si une transaction dépasse le budget restant de sa catégorie.
- [ ] Créer une méthode qui retourne l'état du budget pour chaque catégorie (Budget Alloué vs Dépensé).
- [ ] Envoyer une alerte (ou retourner un flag) si le budget est dépassé à 80% ou 100%.

---

## Épic : Reporting et Statistiques

### [TICKET-003] Service de Reporting Mensuel

**Priorité :** Moyenne
**Type :** Feature
**Description :**
Fournir des statistiques agrégées pour permettre à l'utilisateur de visualiser la santé de ses finances.

**Critères d'acceptation :**

- [ ] Méthode `calculateMonthlyExpenses(User user, Month month)` : Somme des transactions de type DÉPENSE.
- [ ] Méthode `calculateMonthlyIncome(User user, Month month)` : Somme des transactions/salaires de type REVENU.
- [ ] Méthode `getExpensesByCategory(User user)` : Répartition des dépenses par catégorie (pour camembert).
- [ ] Méthode `getSavingsRate(User user)` : Calcul du taux d'épargne (Revenu - Dépenses).

---

## Épic : Gestion Utilisateur et Sécurité

### [TICKET-004] Refactorisation du UserService

**Priorité :** Haute
**Type :** Refactoring
**Description :**
Actuellement, la création d'utilisateur est partiellement gérée dans `TransactionService`. Il faut centraliser la logique utilisateur dans `UserService`.

**Critères d'acceptation :**

- [ ] Déplacer la méthode `createUser` de `TransactionService` vers `UserService`.
- [ ] Ajouter une gestion simple des mots de passe (même sans chiffrement avancé pour l'instant, préparer le champ).
- [ ] Ajouter une méthode `getUserProfile` pour récupérer les infos complètes (solde actuel, etc.).
