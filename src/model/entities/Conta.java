package model.entities;

import exceptions.PadraoException;

public class Conta {

	private Integer numero;
	private String titular;
	private double saldo;
	private double limiteSaque;
	
	public Conta() {
			}

	public Conta(Integer numero, String titular, double saldo, double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public Double depositar(Double valor) {
		return saldo + valor;
	}
	
	public void sacar(Double valor) {
		validarSaque(valor);
		saldo -= valor;
	}
	public void validarSaque(Double valor) {
		//saque nao pode ser: nao houver saldo, ou se o valor do saque for superior ao limite da conta
		if (valor > getSaldo()) {
			throw new PadraoException("Valor desejado maior que o valor em contar.");

		}		
		if(valor > getLimiteSaque()) {
			throw new PadraoException("Valor desejado maior que o limite de saque estipulado!");
		}
	}
	@Override 
	public String toString() {
		return "Conta: "
				+ numero
				+ ", "
				+ titular
				+ ", "
				+ saldo
				+ ", "
				+ limiteSaque;
	}
}
