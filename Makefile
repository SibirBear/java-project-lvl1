#Makefile for the First Project on the course Java on Hexlet
build:
	./mvnw clean package

run:
	java -jar target/app-1.0-SNAPSHOT-jar-with-dependencies.jar

update:
	./mvnw versions:update-properties

lint:
	./mvnw checkstyle:check

install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates
