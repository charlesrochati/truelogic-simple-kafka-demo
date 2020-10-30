# How to run the Application

---
## Kafka

#### Version
`2.12-2.6.0`

##### Run the commands below to run Apache kafka locally:
```sh
  # download this repo and cd into it, then run:

  # inside kafka_2.12-2.6.0
  $ cd kafka_2.12-2.6.0 && bin/zookeeper-server-start.sh config/zookeeper.properties
  $ cd kafka_2.12-2.6.0 && bin/kafka-server-start.sh config/server.properties
```

##### To create a topic, specifically a topic named `novice-players`


```sh
  # inside kafka_2.12-2.6.0
  $  bin/kafka-topics.sh --create --topic novice-players --bootstrap-server localhost:9092
```

##### To read all the events related to the topic created above, run:

```sh
  # inside kafka_2.12-2.6.0
  $ bin/kafka-console-consumer.sh --topic novice-players --from-beginning --bootstrap-server localhost:9092
```
---
## Spring Application
```sh
 $ cd kafka-sample && mvn spring-boot:run
```