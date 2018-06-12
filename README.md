# Contestants ScoreBoard Test Project

Maven Project to calculate scoreboard by a input results.
This project use plugins:
- org.eclipse.mylyn.github
- org.jboss.resteasy
- org.wildfly.plugins

### Prerequisites

- Java 8
- Maven: https://maven.apache.org
- Wildfly: http://wildfly.org

### Deployment

- Run ..wildfly/bin/standalone.bat
- In project root cmd, run mvn verify
- Run mvn package
- run mvn clean install wildfly:deploy
- automated test result display on cmd
- url http://localhost:8080/TestDevGrid/

## Postman endpoints

https://documenter.getpostman.com/view/4584506/testdevgrid/RWEcQMAx

