FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/application/src
COPY pom.xml /home/application/
USER root
RUN --mount=type=cache,target=/root/.m2 mvn -DskipTests=true -f /home/application/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/application/target/application.jar /usr/local/lib/application.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "/usr/local/lib/application.jar"]