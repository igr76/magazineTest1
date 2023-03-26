package com.example.springSecurity.sequrity.exeption;
/**
        * эксепш - класс
        * {@link
 */
public class AgentInitializationException extends Exception {
    public AgentInitializationException() {
        System.out.println("У вас нет прав доступа");
    }
}

