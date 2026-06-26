FROM eclipse-temurin:26-jdk

WORKDIR /app

COPY target/*.jar task-manager.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","task-manager.jar"]
