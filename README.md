## TodoApp
Simple ToDO Maven Application on Spring &amp; PostrgeSQL

## Connect Postgres:
1. Add application.properties file to src/main/java/resources
2. Add Postgres configuration:
```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/tododata
spring.datasource.username=xxxxx
spring.datasource.password=xxxxx
spring.jpa.show-sql=true

## Hibernate Properties
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto = update
```