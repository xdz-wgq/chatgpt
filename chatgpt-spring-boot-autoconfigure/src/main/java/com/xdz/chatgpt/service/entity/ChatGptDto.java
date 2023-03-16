package com.xdz.chatgpt.service.entity;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class ChatGptDto {

    /**
     * 模型
     */
    private String model;

    /**
     * 消息
     */
    private List<Content> messages;
    /**
     * 用于指定生成的文本的最大长度
     */
    private Integer max_tokens;

    /**
     * 用于控制生成文本的创造性和多样性的参数，值越大生成的文本越不可预测，值越小生成的文本越保守和可预测
     */
    private Double temperature;

    public ChatGptDto(String model, Integer maxTokens, Double temperature, Content... contentList) {
        this.model = model;
        this.messages = Arrays.asList(contentList);
        this.max_tokens = maxTokens;
        this.temperature = temperature;
    }

    /**
     * 内容数据
     */
    public static class Content {
        /**
         * 角色
         */
        private String role;
        /**
         * 内容
         */
        private String content;

        public Content(String role, String content) {
            this.role = role;
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Content> getMessages() {
        return messages;
    }

    public void setMessages(List<Content> messages) {
        this.messages = messages;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}