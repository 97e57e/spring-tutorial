package lee.garden.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@SpringBootApplication
public class KafkaApplication {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	// 카프카 listen
	@KafkaListener(topics = "test", groupId = "my-group")
	public void listen(String message) {
		log.info("[RECEIVED] : " + message);
	}
}
