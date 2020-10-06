# spring-kafka-sample

## Mac OS 기준의 카프카 설정

### Kafka & zookeeper 설치
```
brew install kafka
brew install zookeeper
```

### 세팅 설정
```
/usr/local/etc/kafka/server.properties 에서
#listeners=PLAINTEXT://:9092 => listeners=PLAINTEXT://localhost:9092
#advertised.listeners=PLAINTEXT://your.host.name:9092 => advertised.listeners=PLAINTEXT://localhost:9092
```

### 새로운 topic 생성
```
// test 라는 이름의 토픽 생성
kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```
### kafka 실행
```
brew services start zookeeper // 주키퍼 먼저 실행
brew services start kafka
```

### produce/consume test
```
// 토픽이 잘 생성 됐는지 확인
kafka-topics --list --zookeeper localhost:2181

// test 토픽에 전달하는 producer
kafka-console-producer --broker-list localhost:9092 --topic test

// test 토픽을 구독하는 consume
kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning
```