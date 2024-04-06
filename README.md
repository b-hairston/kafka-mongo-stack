## Kafka Cheatsheet

### Start Zookeeper 
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

### Start Kafka broker service
```bash
bin/kafka-server-start.sh config/server.properties
```

### Start Kafdrop Web UI

```bash
java -jar kafdrop-4.0.1.jar --kafka.brokerConnect=localhost:9092
```