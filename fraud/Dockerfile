FROM openjdk:17-jdk-slim
COPY ./target/fraud-1.0-SNAPSHOT.jar /usr/app/fraud-1.0-SNAPSHOT.jar
WORKDIR /usr/app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/usr/app/fraud-1.0-SNAPSHOT.jar"]