FROM ubuntu:latest
LABEL authors="1037814"
ADD target/*.jar app.jar
ENTRYPOINT ["top", "-b"]


