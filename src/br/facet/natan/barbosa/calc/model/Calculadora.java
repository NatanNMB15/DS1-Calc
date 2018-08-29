package br.facet.natan.barbosa.calc.model;

/**
 * Uma classe para reger as regras de negócio de uma calculadora.
 * 
 * @author Natan
 */

public class Calculadora implements ICalculadora
{
//    private static Calculadora calculadora;
//    
//    public static Calculadora getInstance()
//    {
//        if(calculadora == null)
//        {
//            calculadora = new Calculadora();
//        }
//        
//        return calculadora;
//    }
    
    @Override
    public double soma(double num1, double num2)
    {
        double resul = 0;
        resul = num1 + num2;
        return resul;
    }
    
    
    @Override
    public double subtracao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 - num2;
        return resul;
    }
    
    
    @Override
    public double multiplicacao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 * num2;
        return resul;
    }
    
    
    @Override
    public double divisao(double num1, double num2)
    {
        double resul = 0;
        if (num2 == 0)
        {
            System.out.println("Erro! Divisão por zero");
        }
        resul = num1 / num2;
        return resul;
    }
}
