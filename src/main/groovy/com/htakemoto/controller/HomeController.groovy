package com.htakemoto.controller

import com.htakemoto.domain.Greeting
import com.htakemoto.domain.HelloMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class HomeController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) {
        Thread.sleep(3000) // simulated delay
        return new Greeting("Hello, " + message.getName() + "!")
    }
}
