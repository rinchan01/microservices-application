FROM openjdk:17-jdk-slim
COPY ./target/customer-1.0-SNAPSHOT.jar /usr/app/customer-1.0-SNAPSHOT.jar
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "customer-1.0-SNAPSHOT.jar"]