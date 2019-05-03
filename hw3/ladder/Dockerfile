FROM openjdk

MAINTAINER dgy

ENV LANG en_US.UTF-8

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

RUN mkdir -p /app/main

COPY ./target/ladder-0.0.1-SNAPSHOT.jar /app/main

WORKDIR /app/main

ENTRYPOINT ["java","-jar","ladder-0.0.1-SNAPSHOT.jar"]
