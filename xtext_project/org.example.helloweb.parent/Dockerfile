#
# Dependencies stage
#
#FROM maven:3.8.3-openjdk-17-slim AS dependencies
#COPY pom.xml /build/

#COPY org.example.helloweb.ide/pom.xml /build/org.example.helloweb.ide/
#COPY org.example.helloweb.tests/pom.xml /build/org.example.helloweb.tests/
#COPY org.example.helloweb.web/pom.xml /build/org.example.helloweb.web/
#COPY org.example.helloweb/pom.xml /build/org.example.helloweb/
#COPY org.example.helloweb.ui/pom.xml /build/org.example.helloweb.ui/
#COPY org.example.helloweb.target/ /build/org.example.helloweb.target/
#COPY org.example.helloweb.ui.tests/pom.xml /build/org.example.helloweb.ui.tests/

#COPY org.example.helloweb.ide/META-INF/ /build/org.example.helloweb.ide/META-INF/
#COPY org.example.helloweb/META-INF/ /build/org.example.helloweb/META-INF/
#COPY org.example.helloweb.tests/META-INF/ /build/org.example.helloweb.tests/META-INF/
#COPY org.example.helloweb.ui/META-INF/ /build/org.example.helloweb.ui/META-INF/
#COPY org.example.helloweb.ui.tests/META-INF/ /build/org.example.helloweb.ui.tests/META-INF/

#WORKDIR /build/
#RUN mvn -pl '!org.example.helloweb.tests,!org.example.helloweb.ui.tests,!org.example.helloweb.ide,!org.example.helloweb.web,!org.example.helloweb.ui' -am -B clean dependency:go-offline dependency:resolve-plugins

#
# Build and RUN
#
#FROM dependencies AS builder
FROM maven:3.9.6-eclipse-temurin-17
#COPY --from=dependencies /root/.m2 /root/.m2
COPY . /app/
WORKDIR /app/
RUN mvn -pl '!org.example.helloweb.tests,!org.example.helloweb.ui.tests' -am clean compile install package 
EXPOSE 8080
CMD ["sh", "-c",  "mvn -f org.example.helloweb.web -e jetty:run -B -Djetty.port=${SERVER_PORT:-8080}"]
