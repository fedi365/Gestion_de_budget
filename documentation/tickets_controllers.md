# Backlog des Contrôleurs (API REST) - Gestion de Budget

Ce document spécifie les tickets techniques pour exposer les fonctionnalités via une API REST.

## Épic : API Transactionnelle

### [TICKET-005] TransactionController - Endpoints CRUD

**Priorité :** Critique
**Description :**
Exposer les endpoints pour gérer les transactions financières (dépenses et revenus).

**Endpoints :**

- `POST /api/transactions` : Créer une nouvelle transaction.
  - Body: `{ amount, date, description, type, categoryId, userId }`
- `GET /api/transactions` : Récupérer toutes les transactions (avec pagination optionnelle).
- `GET /api/transactions/{id}` : Récupérer une transaction spécifique.
- `DELETE /api/transactions/{id}` : Supprimer une transaction.
- `GET /api/users/{userId}/transactions` : Récupérer les transactions d'un utilisateur.

**Critères techniques :**

- Utiliser `@RestController` et `@RequestMapping("/api/transactions")`.
- Gérer les exceptions (ex: `ResourceNotFoundException`) avec `@ControllerAdvice`.

---

### [TICKET-006] SalaryController - Gestion des Salaires

**Priorité :** Moyenne
**Description :**
Exposer les services liés aux revenus salariaux.

**Endpoints :**

- `POST /api/salaries` : Enregistrer un salaire.
- `GET /api/users/{userId}/salary/remaining` : Obtenir le salaire restant après dépenses (appel à `calculateRemainingSalary`).

---

## Épic : API de Référence et Configuration

### [TICKET-007] CategoryController

**Priorité :** Haute
**Description :**
Permettre au frontend de récupérer et gérer les catégories disponibles.

**Endpoints :**

- `GET /api/categories` : Liste de toutes les catégories.
- `POST /api/categories` : Créer une nouvelle catégorie (Admin ou User custom).

---

## Épic : API Dashboard

### [TICKET-008] ReportController - Statistiques

**Priorité :** Basse (Future)
**Description :**
Endpoints agrégés pour le tableau de bord.

**Endpoints :**

- `GET /api/reports/monthly_summary?userId=X&month=Y` : Retourne un objet JSON avec `totalIncome`, `totalExpense`, `remainingBudget`.
