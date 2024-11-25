FROM bellsoft/liberica-openjdk-alpine:17
# or
# FROM openjdk:8-jdk-alpine
# FROM openjdk:11-jdk-alpine

CMD ["./gradlew", "clean", "build"]
# or Maven
# CMD ["./mvnw", "clean", "package"]

VOLUME /tmp

ARG JAR_FILE=build/libs/*.jar
# or Maven
# ARG JAR_FILE_PATH=target/*.jar
# Docker 베포
ADD ${JAR_FILE} docker-springboot.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080


ENTRYPOINT ["java","-jar","/app.jar"]