package application;

import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enumm.classeTrabalhador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa
{
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");

        System.out.print("Entre com nome departamento: ");
        String departamentoNome = sc.nextLine();

        System.out.println("Dados do Trabalhador: ");
        System.out.print("Nome: ");
        String nomeTrabalhador = sc.nextLine();
        System.out.print("Level: ");
        String levelTrabalhador = sc.nextLine();
        System.out.print("Salario Base: ");
        double salarioTrabalhador = sc.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, classeTrabalhador.valueOf(levelTrabalhador), salarioTrabalhador, new Departamento(departamentoNome));

        System.out.print("Quantos contratos tem o trabalhador? ");
        int n = sc.nextInt();

        for (int i = 1; i <=n; i++ ){
            System.out.print(" Entre com o numero do Contrato: " + i + "data: ");
            System.out.print("Data: (dd/MM/aaaa) ");
            Date contratoData = sdf.parse(sc.next());
            System.out.print("Valor por Hora: ");
            double valorPorHora = sc.nextDouble();
            System.out.print("Duração (horas) : ");
            int horas = sc.nextInt();
            ContratoHora contratohora = new ContratoHora(contratoData, valorPorHora, horas);
            trabalhador.addContrato(contratohora);
        }

        System.out.println();
        System.out.print("Entre com mes e ano para calcular salario (MM/yyyy)");
        String meseAno = sc.next();
        int mes = Integer.parseInt(meseAno.substring(0,2));
        int ano = Integer.parseInt(meseAno.substring(3));
        System.out.println("Nome do trabalhador: " + trabalhador.getNome());
        System.out.println("Nome do departamento: " + trabalhador.getDepartamento().getNome());
        System.out.println("Renda "  + meseAno + ": " + String.format("%.2f", trabalhador.renda(mes, ano)));






        sc.close();
    }
}