FROM eclipse-temurin:17-jdk-alpine

RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

COPY target/global-solution-api-0.0.1-SNAPSHOT.jar app.jar

RUN chown spring:spring app.jar

USER spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]