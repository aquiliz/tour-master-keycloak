# README #

### Tour Master (with Keycloak) ###

Tour Master is a Java/Spring - based, cloud-native app for managing short-lasted touristic tours.  
It uses a PostgreSQL relational database and Keycloak as identity and access manager. 


### How do I get set up? ###

* Download the latest Keycloak standalone server from https://www.keycloak.org/downloads.html
  and unzip it.  
  For windows, start the standalone.bat inside the bin folder.
  Open the admin console at http://localhost:8080/auth/admin/
*   Create a realm, client, roles and users in Keycloak.  
   Follow this guide to set things up, but use the data from below: https://medium.com/devops-dudes/securing-spring-boot-rest-apis-with-keycloak-1d760b2004e
    - Realm: tour_master
    - Client: tour_master
    - Roles: admin, regular_user, tour_creator
    - Users: usr_admin, usr_regular_user, usr_tour_creator     
* Start the PostgreSQL server and create a database: tour_master_keycloak
* Run the TourMasterApplication class, or the mnvw file
* Use the provided Postman collection (in this repo) to authenticate as different users, or manage tours and orders.
* To run the integraton tests locally, you need a locally running Docker and internet connection (so that the docker images can be downloaded)
