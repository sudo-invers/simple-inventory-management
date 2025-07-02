package com.invers.management;

import java.util.Scanner;

public class ManagementInterface {

	public static void main(String[] args) {
		
		String scanned;
		
		System.out.println("Version 0.1");
		
		System.out.println("option: "
						 + "0. exit the program,\n"
						 + "1. register a new item,\n"
						 + "2. remove a item.\n"
						 + "3. list all\n"
						 + "4. search by name"
						 + "");
		
		try(Scanner scan = new Scanner(System.in)) {
			scanned = scan.nextLine();
			
			switch (scanned) {
			case "0":
				return;
				
			case "1":
				ProductManagement.register();
				
				break;
			case "2":
				ProductManagement.remove();
				
				break;
			case "3":
				ProductManagement.listAll();
				
				break;
			case "4":
				ProductManagement.searchByName();
				
				
			default:
				System.out.println("select a number between 0-4");
				break;
			}
			
			
			
		}
			
		
		
		
	}

}
