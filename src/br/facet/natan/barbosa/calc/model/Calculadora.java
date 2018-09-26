package br.facet.natan.barbosa.calc.model;

import java.util.ArrayList;

/**
 * Uma classe para reger as regras de negócio de uma calculadora.
 * 
 * @author Natan Barbosa
 */

public class Calculadora implements ICalculadora
{
    /**
     * Função para realizar a soma dos números recebidos.
     * @param num1 Primeiro número.
     * @param num2 Segundo número
     * @return Retorna o resultado da soma dos dois números
     */
    public double soma(double num1, double num2)
    {
        double resul = 0;
        resul = num1 + num2;
        return resul;
    }
    
    /**
     * Função para realizar a subtração dos números recebidos.
     * @param num1 Primeiro número.
     * @param num2 Segundo número
     * @return Retorna o resultado da subtração dos dois números
     */
    public double subtracao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 - num2;
        return resul;
    }
    
    /**
     * Função para realizar a multiplicação dos números recebidos.
     * @param num1 Primeiro número.
     * @param num2 Segundo número
     * @return Retorna o resultado da multiplicação dos dois números
     */
    public double multiplicacao(double num1, double num2)
    {
        double resul = 0;
        resul = num1 * num2;
        return resul;
    }
    
    /**
     * Função para realizar a divisão dos números recebidos.
     * @param num1 Primeiro número.
     * @param num2 Segundo número
     * @return Retorna o resultado da divisão dos dois números
     */
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


    @Override
    public String realizarOperacao(ArrayList<String> equacao, ArrayList<String> numeros)
    {
       for(int i = 0; i < equacao.size(); i++)
       {
           double resultado = 0;
           if(equacao.get(i).equals("+"))
           {
               resultado = soma(Double.parseDouble(numeros.get(i)), Double.parseDouble(numeros.get(i + 1)));
           }
           else if(equacao.get(i).equals("-"))
           {
               resultado = subtracao(Double.parseDouble(numeros.get(i)), Double.parseDouble(numeros.get(i + 1)));
           }
           else if(equacao.get(i).equals("X"))
           {
               resultado = multiplicacao(Double.parseDouble(numeros.get(i)), Double.parseDouble(numeros.get(i + 1)));
           }
           else if(equacao.get(i).equals("/"))
           {
               resultado = divisao(Double.parseDouble(numeros.get(i)), Double.parseDouble(numeros.get(i + 1)));
           }
           
           numeros.set((i + 1), String.valueOf(resultado));
       }
        
       return numeros.get(numeros.size() - 1);
       
    }
}
