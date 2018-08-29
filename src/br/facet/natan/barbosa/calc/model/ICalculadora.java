package br.facet.natan.barbosa.calc.model;

public interface ICalculadora
{
    /**
     * Método para somar dois números que retorna o resultado da soma.
     * 
     * @param num1 Primeiro operando da soma
     * @param num2 Segundo operando da soma
     * @return resul Resultado da soma
     */
    double soma(double num1, double num2);
    
    /**
     * Método para subtrair dois números que retorna o resultado da subtração.
     * 
     * @param num1 Primeiro operando da subtração
     * @param num2 Segundo operando da subtração
     * @return resul Resultado da subtração
     */
    double subtracao(double num1, double num2);
    
    /**
     * Método para multiplicar dois números que retorna o resultado da multiplicação.
     * 
     * @param num1 Primeiro operando da multiplicação
     * @param num2 Segundo operando da multiplicação
     * @return resul Resultado da multiplicação
     */
    double multiplicacao(double num1, double num2);
    
    /**
     * Método para dividir dois números que retorna o resultado da divisão
     * 
     * @param num1 Primeiro operando da divisão
     * @param num2 Segundo operando da divisão
     * @return resul Resultado da divisão. 
     * Caso haja uma divisão por zero, haverá uma mensagem no console.
     */
    double divisao(double num1, double num2);
}
