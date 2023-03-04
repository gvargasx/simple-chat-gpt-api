package com.example.chatgpt.controller;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatGptController {

    @PostMapping("/chat")
    @ResponseBody
    public ResponseEntity<String> chat(@RequestParam("message") String message) {
        OpenAiService service = new OpenAiService("your-key-here");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(message)
                .model("text-davinci-003")
                .maxTokens(200)
                .temperature(0.2)
                .build();
        return ResponseEntity.ok(service.createCompletion(completionRequest).getChoices().toString());
    }
}
