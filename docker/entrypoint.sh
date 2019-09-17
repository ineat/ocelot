#!/bin/sh
if [ "$CONFIG_HTTP_URL" == "" ]
then
  echo "CONFIG_HTTP_URL is empty"
else
  dockerize -wait "$CONFIG_HTTP_URL"
  sleep 60
  java -javaagent:"inspectit-ocelot-agent-0.4.jar" -Dinspectit.config.http.attributes.service=$1 -Dinspectit.config.http.url="$CONFIG_HTTP_URL" -jar $2
fi
