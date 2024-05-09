#
# Dependencies stage
#
FROM maven:3.9.4-eclipse-temurin-21-alpine AS dependencies
COPY pom.xml /build/
WORKDIR /build/
RUN mvn -B dependency:go-offline dependency:resolve-plugins

#
# Build stage
#
FROM dependencies AS builder
COPY --from=dependencies /root/.m2 /root/.m2
COPY src /build/src
COPY pom.xml /build/

WORKDIR /build/
RUN mvn -B -Dmaven.test.skip clean package spring-boot:repackage


#
# Runtime 
#
FROM eclipse-temurin:21-jre-alpine
COPY --from=builder /build/target/*.jar /app.jar

ARG buildVersion
ENV APP_BUILD_VERSION $buildVersion
ENV JAVA_TOOL_OPTIONS --enable-preview
EXPOSE 8080
EXPOSE 80

CMD ["java", "-jar", "/app.jar"]
