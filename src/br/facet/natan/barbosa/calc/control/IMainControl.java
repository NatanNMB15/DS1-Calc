package br.facet.natan.barbosa.calc.control;

import java.util.ArrayList;
import javax.swing.JLabel;

public interface IMainControl
{
    /**
     * Função para chamar a função de carregar janela do View.
     */
    void carregarJanela();
    
    /**
     * Função para enviar a operação recebida pelo View para o Model (Calculadora).
     * @param equacao Lista contendo todas as equações a serem realizadas.
     * @param numeros Lista contendo todos os números para serem calculados.
     */
    void enviarOperacao(ArrayList<String> equacao, ArrayList<String> numeros);
    
    /**
     * Função para enviar o resultado devolvido pelo Model (Calculadora) para o View.
     * @param s Resultado do cálculo realizado em String.
     */
    void resultadoFinal(String s);
    
    /**
     * Função para atualizar o resultado atual da View de acordo com os eventos gerados pelos botões.
     * @param s String do botão pressionado.
     */
    void atualizarResultado(String s);
    
    /**
     * Função para carregar as operações salvas em um arquivo XML e enviar para View.
     */
    void carregarConfig();
    
    /**
     * Função para salvar as operações atuais da View em um arquivo XML.
     * @param equacao Lista contendo todas as equações atuais.
     * @param numeros Lista contendo todos os números atuais.
     * @param lblEquacao Label contendo o texto na equação.
     * @param lblResultado Label contendo o texto do resultado.
     * @param indexNumeros Índice do número atual da lista de números.
     * @param operacao Variável de estado para indicar se uma operação está para ser realizada.
     */
    void salvarConfig(ArrayList<String> equacao, ArrayList<String> numeros, JLabel lblEquacao, JLabel lblResultado, int indexNumeros, boolean operacao);
}
