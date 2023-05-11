package com.example.pw10.components;

import com.example.pw10.interfaces.Printer;
import org.springframework.stereotype.Component;

@Component("ConsolePrinter")
public class ConsolePrinter implements Printer {
    @Override
    public void doPrint() {
        System.out.println("Text printed");
    }
}
