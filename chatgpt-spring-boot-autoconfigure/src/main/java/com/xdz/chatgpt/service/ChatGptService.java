package com.xdz.chatgpt.service;

import com.alibaba.fastjson.JSON;
import com.xdz.chatgpt.config.exception.ChatGptException;
import com.xdz.chatgpt.service.entity.ChatGptDto;
import com.xdz.chatgpt.service.entity.ChatGptVo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public interface ChatGptService {
    String sendMessage(String message);

    default ChatGptVo sendRequest(String apiKey, ChatGptDto chatGptDto) {
        HttpURLConnection con = null;
        try {
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setDoOutput(true);

            String input = JSON.toJSONString(chatGptDto);
            System.out.println(input);
            OutputStream os = con.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;
            StringBuilder response = new StringBuilder();
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            System.out.println(response);
            return JSON.parseObject(response.toString(), ChatGptVo.class);
        } catch (Exception e) {
            throw new ChatGptException(e.getMessage());
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }
}