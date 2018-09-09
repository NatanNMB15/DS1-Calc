package br.facet.natan.barbosa.calc.control;

public interface IMainControl
{
    double multiplicacao(double n1, double n2);
    
    double divisao(double n1, double n2);
    
    double soma(double n1, double n2);
    
    double subtracao(double n1, double n2);
    
    void atualizarResultado(String s);
}
