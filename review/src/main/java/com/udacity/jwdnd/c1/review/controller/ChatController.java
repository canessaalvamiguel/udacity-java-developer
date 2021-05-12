package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

    private MessageListService messageListService;

    public ChatController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/chat")
    public String getHomePage(@ModelAttribute("newMessage") ChatForm newMessage, Model model) {
        model.addAttribute("chats", this.messageListService.getMessages());
        return "chat";
    }

    @PostMapping("/chat")
    public String addMessage(@ModelAttribute("newMessage") ChatForm messageForm, Model model) {
        messageListService.addMessage(messageForm);
        model.addAttribute("chats", messageListService.getMessages());
        //messageForm = null;
        return "chat";
    }
}
