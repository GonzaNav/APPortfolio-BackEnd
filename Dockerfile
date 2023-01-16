FROM amazoncorretto:11-alpine-jdk

MAINTAINER GN

COPY target/gn-0.0.1-SNAPSHOT gn-0.0.1-SNAPSHOT

ENTRYPOINT ["java","-jar","/gn-0.0.1-SNAPSHOT"]