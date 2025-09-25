# Giai đoạn 1: Build bằng Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Giai đoạn 2: Run bằng Tomcat 10.1 (Jakarta)
FROM tomcat:10.1-jdk17

# Xóa webapp mặc định
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR vào ROOT để context path = "/"
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
