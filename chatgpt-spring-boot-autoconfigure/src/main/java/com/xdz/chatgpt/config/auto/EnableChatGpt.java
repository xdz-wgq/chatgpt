package com.xdz.chatgpt.config.auto;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Configuration
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ChatGptAutoImportSelector.class)
public @interface EnableChatGpt {
}
