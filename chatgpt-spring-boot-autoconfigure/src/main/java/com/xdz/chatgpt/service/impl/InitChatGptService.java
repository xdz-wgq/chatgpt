package com.xdz.chatgpt.service.impl;

import com.xdz.chatgpt.config.property.ChatGptProperties;
import com.xdz.chatgpt.service.ChatGptService;
import com.xdz.chatgpt.service.entity.ChatGptDto;
import com.xdz.chatgpt.service.entity.ChatGptVo;

public class InitChatGptService implements ChatGptService {

    private final ChatGptProperties chatGptProperties;

    public InitChatGptService(ChatGptProperties chatGptProperties) {
        this.chatGptProperties = chatGptProperties;
    }

    @Override
    public String sendMessage(String message) {
        ChatGptVo chatGptVo = sendRequest(chatGptProperties.getModel().getModelApi(), chatGptProperties.getApiKey(), new ChatGptDto(message, chatGptProperties.getMaxTokens(), chatGptProperties.getTemperature(), chatGptProperties.getStop()));
        return chatGptVo.getChoices().stream().map(ChatGptVo.Choice::getText).reduce("", (x, y) -> x + "\n" + y);
    }
}
