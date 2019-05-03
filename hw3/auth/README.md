# Java Wordladder

1. mvn clean package
	Generate jar.

2. java -jar target/homework-0.0.1-SNAPSHOT.jar 
	Run the java program on post 8080.

3. send GET request to http://localhost:8080/ladder/[arg1]&[arg2]
	two args mean the start word and the end word.

4. to use Sping Actuator, login as {username:admin, password:123}
	then you can send GET request to http://localhost:8080/actuator.

5. another user {username:salaboy, password:123}
	use this account to see the forbidden view from actuator.
