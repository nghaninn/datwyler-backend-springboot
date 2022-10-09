FROM gradle:jdk17 as gradleimage
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN ./gradlew build -x test

FROM openjdk:17
EXPOSE 80
COPY --from=gradleimage /home/gradle/source/build/libs/*-SNAPSHOT.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "app.jar"]