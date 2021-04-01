# Client Cache Web App

* https://www.baeldung.com/apache-ignite-spring-data
* https://ignite.apache.org/docs/latest/extensions-and-integrations/spring/spring-data
* https://ignite.apache.org/docs/latest/extensions-and-integrations/spring/spring-boot
* https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
* https://spring.io/guides/gs/spring-boot-docker/

## Run Instructions

1. For Version 2
    ```
    ./gradlew bootRun
    ./gradlew bootJar
    docker build -t org.chanwr/client-cache-web-app .
    mkdir ${PWD}/ignite/work
    docker run -v ${PWD}/ignite/work:/storage -e IGNITE_WORK_DIR=/storage -p 8080:8080 org.chanwr/client-cache-web-app
    ```
2. For Version 3 (WIP) - For handling frequent builds
    ```
    mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)
    docker build --build-arg DEPENDENCY=build/dependency -t org.chanwr/client-cache-web-app .
    ```

## Docs

The diagrams are based on the [C4 Model](https://c4model.com/), specifically [C4 PlantUML](https://github.com/plantuml-stdlib/C4-PlantUML).
