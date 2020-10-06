package lee.garden.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaProducer producer;

    @Autowired
    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessage(@RequestParam("message") String message) {
        producer.sendMessage(message);
    }
}
