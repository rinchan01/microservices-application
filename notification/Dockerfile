FROM openjdk:17-jdk-slim
COPY ./target/notification-1.0-SNAPSHOT.jar /usr/app/notification-1.0-SNAPSHOT.jar
WORKDIR /usr/app
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/usr/app/notification-1.0-SNAPSHOT.jar"]