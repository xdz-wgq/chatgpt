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
        Integer maxTokens = chatGptProperties.getMaxTokens();
        if (maxTokens == null) {
            maxTokens = chatGptProperties.getModel().getMaxToken();
        }
        ChatGptVo chatGptVo = sendRequest(chatGptProperties.getApiKey(), new ChatGptDto(chatGptProperties.getModel().getModelName(), maxTokens, chatGptProperties.getTemperature(), new ChatGptDto.Content("user", message)));
        return chatGptVo.getChoices().stream().map(choice -> choice.getMessage().getContent()).reduce("", (x, y) -> x + "\n" + y);
    }
}
