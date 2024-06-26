package com.example.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/hello") // maps the incoming message
    @SendTo("/topic/greetings") // forwards all the response messages to this topic
    public Greeting sayHello(HelloMessage message) throws InterruptedException {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName() + "!"));
    }
}
