FROM openjdk:8-alpine
WORKDIR /
ARG JAR_PATH
ARG PORT
ARG SERVICE
ARG JAR
ENV CONFIG_HTTP_URL ""
ENV JAR_ENV $JAR
ENV SERVICE_ENV $SERVICE

ADD ${JAR_PATH}/${JAR} ${JAR}
ADD docker/inspectit-ocelot-agent-0.4.jar inspectit-ocelot-agent-0.4.jar
ADD docker/entrypoint.sh entrypoint.sh
EXPOSE ${PORT}
RUN ["chmod", "+x", "entrypoint.sh"]

RUN wget https://github.com/jwilder/dockerize/releases/download/v0.6.0/dockerize-alpine-linux-amd64-v0.6.0.tar.gz && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-v0.6.0.tar.gz && rm dockerize-alpine-linux-amd64-v0.6.0.tar.gz

ENTRYPOINT ./entrypoint.sh $SERVICE_ENV $JAR_ENV