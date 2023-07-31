FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/
EXPOSE 8085
CMD ["java", "-jar", "*.jar"]