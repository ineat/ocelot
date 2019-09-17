# Simple demo project of InspectIt Ocelot

Goal of this project is to illustrate InspectIt Ocelot Agent usage.

To simply launch project :

1 - Compile project

```
mvn clean install
```

2 - Run the following command to the root of this project

```
docker-compose up
```

This last command will built docker images of the project services, and launch the complete stack with Grafana, Prometheus, Ocelot config server, Postgres and project services.

Grafana can be join to the following url 
http://localhost:3001 (login 'admin' and password 'password') and Ocelot Config Server with http://localhost:8090 (login 'admin' and password 'demo')

