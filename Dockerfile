#FROM ubuntu:latest
#LABEL authors="sanghun"
#
#ENTRYPOINT ["top", "-b"]

# Java 23 JDK 이미지 사용
FROM openjdk:23-slim

WORKDIR /app

# build/libs 안에 있는 .jar 파일 복사
COPY build/libs/*.jar app.jar

# Spring Boot 기본 포트
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
