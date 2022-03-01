package model;

import java.util.Random;

public class Calcular {

	private Integer dificuldade;
	private Integer valor1;
	private Integer valor2;
	private Integer operacao;
	private Integer resultado;

	public Calcular(Integer dificuldade) {

		Random random = new Random();

		this.operacao = random.nextInt(3); // gera um número inteiro de 0-3.
		this.dificuldade = dificuldade;

		if (dificuldade == 1) {
			// fácil
			this.valor1 = random.nextInt(10); // 0-9
			this.valor2 = random.nextInt(10); // 0-9
		} else if (dificuldade == 2) {
			// médio
			this.valor1 = random.nextInt(100); // 0-99
			this.valor2 = random.nextInt(100); // 0-99
		} else if (dificuldade == 3) {
			// difícil
			this.valor1 = random.nextInt(1000); // 0-999
			this.valor2 = random.nextInt(1000); // 0-9999
		} else if (dificuldade == 4) {
			// insano
			this.valor1 = random.nextInt(10000); // 0-9999
			this.valor2 = random.nextInt(10000); // 0-9999
		} else {
			// ultra
			this.valor1 = random.nextInt(100000); // 0-99999
			this.valor2 = random.nextInt(100000); // 0-99999
		}
	}
	
	public void imprimePontuacao(String verbo, int pontos) {		
		if (pontos <= 1) {
			System.out.println("Você " + verbo + " " + pontos + " ponto.");					
		} else {
			System.out.println("Você " + verbo + " " + pontos + " pontos.");
		}		
	}
	
	public boolean multiplicar(int resposta) {
		this.resultado = this.getValor1() * this.getValor2();
		boolean certo = false;
		
		if (resposta == this.getResultado()) {
			System.out.println("Resposta correta!");
			certo = true;
		} else {
			System.out.println("Resposta errada!");			
		}
		
		System.out.println(this.getValor1() + " * " + this.getValor2() + " = " + this.getResultado());
		
		return certo;
	}
	
	public boolean diminuir(int resposta) {
		this.resultado = this.getValor1() - this.getValor2();
		boolean certo = false;
		
		if (resposta == this.getResultado()) {
			System.out.println("Resposta correta!");
			certo = true;
		} else {
			System.out.println("Resposta errada!");			
		}
		
		System.out.println(this.getValor1() + " - " + this.getValor2() + " = " + this.getResultado());
		
		return certo;
	}
	
	public boolean somar(int resposta) {
		this.resultado = this.getValor1() + this.getValor2();
		boolean certo = false;
		
		if (resposta == this.getResultado()) {
			System.out.println("Resposta correta!");
			certo = true;
		} else {
			System.out.println("Resposta errada!");			
		}
		
		System.out.println(this.getValor1() + " + " + this.getValor2() + " = " + this.getResultado());

		return certo;
	}

	@Override
	public String toString() {
		String operacao;
		if (this.getOperacao() == 0) {
			operacao = "Somar";
		} else if (this.getOperacao() == 1) {
			operacao = "Dimninuir";
		} else if (this.getOperacao() == 2) {
			operacao = "Multiplicar";
		} else {
			operacao = "Operação desconhecida";
		}
		return "Valor 1: " + this.getValor1() + 
				"\nValor 2: " + this.getValor2() + 
				"\nDificuldade: " + this.getDificuldade() + 
				"\nOperação: " + operacao;
	}

	public Integer getDificuldade() {
		return dificuldade;
	}

	public Integer getValor1() {
		return valor1;
	}

	public Integer getValor2() {
		return valor2;
	}

	public Integer getOperacao() {
		return operacao;
	}

	public Integer getResultado() {
		return resultado;
	}
}
