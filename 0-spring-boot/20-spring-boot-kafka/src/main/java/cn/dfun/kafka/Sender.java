package cn.dfun.kafka;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.dfun.entity.Message;
import lombok.extern.slf4j.Slf4j;

@Component
public class Sender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    public void send() {
        Message message = new Message();
        message.setId(1L);
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        kafkaTemplate.send("vincent", gson.toJson(message));
    }
}
