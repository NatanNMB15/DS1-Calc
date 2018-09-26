package br.facet.natan.barbosa.calc.view;

import java.util.ArrayList;

public interface IMainWindow
{   
    /**
     * Função para carregar a janela e torna-lá visivél.
     */
    void carregarJanela();
    
    /**
     * Função recebida pelo Control para atualizar a label resultado de acordo com os eventos gerados pelos botões.
     * @param s String do botão pressionado.
     */
    void atualizarResultado(String s);
    
    /**
     * Função para enviar a operação para o Control.
     * @param equacao Lista contendo todas as equações a serem realizadas.
     * @param numeros Lista contendo todos os números para serem calculados.
     */
    void enviarOperacao(ArrayList<String> equacao, ArrayList<String> numeros);
    
    /**
     * Função para receber do Control o resultado das operações enviadas para o Control.
     * @param s Resultado das operações em String.
     */
    void resultadoFinal(String s);
    
    /**
     * Função para carregar todas as configurações recebidas pelo Control.
     * @param equacao Lista contendo todas as equações atuais.
     * @param numeros Lista contendo todos os números atuais.
     * @param strEquacao String contendo o texto na equação.
     * @param strResultado String contendo o texto do resultado.
     * @param indexNumeros Índice do número atual da lista de números.
     * @param operacao Variável de estado para indicar se uma operação está para ser realizada.
     */
    void carregarConfig(ArrayList<String> equacao, ArrayList<String> numeros, String strEquacao, String strResultado, int indexNumeros, boolean operacao);
}
