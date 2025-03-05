package Pratica._1.JonatasFreire.service;

import Pratica._1.JonatasFreire.model.HelloMessage;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloMessage getHelloMessage() {
        return new HelloMessage("Hello, World! - By Jonatas Freire");
    }
}
