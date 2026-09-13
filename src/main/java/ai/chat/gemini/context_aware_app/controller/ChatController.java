package ai.chat.gemini.context_aware_app.controller;

import ai.chat.gemini.context_aware_app.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/ai/prompt")
    public String chat(@RequestHeader("x-session-id") String sessionId, @RequestBody String query){
        return chatService.getResponse(sessionId, query);
    }
}
