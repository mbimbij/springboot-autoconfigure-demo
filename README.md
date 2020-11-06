https://www.youtube.com/watch?v=J852zGtsE3M
Maîtrisez les super pouvoirs de Spring Boot (Brian Clozel - Stéphane Nicoll)

2 modules:

- app: l'application "de production"
- hello-starter: contient l'autoconfiguration "Hello World"

Ingrédients de base de l'auto-configuration:

- Une classe annotée @Configuration
- Référencer cette classe dans `src/main/resources/META-INF/spring.factories`
 - `org.springframework.boot.autoconfigure.EnableAutoConfiguration=FQDN_classe_autoconfiguration`
 
Autres éléments:

- @ConditionalOnXXX
- @ConfigurationProperties
  - avec la dépendance maven `spring-boot-configuration-processor`, permet d'activer l'auto-complétion et la validation avec l'éditeur
    - nécessite un build
    - produit un fichier `target/classes/META-INF/spring-configuration-metadata.json`