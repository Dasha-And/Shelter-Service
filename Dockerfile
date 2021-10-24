FROM adoptopenjdk/openjdk14

EXPOSE 8181

ADD target/shelter-service.jar shelter-service.jar

ENTRYPOINT ["java", "-jar", "shelter-service.jar"]

