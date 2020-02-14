FROM openjdk:8-jdk-alpine
RUN apk add --no-cache maven git
WORKDIR /frigand
COPY pom.xml .
COPY src/ ./src/
RUN mvn package

FROM openjdk:8-jdk-alpine
COPY --from=0 /frigand/target/frigand-1.0-SNAPSHOT.jar /frigand.jar
EXPOSE 13031
ENV TARGET @
ENTRYPOINT ["java","-jar","frigand.jar"]

