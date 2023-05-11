FROM openjdk:17-slim
ARG JAR_FILE=container/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]