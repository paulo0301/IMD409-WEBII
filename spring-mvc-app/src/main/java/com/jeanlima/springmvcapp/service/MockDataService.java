package com.jeanlima.springmvcapp.service;

import org.springframework.stereotype.Component;

@Component
public class MockDataService {

    private final String[] linguagens = {
        "Java", "Python", "C++", "Javascript"
    };
    private final String[] sistemasOperacionais = {
        "OSX", "Windows", "Linux", "Ubuntu"
    };
    public String[] getLinguagens() {
        return linguagens;
    }
    public String[] getSistemasOperacionais() { return sistemasOperacionais; }
}
