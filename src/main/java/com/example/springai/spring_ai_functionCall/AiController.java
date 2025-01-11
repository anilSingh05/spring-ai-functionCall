package com.example.springai.spring_ai_functionCall;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/weatherReport")
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/citiesByFunctionCall")
    public String getAiResponseInRealTimeUsingFunctionCall(@RequestParam(value ="input", defaultValue = "Get me current temperature for Chicago?") String input){

        SystemMessage systemMessage = new SystemMessage("You're a helpful AI assistant answering questions about Cities around the world");
        UserMessage userMessage = new UserMessage(input);

        return chatClient
                .prompt(new Prompt(List.of(systemMessage,userMessage)))
                .call()
                .content();
    }

    @GetMapping("/cities")
    public String getAiResponseInRealTime(@RequestParam(value ="input", defaultValue = "Get me current temperature for Chicago?") String input){
        return chatClient
                .prompt()
                .user(input)
                .call()
                .content();
    }
}
