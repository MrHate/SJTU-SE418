# homework 3

Split your REST Service of homework 2 into two microservices

1. run "sh run.sh", and the auth service will expose on port 8080.
2. log in with account(username: test, password: 123), a massage will display if success.
3. send GET request to "/localhost:8080/ladder/{begin}&{end}" to generate ladder.
4. run "sh stop.sh" to stop both two docker microservices and remove both the images and containers.
