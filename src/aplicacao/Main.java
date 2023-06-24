package aplicacao;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import exceptions.PadraoException;
import model.entities.Conta;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Entre com os dados da conta: ");
			
			System.out.println("Numero da Conta: ");
			int numero = sc.nextInt();
			System.out.println("Titular: ");
			String titular = sc.next();
			System.out.println("Deposito inicial: ");
			double depositoInicial = sc.nextDouble();
			System.out.println("Limite de saque: ");
			double limiteSaque = sc.nextDouble();
			
			Conta conta = new Conta(numero, titular, depositoInicial, limiteSaque);
			System.out.println(conta);

			System.out.println("Digite o valor que deseja sacar: ");
			double valor = sc.nextDouble();
			conta.sacar(valor);

			System.out.println(conta.getSaldo());

		} catch(InputMismatchException e) {
			System.out.println("Erro: " + e + " Somente valores inteiros sao permitidos");
		}catch(PadraoException e) {
			System.out.println("Erro ao fazer o Saque: " + e);
		}
		
		sc.close();
	}
}
