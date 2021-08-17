FROM openjdk:11-jre-slim
RUN mkdir /app
WORKDIR /app

ADD ./build/libs/product-catalog-svc-0.0.1.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]