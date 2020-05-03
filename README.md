# Application Template sur Spring Boot Full Best Practices

  * archiNewfull  = NOSQL + ELK + REDIS + NGNIX + ASYNC TASK+ Schedule + Flyway + Micro service + WorkflowSample + TuningProUnderstow + Docker + archiold + templateSpring +  simplespringbootjpaOracleDBSample + CodeCharles SSL + JWT Sample METI + myjpadatarestapi + https://netsurfingzone.com/hibernate/

Cette application est un exemple de base avec spring boot.

## Doc URL

  * https://search.maven.org/search
  * https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html
  * [Site officiel spring](https://spring.io/guides)
  * http://myjavablog.com/2018/12/29/spring-boot-spring-security-h2-database/
  * https://www.javainuse.com/spring/boot_security_jdbc_authentication_program
  * https://github.com/hendisantika/spring-boot-adminlte/blob/
  * [Autre plateforme d'apprentissage](https://baeldung.com)
  *https://www.baeldung.com/spring-jpa-like-queries
  *https://www.baeldung.com/hibernate-one-to-many
  * https://netsurfingzone.com/hibernate/one-to-many-mapping-annotation-example-in-hibernate-jpa-using-spring-boot-and-oracle/
  * https://github.com/sanogotech/angular7-spring-boot.git
  * https://www.javainuse.com/spring/boot-websocket-chat
  * https://www.javainuse.com/spring/boot-jwt
  * https://www.javainuse.com/spring/boot-jwt-mysql
  * https://www.javainuse.com/devOps/docker/docker-war
  * https://www.javainuse.com/spring/sprsec
  
##  TOP  Chrome Plugin
 - CSSViewer ,  UserSnap  Screenshot Dev,ServiState HTTP, Selenium IDE, BlazeMeter, Talend API Tester Free Edition (Test Suite + Assert Response), ColorPick

  
## Installation 

## JPA One to Many
https://www.baeldung.com/hibernate-one-to-many

* Spring Data JPA find by embedded object property --  Booking|User
```java
List<Booking> findByUser_username(String username);
```

https://www.logicbig.com/tutorials/spring-framework/spring-data/nested-properties-resolution.html

```java
List<Employee> findByDeptartementName(String deptName);

List<Employee> findByDeptartement_name(String deptName);
```


## JPA One Many + REST API
https://netsurfingzone.com/hibernate/one-to-many-mapping-annotation-example-in-hibernate-jpa-using-spring-boot-and-oracle/


##  Spring DATA JPA  FindBy---

- https://www.baeldung.com/spring-jpa-like-queries

- https://www.baeldung.com/spring-data-derived-queries
## Javadoc  Command

C:\b2b\com\steve\util\
C:\b2b\com\steve\app\
C:\b2b\com\steve\gui\


* javadoc -d "C:\docs" -sourcepath "C:\b2b" -subpackages com

* javadoc -d "C:\projectjee\projetdegestionsdestocks\docs\MyJavaDocs" -sourcepath "C:\projectjee\projetdegestionsdestocks\src\main\java" -subpackages comjavadoc -d "C:\projectjee\projetdegestionsdestocks\docs\MyJavaDocs" -sourcepath "C:\projectjee\projetdegestionsdestocks\src\main\java" -subpackages com


***  Test en Mode  DEV

0. mvn  spring-boot:run

1. http://localhost:8088

user/pwd :    admin@test.com / admin2017

2. http://localhost:8088/h2web

url :  jdbc:h2:mem:contactmanager
user: sa
pwd:

Pour voir la base en mémoire.


** Spring DATA REST 

-  Add   spring data rest starter with spring data : pom.xml

-  Implemente Default @Repository with findby?

- ADD spring.data.rest.basePath=/api  to application.properties

- http://localhost:8088/api/   (display all Rest Urls)

- First page=0

- User findByEmail(String email) in repository --->  /api/search -->  http://localhost:8088/api/users/search/findByEmail?email=myemail@yahoo.fr

- Exemple Url with pagination and sort on attribute: http://localhost:8088/api/users?page=0&size=5&sort=name,desc

---- HIBERNATE Performance Tips Sample:
*https://dzone.com/articles/50-best-performance-practices-for-hibernate-5-amp
* https://github.com/AnghelLeonard/Hibernate-SpringBoot
the n+1 select issue is the most common performance problem.
---------------------
-  https://www.baeldung.com/spring-data-rest-customize-http-endpoints
- https://www.mkyong.com/spring-data/spring-data-add-custom-method-to-repository/
- https://www.blazemeter.com/blog/spring-boot-rest-api-unit-testing-with-junit/
https://www.blazemeter.com/blog/api-testing-with-jmeter-and-the-json-extractor/
https://www.blazemeter.com/api-functional-testing/?utm_source=blog&utm_medium=BM_blog&utm_campaign=spring-boot-rest-api-unit-testing-with-junit
- "A Java class can only extend one parent class. Multiple inheritance is not allowed.
 Interfaces are not classes, however, and an interface can extend more than one parent interface. 
The extends keyword is used once, and the parent interfaces are declared in a comma-separated list".
- https://dzone.com/articles/applying-hateoas-to-a-rest-api-with-spring-boot
- "HATEOAS is an acronym for Hypermedia As The Engine Of Application State. Even after expanding that for you, it still might not mean a lot. 
HATEOAS is an extra level upon REST and is used to present information about a REST API to a client, allowing for a better understanding of the API without the need to bring up the specification or documentation. This is done by including links in a returned response and using only these links to further communicate with the server."
- Session server security vs JWT Token (client) https://dev.to/thecodearcher/what-really-is-the-difference-between-session-and-token-based-authentication-2o39
- https://medium.com/@sherryhsu/session-vs-token-based-authentication-11a6c5ac45e4

## Build/Compile

## Package

## Run

## Application web
