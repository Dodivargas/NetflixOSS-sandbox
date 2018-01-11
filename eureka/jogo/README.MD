# Poc Eureka Discovery/Register SpringBoot.

## Build

Run class application in intellij or build jar with gradlew 

./gradlew clean build

java -jar build/libs/jogo-0.1.0.jar --server.port={Put serverport here}

## Usage 

$ curl http://127.0.0.1:9001/jogo/{id} (Return game by id)
