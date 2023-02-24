package com.xdz.chatgpt.config.enums;

/**
 * Davinci-codex、Davinci、Curie、Babbage和Ada是OpenAI GPT-3模型的不同版本，它们的区别主要在于以下几个方面：
 *
 * 模型大小：不同版本的模型大小不同，davinci-codex是最大的，达到了13B参数，而davinci、curie、babbage和ada依次递减，参数数量也依次减小。
 *
 * 训练数据：不同版本的模型使用的训练数据也不同，davinci-codex使用了更多的数据和更广泛的领域，因此可以处理更多的任务。
 *
 * 性能表现：由于模型大小和训练数据的不同，不同版本的模型在性能上也有所不同。davinci-codex在处理自然语言生成任务时表现最好，而其他模型则在更小规模的任务上表现更优秀。
 *
 * 价格：不同版本的模型的价格也不同，davinci-codex是最贵的，而其他版本则相对较便宜。
 */
public enum ModelEnum {
    /**
     * 计算机变成和科研领域表现突出
     */
    davinciCodex("davinci-codex", "https://api.openai.com/v1/engines/davinci-codex/completions"),
    /**
     * 强大的文本处理能力
     */
    davinci("davinci", "https://api.openai.com/v1/engines/davinci/completions"),
    /**
     * OpenAI发布的第二个GPT模型，相比较于Davinci，它的规模更小，能力也更弱。但是相对的，它的计算速度更快，适合在较小的硬件设备上部署和使用
     */
    curie("curie", "https://api.openai.com/v1/engines/curie/completions"),
    /**
     * OpenAI发布的较新的GPT模型，其规模比Davinci更大，拥有更多的参数和更强的计算能力，可以生成更加准确和自然的文本
     */
    babbage("babbage", "https://api.openai.com/v1/engines/babbage/completions"),
    /**
     * OpenAI发布的GPT-3的一个较小的子集模型，拥有比Davinci和Babbage更少的参数和计算能力，但仍然可以生成一定质量的自然语言文本。由于它的规模较小，因此可以在资源受限的环境中运行
     */
    ada("ada", "https://api.openai.com/v1/engines/ada/completions"),

    ;
    /**
     * 模型名称
     */
    private final String modelName;

    /**
     * 模型api
     */
    private final String modelApi;

    ModelEnum(String modelName, String modelApi) {
        this.modelName = modelName;
        this.modelApi = modelApi;
    }

    public String getModelName() {
        return modelName;
    }

    public String getModelApi() {
        return modelApi;
    }
}
