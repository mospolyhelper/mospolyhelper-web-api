FROM gradle:8.4.0-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle buildFatJar --no-daemon

FROM openjdk:17
EXPOSE 8003:8003
RUN mkdir /app
COPY --from=build /home/gradle/src/microservices/edugma/build/libs/*.jar /app/edugma.jar
ENTRYPOINT ["java","-jar","/app/edugma.jar"]