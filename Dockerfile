FROM amazoncorretto:11-alpine-jdk
MAINTAINER GNTLA
COPY target/gn-0.0.1-SNAPSHOT.jar gntla-app.jar
ENTRYPOINT ["java", "-jar", "/gntla-app.jar"]