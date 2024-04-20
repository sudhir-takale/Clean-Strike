FROM openjdk:23-jdk

WORKDIR /mnt/d/Tasks/Clean-Strike

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
