################################################################
#	My first take at a Multi Stage Build using Docker. 
#   Tested on DockerTools with a Docker Enginer at 17.05-ce. 
#   A simple Spring Boot project compiled and launced in a 
#   Docker container. 
#   
################################################################
FROM maven:3.5-jdk-8 AS build-init
##LABEL description="The first build import Maven and a Java 8 JDK and will compile my project."

RUN mkdir /opt/dockerized-web-service
WORKDIR /opt/dockerized-web-service
##COPY pom.xml .
##RUN mvn dependency:resolve
COPY . .
RUN mvn clean package -DskipTests -q

## ENDING MAVEN BUILD NOT THE PACKAGING OF THE APP ITSELF

FROM openjdk:alpine
MAINTAINER Rob Paul
LABEL version="1.0"
LABEL description="Second docker build will actual set up the app, but will retrieve the compiled jar from the first build."
WORKDIR /opt

ENV JAVA_OPTS="-Xms300m -Xmx300m"
COPY --from=build-init /opt/dockerized-web-service/target/dockerized.jar ${WORKDIR}

ENTRYPOINT exec java -jar ${JAVA_OPTS} dockerized.jar
EXPOSE 8000