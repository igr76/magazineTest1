package com.example.springSecurity.sequrity.exeption;
/**
        * эксепш - класс
        * {@link
 */
public class AgentInitializationException extends Exception {
    public AgentInitializationException(String message) {
        super(message);
        System.out.println("У вас нет прав доступа");
    }
}

