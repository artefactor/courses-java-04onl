FROM openjdk:8-jdk-alpine
#install db
#app-get 
#config gb

ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]