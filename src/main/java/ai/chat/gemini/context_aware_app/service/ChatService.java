package ai.chat.gemini.context_aware_app.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory){
        this.chatClient = chatClientBuilder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    public String getResponse(String sessionId, String queryString){
        return this.chatClient.prompt(queryString)
                .advisors(x -> x.param(ChatMemory.CONVERSATION_ID, sessionId))
                .call().content();
    }
}
