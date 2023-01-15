FROM amazoncorretto:8-alpine-jdk
COPY target/gn-0.0.1-SNAPSHOT gn.jar
ENTRYPOINT ["java","-jar","/gn.jar"]