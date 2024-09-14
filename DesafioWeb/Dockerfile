from ubuntu:latest as build

run apt-get apdate
run apt-get install openjdk-21-jdk -y
copy . .

run apt-get install maven -y
run mvn clean install

from openjdk:21-jdk-slim

expose 8080

copy --from=build /target/deploy_render-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]