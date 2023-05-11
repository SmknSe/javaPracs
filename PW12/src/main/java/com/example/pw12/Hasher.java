package com.example.pw12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.MessageDigest;

@Component
public class Hasher {
    private File input;
    private File output;
    private String in,out;

    @PostConstruct
    public void print(){
        System.out.println("smth");
    }
    public void run(String a, String b){
        System.out.println("HASHER run");
        in = "C:\\Users\\semey\\IdeaProjects\\PW12\\Files\\"+a;
        out = "C:\\Users\\semey\\IdeaProjects\\PW12\\Files\\"+b;
        input = new File(in);
        output = new File(out);
        System.out.println(in);
        System.out.println(out);
    }

    public void hash() throws Exception {
        FileOutputStream outputStream = new FileOutputStream(out);
        if (!input.exists()){
            outputStream.write("null".getBytes());
            outputStream.close();
            return;
        }
        FileInputStream inputStream = new FileInputStream(in);
        byte[] bytes = new byte[(int)input.length()];
        inputStream.read(bytes);
        inputStream.close();
        bytes = MessageDigest.getInstance("SHA-256").digest(bytes);
        outputStream.write(bytes);
        outputStream.close();
    }

    @PreDestroy
    public void deleteFile(){
        try{
            if (input.exists()){
                input.delete();
            }
        }catch (Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

}