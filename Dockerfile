FROM openjdk:11-stretch

WORKDIR /app


ADD ./target/*.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 8080


ENTRYPOINT ["java","-jar","/app.jar"]