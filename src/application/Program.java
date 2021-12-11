package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Motorista;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Motorista> list = new ArrayList<>();
		Motorista motora = new Motorista();
		
		int somaMotora = 0;
		char novoMotora;
		
		try {
			do {
				somaMotora++;
				System.out.print("Número da CNH: ");
				int numeroCnh = sc.nextInt();
				System.out.print("Número de multas do motorista: ");
				int multas = sc.nextInt();
				
				for (int i = 0; i < multas; i++) {
					System.out.println("Natureza da " + (i + 1) +"ª multa: ");
					System.out.print("Leve(L), Média(M), Grave(G) ou Gravíssima(V): ");
					char natureza = sc.next().charAt(0);
					
					motora.pontuacao(natureza);
					
					list.add(new Motorista(numeroCnh, motora.getValorMulta(), motora.getPontos(), motora.getTotalMultas(), motora.getSomaPontos(), motora.getNatureza()));	
					System.out.println();
				}		
							
				System.out.print("Deseja cadastrar outro motorista? Sim(S) ou Nao(N) ");
				novoMotora = sc.next().charAt(0);
				
				motora.setSomaPontos(0);
				motora.setTotalMultas(0f);		  
			} while (novoMotora != 'N');
			
			System.out.println();
			System.out.println("Motoristas cadastrados: " + somaMotora);
			for (Motorista mot : list) {
				System.out.println(mot.toString());
				System.out.println();
			}
			
			System.out.println("Programa finalizado!");
		}
		catch (RuntimeException e) {
			System.out.println("Entre com os dados corretamente!");
		}
		sc.close();
	}

}
