package com.example.pw12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pw12Application implements CommandLineRunner {
	@Autowired
	private Hasher hasher;
	public static void main(String[] args) {
		SpringApplication.run(Pw12Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CLR run");
		if (args.length != 2){
			System.out.println("You must provide 2 args");
			System.exit(1);
		}
		else{
			hasher.run(args[0],args[1]);
			hasher.hash();
		}
	}
}