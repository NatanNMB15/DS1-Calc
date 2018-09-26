package br.facet.natan.barbosa.calc.model;

import java.util.ArrayList;

public interface ICalculadora
{
    /**
     * Função para realizar as operações recebidas pelo Control.
     * @param equacao Lista contendo todas as equações a serem realizadas.
     * @param numeros Lista contendo todos os números para serem calculados.
     * @return Retorna o resultado das operações realizadas em String.
     */
    String realizarOperacao(ArrayList<String> equacao, ArrayList<String> numeros);
}
