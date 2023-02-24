package com.xdz.chatgpt.config.auto;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ChatGptAutoImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.xdz.chatgpt.config.auto.ChatGptAutoConfiguration"};
    }
}
