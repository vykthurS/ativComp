package ativComp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.TrabalhadorNivel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Qual Departamento: ");
		String departamentoNome=sc.nextLine();
		System.out.println("Nome do trabalhador: ");
		String trabalhadorNome=sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador= sc.nextLine();
		System.out.print("Salário base: ");
		double salarioBase= sc.nextDouble();
		
		Trabalhador trabalhador= new Trabalhador(trabalhadorNome, TrabalhadorNivel.valueOf(nivelTrabalhador),salarioBase, new Departamento(departamentoNome));
		
		System.out.print("Numero de contratos: ");
		int n= sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("N° do contrato: " + i +" dados: ");
			System.out.print("Date (dd/mm/yyyy): ");
			Date contratoData= sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora= sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas= sc.nextInt();
			Contrato contrato= new Contrato(contratoData, valorPorHora, horas);
			trabalhador.addContrato(contrato);
			
			
		}
		
		System.out.println();
		System.out.print("Entre com a data de calculo (mm/yyyy): ");
		String mesAndAno= sc.next();
		int mes= Integer.parseInt(mesAndAno.substring(0,2));
		int ano= Integer.parseInt(mesAndAno.substring(3));
		
		System.out.println("Nome: "+ trabalhador.getName());
		System.out.println("Departamento: "+ trabalhador.getDepartamento().getNome());
		System.out.println("Renda de: "+ mesAndAno + " : " + String.format("%.2f", trabalhador.renda(ano, mes)));
		
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
