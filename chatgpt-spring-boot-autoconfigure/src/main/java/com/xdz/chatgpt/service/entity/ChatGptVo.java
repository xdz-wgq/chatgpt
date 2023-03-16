package com.xdz.chatgpt.service.entity;

import java.util.List;

public class ChatGptVo {
    private String id;
    private String object;
    private Long created;

    /**
     * 模型
     */
    private String model;

    /**
     * 生成的完整列表
     */
    private List<Choice> choices;

    @SuppressWarnings("all")
    public static class Choice {
        private ChatGptDto.Content message;
        private Integer index;

        private String finish_reason;

        public ChatGptDto.Content getMessage() {
            return message;
        }

        public void setMessage(ChatGptDto.Content message) {
            this.message = message;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getFinish_reason() {
            return finish_reason;
        }

        public void setFinish_reason(String finish_reason) {
            this.finish_reason = finish_reason;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}