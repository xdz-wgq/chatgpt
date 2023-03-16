package com.xdz.chatgpt.config.enums;

/**
 * 区分不同的model版本，以及相应的最大token数
 */
public enum ModelEnum {
    /**
     * gpt-4
     */
    gpt_4("gpt-4", 8192),
    /**
     * gpt-3.5-turbo
     */
    gpt_3_5_turbo("gpt-3.5-turbo", 4095),

    ;
    /**
     * 模型名称
     */
    private final String modelName;
    /**
     * 最大token
     */
    private final int maxToken;

    ModelEnum(String modelName, int maxToken) {
        this.modelName = modelName;
        this.maxToken = maxToken;
    }

    public String getModelName() {
        return modelName;
    }

    public int getMaxToken() {
        return maxToken;
    }
}
