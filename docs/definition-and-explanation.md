#### INSTALLATION ET PARAMETRAGE DE JAVA JDK ET MAVEN

##### JAVA JDK

***JAVA JDK(JAVA DEVELOPPEMENT KIT)*** est un ensemble de bibliothèques et d'outils basé sur le langage JAVA.

Le téléchargement de JAVA JDK depuis le site : [JAVA-JDK](http://objis.com/tutoriel-java-installation-java-jdk-8/) , ensuite on l'installe.
Après l'installation, on crée une variable d'environnement ***JAVA_HOME*** avec pour valeur : le chemin d'access au JDK installé ***(C:\Program Files\Java\jdk1.8.0_212)***.
Ensuite on ajoute le chemin d'access au dossier ***bin*** du JDK installé ***(C:\Program Files\Java\jdk1.8.0_212\bin)*** à la variable système PATH.
Pour terminer, on ouvre notre CMD et on tape la commande ***java -version*** pour savoir si le paramétrage s'est bien passé.

***MAVEN***
		
***MAVEN*** est un outil de gestion et d'automatisation de production des projets logiciels Java.
Le téléchargement se fait dépuis le site : [maven](https://maven.apache.org/download.cgi).
Après l'avoir télécharger, il faut le décomprésser dans un répertoire au choix ***(C:\tools)***.
Ensuite on ajoute le chemin d'access au dossier bin du ***MAVEN*** décompréssé ***(C:\tools\apache-maven-3.6.3\bin)*** à la variable système PATH.
Pour terminer, on ouvre notre CMD et on tape la commande ***mvn -v*** pour savoir si le paramétrage s'est bien passé.

#### DEFINITION DES MOTS-CLES

 - ***JRE(JAVA Runtime Environment)*** est un ensemble de logiciels permettant d'exécuter des programmes écrits en JAVA
 
 - ***JAVA EE(JAVA Entreprise Edition)*** est une spécification de la technologie JAVA. c'est aussi un ensemble d'extensions lié au framework JAVA STANDARD.
 
 - ***JAVA SE (JAVA Standard Edition)*** est une spécification de la technologie JAVA destiné aux applications desktop.
 
 - ***SPRING*** est un framework très riche permettant de structurer, d’améliorer et de simplifier l’écriture d’application Java EE.
 
 - ***SPRING BOOT*** est un micro framework qui permet de faciliter la configuration d'un projet SPRING et de réduire le temps allouer au démarrage d'un projet.
 
 - ***JAR(JAVA Archive)*** est un fichier ZIP utilisé pour distriué un ensemble de classes JAVA.
 
 - ***WAR (Web application ARchive)*** est un fichier JAR utilisé pour contenir un ensemble de fichiers XML, servelets pages web statiques, le tout constituant une application web.

 - ***TYMELEAF*** est un moteur de template écrit en JAVA pouvant générer les fichier XML, XHTML et HTML5.
 
 - ***SPRING MVC*** est un framework qui fournit une architecture Model-View-Controller (MVC) et des composants prêts à l'emploi qui peuvent être utilisés pour développer des applications Web flexibles.
 
 - ***POM.XML (Project Object Model)*** est un fichier qui contient les informations nécessaires à Maven pour traiter le projet. (C'est le fichier de configuration)
 
 - ***application.properties*** est un fichier de gestion des propriétés d'un projet JAVA EE.
 
 - ***SPRING JPA(Java Persistence API)*** est une interface de programmation Java permettant aux développeurs d'organiser des données relationnelles dans des applications utilisant la plateforme Java.
 
 - ***TOMCAT*** est une implémentation open source des technologies Java Servlet, JavaServer Pages, Java Expression Language et Java WebSocket.
 
 - ***H2*** est un système de gestion de base de données relationnelles écrit en Java.
 
 - ***SERVELETS*** est une classe Java qui permet de créer dynamiquement des données au sein d'un serveur HTTP

 - ***LOG*** est un outils de maintenance de projet.
 
 - ***REPERTOIRES TEMPLATES*** est le répertoire des données dynamiques ***(pages dynamiques)***.
 
 - ***REPERTOIRES STATIQUES**** est le répertoire des données statiques ***(CSS, JS, IMAGES)***.
 
 - ***DEVTOOLS*** est un outil qui permet d'actualiser automatiquement le navigateur lorsqu'un fichier est modifié.
 
 - ***MVC(Model View Controller)*** est une architecture logicielle composé de 3 modules qui sont :
 
    -  ***Model*** est l'ensemble des données à afficher.
    -  ***View*** est la présentation de l'interface graphique.
    - ***Controller*** est l'ensemble des actions éffectuées par les utilisateurs.
  
 ### PROCESSUS DE DYNAMISATION AVEC SPRING MVC
 
 Le processus de dynamisation avec spring MVC se fait comme suit :
 
 - ***Création de projet et installation des dépendances***
 
    La création se fait dépuis la plateforme [start.spring.io](https://start.spring.io).
    
    Ensuite, nous devons installer deux dépendances (***Spring starter web*** et ***Spring Thyleaf***)
    
 - ***Création d'un model***
    
 - ***Création d'un controller***
    
    Pour créer un controller, nous allons créer une classe avec l'annotation ***@Controller***.
    
    C'est le controlleur qui fera la liaison avec la vue.
    
    Le ***Mapping*** sera utilisé pour gérer les requêtes des utilisateurs.
 
 - ***Création de page***
  
     Pour rendre une page dynamiques, nous allons le créer dans le repertoire templates.
      
     Ensuite, pour afficher les données passées au controlleur, à la vue, nous allons nous servir de la dépendance ***thymeleaf***.
     
     Pour dire à notre page qu'il doit utiliser ***Thymeleaf***, nous ajoutons ce code ci-dessous dans notre balise ***HTML*** : 
        
        - xmlns :th=http://www.thymeleaf.org
        
     Pour terminer, il va falloir ajouter nos données à la page.
     
     
     
  
        
    
    