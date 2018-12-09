#!/bin/bash
set -x

docker container stop suitcase
docker container rm suitcase
docker run --name suitcase -p 8080:8080 -p 9909:9009 --link mysql -d mihhdon/suitcase