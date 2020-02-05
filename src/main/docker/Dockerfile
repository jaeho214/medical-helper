FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY *.jar medical-helper.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "../target/medical-helper-0.0.1-SNAPSHOT.jar"]