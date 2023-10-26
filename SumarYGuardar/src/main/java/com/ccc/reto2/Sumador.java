package com.ccc.reto2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sumador {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Uso: java Sumador <n1> <n2>");
			System.exit(1);
		}
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int suma = sumar(n1, n2);
		System.out.println(suma);
		String archivoResultado = "resultado_" + n1 + "_" + n2 + ".txt";
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoResultado))) {
			escritor.write(String.valueOf(suma));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static int sumar(int n1, int n2) {
		int suma = 0;
		for (int i = n1; i <= n2; i++) {
			suma += i;
		}
		return suma;
	}
}
