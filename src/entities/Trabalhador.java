package entities;

import entities.enumm.classeTrabalhador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {

    private String nome;
    private classeTrabalhador classe;
    private Double salarioBase;

    private Departamento departamento;

    private List<ContratoHora> contratos = new ArrayList<>();

    public Trabalhador(){

    }

    public Trabalhador(String nome, classeTrabalhador classe, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.classe = classe;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public classeTrabalhador getClasse() {
        return classe;
    }

    public void setClasse(classeTrabalhador classe) {
        this.classe = classe;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoHora> getContrato() {
        return contratos;
    }

    public void addContrato(ContratoHora contrato){

        contratos.add(contrato);
    }
    public void removeContrato(ContratoHora contrato){
        contratos.remove(contrato);
    }

    public double renda(int ano, int mes){
        double soma = salarioBase;
        Calendar calendar = Calendar.getInstance();
        for (ContratoHora c : contratos){
            calendar.setTime(c.getDate());
            int c_ano = calendar.get(Calendar.YEAR);
            int c_mes = 1 + calendar.get(Calendar.MONTH);
            if (ano == c_ano && ano == c_mes){
                soma += c.valorTotal();
            }
        }
        return soma;


    }
}
