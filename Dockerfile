FROM eclipse-temurin:21-jdk-jammy AS build
COPY . .
RUN cd demo && ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-jammy
COPY --from=build /demo/target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

