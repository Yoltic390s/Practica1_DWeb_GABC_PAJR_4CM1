FROM eclipse-temurin:25-jdk-alpine
COPY target/Practica1-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]