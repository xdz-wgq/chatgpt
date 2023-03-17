package com.xdz.test;

import com.xdz.chatgpt.config.auto.EnableChatGpt;
import com.xdz.chatgpt.service.ChatGptService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@EnableChatGpt
@SpringBootApplication
public class TestApplication {


    @Resource
    private ChatGptService chatGptService;

    @GetMapping("sendMessage")
    public String sendMessage(String message) {
        return chatGptService.sendMessage(message);
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
