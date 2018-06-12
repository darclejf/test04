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

1 - Run ..wildfly/bin/standalone.bat
2 - In project root cmd, run mvn verify
3 - Run mvn package
4 - run mvn clean install wildfly:deploy
5 - automated test result display on cmd
6 - url http://localhost:8080/TestDevGrid/

## Postman endpoints

https://documenter.getpostman.com/view/4584506/testdevgrid/RWEcQMAx

