package com.xdz.chatgpt.config.property;

import com.xdz.chatgpt.config.enums.ModelEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * chatgpt配置属性
 */
@ConfigurationProperties("chatgpt")
public class ChatGptProperties {

    private String apiKey;

    private ModelEnum model;

    private Integer maxTokens;

    private Double temperature = 0.5;

    private String proxy;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public ModelEnum getModel() {
        return model;
    }

    public void setModel(ModelEnum model) {
        this.model = model;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }
}
