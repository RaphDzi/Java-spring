# Java-spring

## Exercie 1 : Todo 

- Crée une API rest qui vous permez de gerer vos ToDo

> - Todo:
>> - id
>> - titre
>> - description 
>> - date
>> - isValidate

- on veux un crud complet sur nos todo soit creation, suppresion, modification, recuperer par id, recuperer toute les todo, recupere les todo validé / non validée




## Exercie 2 : Cinémathèque

Créer une application cinémathèque qui comportera les routes suivantes :

- `catalogue/films` - La liste des films
- `catalogue/realisateur` - La liste des réalisateurs
- `catalogue/film/<id>` - La fiche d'un film
- `catalogue/realisateur/<id>` - La fiche d'un réalisateur

1. Créer les modèles

- film
  - id 
  - nom 
  - date de sortie 
  - description 
  - durée 
  - genre 
  - realisateur

- realisateur
  - id 
  - nom 
  - prenom 
  - date de naissance 
  - nationalité 

2. Implémenter les méthodes permettant de faire un CRUD des deux modèles précédemment créés
3. Créer les méthodes pour :
   - Récupérer les films
   - Récupérer un film par son id
   - Récupérer les réalisateurs
   - Récupérer un réalisateur par son id
   - Récupérer les films par réalisateur
 



## Exercice 3 : Session

- Produit :
    - id
    - nom
    - prix

- crée le crud autour de notre entité produit

- crée un système de gestion de panier avec son controller dédié :
    - Ajouter un produit au panier 
    - retirer un produit du panier
    - Valider le panier et récupérer le prix total ( afficher tous les articles du panier plus le prix total du panier)

bonus :
 - ajouter la gestion de la quantité des articles au panier




## Exercice 4 : API REST Spring Boot « Creatures »


Vous devez créer une petite API REST avec Spring Boot pour manipuler des **créatures**.
L’objectif est de mettre en place un **CRUD complet** et de tester la **pagination**  et la **validation** sur les 
résultats.

---

### Entité à implémenter

**Creature**

* `id : Long`
* `name : String`
* `age : int`
* `weight : double`
* `dangerous : boolean`
* `type : CreatureType` (enum : `DRAGON, ELF, DWARF, ORC, HUMAN`)

---

### Endpoints attendus

* **POST** `/api/creatures` → créer une créature
* **GET** `/api/creatures` → récupérer toutes les créatures
* **GET** `/api/creatures/{id}` → récupérer une créature par son id
* **PUT** `/api/creatures/{id}` → mettre à jour une créature
* **DELETE** `/api/creatures/{id}` → supprimer une créature
* **GET** `/api/creatures/paged?page=0&size=5` → récupérer les créatures avec pagination

### Bonus

* **GET** `/api/creatures/paged?page=0&size=5&sortField=age&direction=asc` → récupérer les créatures avec pagination et tri


 