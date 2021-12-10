FROM openjdk:8-jre-alpine
RUN mkdir /app
RUN cd /app
COPY target/*.jar /app/HelloWorld.jar
WORKDIR /app
CMD ["java","-jar", "app.jar"]