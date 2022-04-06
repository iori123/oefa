FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8990
ARG JAR_FILE=target/oefa.jar
ADD ${JAR_FILE} sdvp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sdvp.jar"]
