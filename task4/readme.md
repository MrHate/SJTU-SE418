# Task 4

This task is divided into 3 programs:

1. Container
2. Provider
3. Consumer

To run:

1. Enter each folder

`mvn clean package`

`java -jar target/(container/provider/consumer).jar`

2. container will listen at port 8080
3. each consumer and provider will listen at an random port then interact with container through port 8080
4. running consumer and provider in different process will create multiple consumers or providers
5. an item staying in container for a time longer than 2s will be **timeout**
