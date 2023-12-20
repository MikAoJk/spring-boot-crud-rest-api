#!/bin/bash

CURRENT_PATH="$(cd "$(dirname "$1")"; pwd)/$(basename "$1")"

./gradlew bootJar
docker build -t springbootapp .
docker-compose up -d db
docker compose build
docker compose up springbootapp
