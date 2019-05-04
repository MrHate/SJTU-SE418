#! /bin/bash
cd ./auth;
mvn clean package;
docker build -t hate/auth:v1 .;

cd ../ladder;
mvn clean package;
docker build -t hate/ladder:v1 .;

cd ..;
docker run --name=ladder -d -P hate/ladder:v1;
docker run --name=auth --link=ladder -d -p 8080:8080 hate/auth:v1;
