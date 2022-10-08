#!/bin/sh

gradle build

cd ./microservices/user-service/
docker build -t workflow/user-service .

cd ../project-service/
docker build -t workflow/project-service .

cd ../task-service/
docker build -t workflow/task-service .

cd ../gateway/
docker build -t workflow/gateway .

cd ../eureka-server/
docker build -t workflow/eureka-server .

cd ../..
docker compose up
