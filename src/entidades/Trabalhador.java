package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.TrabalhadorNivel;

public class Trabalhador {
	
	private String nome;
	private TrabalhadorNivel nivel;
	private double salarioBase;
	
	private Departamento departamento; 
	private List<Contrato> contratos = new ArrayList<>();
	
	public Trabalhador() {
		
	}
	public Trabalhador(String nome, TrabalhadorNivel nivel, double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}
	public String getName() {
		return nome;
	}
	public void setName(String nome) {
		this.nome = nome;
	}
	public TrabalhadorNivel getNivel() {
		return nivel;
	}
	public void setNivel(TrabalhadorNivel nivel) {
		this.nivel = nivel;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	public void addContrato(Contrato contrato) {
		contratos.add(contrato);
		
	}
	
	public void removeContrato(Contrato contrato) {
		contratos.remove(contrato);
	}
	
	public double renda (int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (Contrato c : contratos) {
			cal.setTime(c.getDate());
			int c_ano= cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
			
		}
		return soma;
		

	}

}
