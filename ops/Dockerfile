FROM maven:3.8.5-openjdk-18-slim as builder
COPY . /app
WORKDIR /app
RUN --mount=type=cache,target=/root/.m2 mvn package


FROM openjdk:18-slim-buster
COPY --from=builder /app/target/todo-data.jar /app/todo-data.jar
RUN ls -l /app
CMD ["java","-jar","/app/todo-data.jar"]
