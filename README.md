# e-commerce-app-micro-services

1. Création du ficher docker-compose-yml
2. docker compose up -d : pour exécuter le docker compose
3. Vérifions que tous marche :
   * On se redirige vers : http://localhost:5050/ afin de vérifier que pgadmin fonctionne bien
   * on choisit un mot de passe(root).
   * On ajoute un server en cliquant sur Add New Server
   * On remplit les champs

4. Initialisons notre config-server
    * On se dirige vers https://start.spring.io/index.html
    * on crée notre projet
    * Dépendences : spring server
    * on ouvre le projet puis dans notre classe ConfigServerApplication, on ajoute la dépendance : 
        * ``` @EnableConfigServer ```
    * puis dans application.yml, on ajoute quelques configurations
5. Après avoir fini d'implémenter le config-server, on implémente le discovery server on fait de même que config-server
   * Dépendences : spring client, eureka server
   * on ouvre le projet puis dans notre classe ConfigServerApplication, on ajoute la dépendance :
      * ``` @EnableEurekaServer ```
      * puis on procède aux configurations dans application.yml
      * dans config-server puis dans configurations, on crée le fichier de configuration de notre discovery ayant le même nom que celui mis dans application.yml de discovery puis on y met les configurations
6. Procédons à la création de notre premier micro-service (customer)
   * Initialisons le projet dans spring intilializr
   * Ajoutons les dépendances nécessaires (sprind data mongodb, eureka client, config client, spring web, validation(I/O), lombok)
   * Ajouter les configurations dans application.yml
   * On procède aux mêmes configurations que celles faites pour discovery
   * Commençons à implémenter la logique de notre microservice
   * Créons la classe customer.Customer
   * Après nous procédons à la création de toute la logique nécessaire pour le bon fonctionnement du microservice
7. Microservice product
   * Dépendances : Spring data jpa, Flyway migration, postgresql driver + ceux de customer 
   * Création des différentes classes
   * Puisqu'on a installé notre dépendance Flyway migration, donc dans ressource on se retrouve avec deux dossiers de plus db et migration
   * Créons notre script SQL pour initialiser la base de donnée
8. Microservice order
   * Dépendances : Spring web, postgresql driver, Spring data jpa, validation(I/O), eureka client, config client, lombok, OpenFeign
   * Création des différentes classes
   * Puisqu'on utilise EntityListeners, on doit ajouter l'annotation EnableJpaAuditing dans notre application (OrderApplication)
   * De même, on ajoute l'annotation EnableFeignClients puisqu'on utilise openFeign
   * Dans le fichier docker-compose, on mets les configurations pour Kafka
   * Puis on ajoute la dépendence dans pom.xml
   * Puis on ajoute une classe de configuration pour kafka
   * On ajoute également quelques configurations de kafka dans config-server (order-service.yml)
9. Microservice payment
   * Dépendances : Spring web,validation(I/O), Spring data jpa, lombok, eureka client, config client, Spring for apache Kafka, postgresql driver
   * Création des différentes classes
10. Microservice notification 
   * Dépendances : Java Mail Sender, thymeleaf, lombok, eureka client, config client, Spring for apache Kafka, mongodb
   * Création des différentes classes
11. Microservice : Gateway
   * Dépendances : gateway, discovery client, config client
12. Ajoutons Zipkin
   * Ajoutons la configuration sur docker
   * Ajoutons la dépendence de zipkin et spring actuator dans pom.xml de notre gateway
   * puis on ajoute quelques config dans application.yml de configserver
13. Ajoutons Keycloak comme Zipkin
   * Dépendences : OAuth2 Resource Server, webflux
   * puis on ajoute quelques propriètés dans application.yml du gateway
   * on crée une classe securityConfig
   * on se connecte sur keycloak puis on crée un real et un client
