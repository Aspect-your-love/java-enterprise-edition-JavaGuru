package net.aspect.education.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageRestController {

    private final MessageSource messageSource;

    @Autowired
    public MessageRestController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public String getMessage(@RequestParam("key") String key,
                            @RequestParam("lang") String language){
        return messageSource.getMessage(key, null, null, new Locale(language));
    }
}
