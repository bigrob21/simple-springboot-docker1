FROM openjdk:alpine
MAINTAINER Rob Paul
LABEL version="1.0"
WORKDIR /opt

ENV JAVA_OPTS="-Xms300m -Xmx300m"
COPY target/dockerized.jar ${WORKDIR}

ENTRYPOINT exec java -jar ${JAVA_OPTS} dockerized.jar
EXPOSE 8000
