FROM ubuntu:latest
LABEL authors="khodo"

ENTRYPOINT ["top", "-b"]