FROM amazoncorretto:19

COPY target/gn-0.0.1-SNAPSHOT gn-0.0.1-SNAPSHOT

ENTRYPOINT ["java","-jar","/gn-0.0.1-SNAPSHOT"]