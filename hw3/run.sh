#! /bin/bash
cd ./auth;
mvn clean package;
docker build -t auth:v1 .;

cd ../ladder;
mvn clean package;
docker build -t ladder:v1 .;

cd ..;
docker run --name=auth -d -p 8080:8080 auth:v1;
docker run --name=ladder --link=auth -d -P ladder:v1;
