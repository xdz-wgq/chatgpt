package com.xdz.chatgpt.config.enums;

/**
 * Davinci-codex、Davinci、Curie、Babbage和Ada是OpenAI GPT-3模型的不同版本，它们的区别主要在于以下几个方面：
 * <p>
 * 模型大小：不同版本的模型大小不同，davinci-codex是最大的，达到了13B参数，而davinci、curie、babbage和ada依次递减，参数数量也依次减小。
 * <p>
 * 训练数据：不同版本的模型使用的训练数据也不同，davinci-codex使用了更多的数据和更广泛的领域，因此可以处理更多的任务。
 * <p>
 * 性能表现：由于模型大小和训练数据的不同，不同版本的模型在性能上也有所不同。davinci-codex在处理自然语言生成任务时表现最好，而其他模型则在更小规模的任务上表现更优秀。
 * <p>
 * 价格：不同版本的模型的价格也不同，davinci-codex是最贵的，而其他版本则相对较便宜。
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
