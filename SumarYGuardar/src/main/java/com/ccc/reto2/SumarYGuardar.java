package com.ccc.reto2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class SumarYGuardar {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Uso: java SumaryGuardar <n1> <n2>");
			System.exit(1);
		}
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int numProcesadores = Runtime.getRuntime().availableProcessors();
		int intervalo = (n2 - n1 + 1) / numProcesadores;
		System.out.println("intervalo" + intervalo);
		for (int i = 0; i < numProcesadores; i++) {
			System.out.println("n1=" + n1);
			System.out.println("n2=" + n2);
			int inicio = n1 + i * intervalo;
			int fin = (i == numProcesadores ) ? n2 : n1 + (i+1) * intervalo;
			System.out.println("incio:"+inicio);
			System.out.println("fin:"+fin);
			String archivoResultado = "resultado_" + inicio + "_" + fin + ".txt";
			ProcessBuilder pb = new ProcessBuilder("java", "com.ccc.reto2.Sumador", String.valueOf(inicio), String.valueOf(fin)).inheritIO();	
			pb.directory(new File ("target/classes"));
			pb.redirectOutput(ProcessBuilder.Redirect.to(new java.io.File(archivoResultado)));
			try {
				Process proceso = pb.start();
				proceso.waitFor();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
