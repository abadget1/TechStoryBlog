#FROM openjdk:11-jdk-slim as builder
#COPY . /app
#WORKDIR /app
#RUN ./mvnw clean package -DskipTests
#
#FROM openjdk:11-jre-slim
#COPY --from=builder /app/target/*.jar /app/app.jar
#COPY application.properties /resources/application.properties
#
#ENV JAVA_OPTS=""
#ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dspring.config.location=file:/app/application.properties -jar /app/app.jar"]

#
#
FROM openjdk:8

COPY target/Blog-0.0.1-SNAPSHOT.jar Blog-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/app.jar"]

