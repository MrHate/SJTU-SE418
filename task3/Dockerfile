FROM openjdk

MAINTAINER dgy

ENV LANG en_US.UTF-8

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

RUN mkdir -p /app/hw2

COPY ./homework-0.0.1-SNAPSHOT.jar /app/hw2

WORKDIR /app/hw2

ENTRYPOINT ["java","-jar","homework-0.0.1-SNAPSHOT.jar"]
