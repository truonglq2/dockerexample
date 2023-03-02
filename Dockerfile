# syntax=docker/dockerfile:1
#which "official Java imager" ?
FROM openjdk:16-alpine3.13
#working directory
WORKDIR /app
# copy from your Host to container
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#Run this inside the image
RUN dos2unix mvnw
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./mvnw","spring-boot:run"]
