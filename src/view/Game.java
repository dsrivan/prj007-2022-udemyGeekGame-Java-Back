package view;

import java.util.Scanner;

import model.Calcular;

public class Game {

	static Scanner teclado = new Scanner(System.in);
	static Integer pontos = 0;
	static Calcular calcular;

	public static void main(String[] args) {
		Game.jogar();
	}

	public static void jogar() {
		System.out.println("Informe o nível de dificuldade desejada: " + 
				"\n1 = Fácil:" +
				"\n2 = Médio:" +
				"\n3 = Difícil:" +
				"\n4 = Insano:" +
				"\n5 = Ultra:");
		Integer dificuldade = Game.teclado.nextInt();
		
		Game.calcular = new Calcular(dificuldade);
		
		System.out.print("Informe o resultado para a seguinte operação: ");
		
		if (calcular.getOperacao() == 0) 
		{
			// SOMAR
			
			System.out.println(calcular.getValor1() + " + "  + calcular.getValor2());
			Integer resposta = Game.teclado.nextInt();
			
			if (calcular.somar(resposta)) {
				Game.pontos += 1;
				
				calcular.imprimePontuacao("tem", Game.pontos);
			}
		} 
		else if (calcular.getOperacao() == 1) 
		{
			// DIMINUIR
			
			System.out.println(calcular.getValor1() + " - "  + calcular.getValor2());
			Integer resposta = Game.teclado.nextInt();
			
			if (calcular.diminuir(resposta)) {
				Game.pontos += 1;
				
				calcular.imprimePontuacao("tem", Game.pontos);
			}
		}
		else if (calcular.getOperacao() == 2) 
		{
			// MULTIPLICAR
			
			System.out.println(calcular.getValor1() + " * "  + calcular.getValor2());
			Integer resposta = Game.teclado.nextInt();
			
			if (calcular.multiplicar(resposta)) {
				Game.pontos += 1;
				
				calcular.imprimePontuacao("tem", Game.pontos);
			}
		}
		else 
		{
			System.out.println("A operação " + calcular.getOperacao() + " não é reconhecida.");
		}
		
		System.out.println("Deseja continuar? [1 - SIM, 0 - NÃO]");
		Integer continuar = Game.teclado.nextInt();
		
		if (continuar == 1) {
			Game.jogar();
		} else {
			calcular.imprimePontuacao("fez", Game.pontos);
			
			System.out.println("Fim de jogo.");
			System.exit(0);
		}
		
	}

}
