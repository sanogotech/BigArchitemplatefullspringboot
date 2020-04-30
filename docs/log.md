### Mise en place des logs (slf4j)

 ***1 - Création de projet et installation de la dépendance (spring-boot-starter-web)***
 
    <dependency>
        <groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
 ***2 - importation du Logger et du LoggerFactory dans la classe***
 
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    
 **Logger** est le principal point d'entrée utilisateur de l'API SLF4J.
 
 **LoggerFactory** est une classe utilitaire produisant des enregistreurs pour diverses API de journalisation, notamment pour la journalisation log4j, logback et JDK 1.4.
 
 ***3 - déclaration du Logger***
 
    private final Logger log = LoggerFactory.getLogger(this.getClass())
    
 **this.getClass()** Correspond à la class dans laquelle le **Logger** est déclaré.
 
 ***4 - Exemple d'utilisation du Logger***
 
    @RequestMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
    }
 
 
   - **Niveau des logs et descriptions**
   
        **Fatal** Affiche les problèmes graves qui peuvent entrainé la fermeture d'une application.
        
        **error** Affiche les messages liés aux erreurs d'exécution.
        
        **warning** Affiche les messages d'erreurs liés à l'utilisation d'API obsolètes.
        
        **info** Affiche les messages liés aux évènements qui se produisent lors de l'exécution.
        
        **debug** Affiche les informations sur le flux du système.
        
        **trace** Affiche les informations plus détaillées sur le flux du système.
        
 ***5 - Mettre les logs dans un fichier***   
 
  d          