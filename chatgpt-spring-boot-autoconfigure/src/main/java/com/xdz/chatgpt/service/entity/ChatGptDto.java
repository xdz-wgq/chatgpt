package com.xdz.chatgpt.service.entity;

@SuppressWarnings("all")
public class ChatGptDto {

    /**
     * 生成文本的开头或前缀
     */
    private String prompt;

    /**
     * 用于指定生成的文本的最大长度
     */
    private Integer max_tokens;

    /**
     * 用于控制生成文本的创造性和多样性的参数，值越大生成的文本越不可预测，值越小生成的文本越保守和可预测
     */
    private Double temperature;

    /**
     * 用于控制生成文本的终止符
     */
    private String stop;

    public ChatGptDto(String prompt, Integer maxTokens, Double temperature, String stop) {
        this.prompt = prompt;
        this.max_tokens = maxTokens;
        this.temperature = temperature;
        this.stop = stop;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
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

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }
}