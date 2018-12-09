#!/bin/bash
set -x

docker container stop mysql
docker container start mysql