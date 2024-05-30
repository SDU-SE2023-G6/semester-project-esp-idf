#
# Dependencies stage
#
FROM maven:3.9.4-eclipse-temurin-21-alpine AS dependencies
COPY backend/pom.xml /build/
WORKDIR /build/
RUN mvn -B dependency:go-offline dependency:resolve-plugins

#
# Build stage
#
FROM dependencies AS builder
COPY --from=dependencies /root/.m2 /root/.m2
COPY backend/src /build/src
COPY backend/pom.xml /build/

WORKDIR /build/
RUN mvn -B -Dmaven.test.skip clean package spring-boot:repackage

#
# Runtime
#
FROM espressif/idf:release-v5.2
RUN . /opt/esp/entrypoint.sh
RUN apt update && apt install -y openjdk-21-jdk dos2unix 
COPY --from=builder /build/target/*.jar /app.jar
COPY ESP-OTA-MQTT /compiler/base

RUN dos2unix /compiler/base/auto-build.sh

ENV JAVA_TOOL_OPTIONS --enable-preview
EXPOSE 8080
EXPOSE 80


CMD ["java", "-jar", "/app.jar"]
