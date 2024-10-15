# Springboot - JPA

This is a simple project whose main topic is creaitng a kind of real world CRUD.


This is a simple web mvc application as a showcase of the features that usually confomrs an api REST.

## FYI

This project uses mysql as Database. there is no need to install it since there is a docker-compose file in the project. Details on how to start it below.

## Requirements

* Java 21
* Docker

## How to use

 1. Create env.properties from env.template.properties and set values for the keys.
 2. Create .env file from env.template and set values to the keys.

Then, located in project base folder, execute

`docker compose up` or `docker compose up -d`


Once the image is downloaded and the container is running:

`./mvnw spring-boot:run`
 

Build:

```
./mwnv clean package
cd /target
java -jar xxx.jar
```