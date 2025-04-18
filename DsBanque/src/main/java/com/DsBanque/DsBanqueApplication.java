package com.DsBanque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import com.DsBanque.entitie.Compte;
@SpringBootApplication
public class DsBanqueApplication {
	public static List<Compte> comptes= new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(DsBanqueApplication.class, args);
		Compte c1= new Compte(1,"Arij",3000);
		Compte c2= new Compte(2,"Maram",2000);
		Compte c3= new Compte(3,"Mariem",1000);
		comptes.add(c1);
		comptes.add(c2);
		comptes.add(c3);
	}

}
