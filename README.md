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
      * puis on procède aux configurations dans properties.yml
