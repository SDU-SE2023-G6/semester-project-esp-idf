#
# Nix dependencies stage
#
FROM nixos/nix:2.22.1 AS nixDependencies
RUN nix-channel --add https://nixos.org/channels/nixos-23.11 nixpkgs && \
    nix-channel --update && \
    nix-env -iA nixpkgs.jdk21 && \
    nix --experimental-features 'nix-command flakes' develop github:mirrexagon/nixpkgs-esp-dev#esp32-idf -c ls


#RUN mkdir /tmp/nix-store-closure
#RUN echo "Output references (Runtime dependencies):" $(nix-store -qR result/)
#RUN cp -R $(nix-store -qR result/) /tmp/nix-store-closure

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
FROM nixos/nix:2.22.1
COPY --from=builder /build/target/*.jar /app.jar
COPY --from=nixDependencies /nix /nix

ENV JAVA_TOOL_OPTIONS --enable-preview
EXPOSE 8080
EXPOSE 80


CMD ["java", "-jar", "/app.jar"]
