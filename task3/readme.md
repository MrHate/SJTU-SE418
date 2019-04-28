# task 3

1. Write DockerFile

## build
2. docker build -t <name:tag> .

## run
3. docker run -p <local-port:instance-port> <image-name:tag> --name <instance-name>

## exec
4. docker exec <instance-name> <shell-path> 在instance-name的容器中执行shell-path下的shell文件
5. docker exec -it <instance-name> /bin/bash 在instance-name的容器中开启一个交互终端

## pull
6. docker pull <image> 从dockerhub上pull镜像到本地

## push
7. docker push <name:tag> 向dockerhub上push本地镜像

## dockerhub
8. https://cloud.docker.com/repository/docker/hate/se418
