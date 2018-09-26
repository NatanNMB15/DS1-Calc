package br.facet.natan.barbosa.calc.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import br.facet.natan.barbosa.calc.control.IMainControl;
import br.facet.natan.barbosa.calc.control.MainControl;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.util.ArrayList;
import javax.swing.SwingConstants;

/**
 * Uma classe para controlar todos os recursos visuais (View).
 * 
 * @author Natan Barbosa
 */

public class MainWindow extends JFrame implements IMainWindow
{
    private static MainWindow window;
    private static IMainControl control;
    private JPanel pnlResultado = new JPanel();
    private JPanel pnlOperadores = new JPanel();
    private boolean operacao = false;
    private Botao botao0 = new Botao("CE");
    private Botao botao1 = new Botao("C");
    private Botao botao2 = new Botao("<");
    private Botao botao3 = new Botao("/");
    private Botao botao4 = new Botao("7");
    private Botao botao5 = new Botao("8");
    private Botao botao6 = new Botao("9");
    private Botao botao7 = new Botao("X");
    private Botao botao8 = new Botao("4");
    private Botao botao9 = new Botao("5");
    private Botao botao10 = new Botao("6");
    private Botao botao11 = new Botao("-");
    private Botao botao12 = new Botao("1");
    private Botao botao13 = new Botao("2");
    private Botao botao14 = new Botao("3");
    private Botao botao15 = new Botao("+");
    private Botao botao16 = new Botao("+ -");
    private Botao botao17 = new Botao("0");
    private Botao botao18 = new Botao(",");
    private Botao botao19 = new Botao("=");
    private final JPanel pnlResultadoEquacao = new JPanel();
    private final JLabel lblEquacao = new JLabel("");
    private final JLabel lblResultado = new JLabel("");
    private ArrayList<String> equacao = new ArrayList<String>();
    private ArrayList<String> numeros = new ArrayList<String>();
    int indexNumeros = 0;
    
    
    public MainWindow() 
    {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(400, 300));
        setSize(new Dimension(400, 300));
        setResizable(false);
        setLocationRelativeTo(null);
        
        getContentPane().add(pnlResultado, BorderLayout.NORTH);
        
        pnlResultado.add(pnlResultadoEquacao);
        pnlResultadoEquacao.setLayout(new BorderLayout(0, 0));
        lblEquacao.setHorizontalAlignment(SwingConstants.RIGHT);
        
        pnlResultadoEquacao.add(lblEquacao, BorderLayout.NORTH);
        lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        
        pnlResultadoEquacao.add(lblResultado, BorderLayout.SOUTH);
        getContentPane().add(pnlOperadores, BorderLayout.CENTER);
        pnlOperadores.setLayout(new MigLayout("", "[125px][125px][125px][125px]", "[50px][50px][50px][50px][50px]"));
        
        
        pnlOperadores.add(botao0, "cell 0 0,alignx center,aligny center");
        pnlOperadores.add(botao1, "cell 1 0,alignx center,aligny center");
        pnlOperadores.add(botao2, "cell 2 0,alignx center,aligny center");
        pnlOperadores.add(botao3, "cell 3 0,alignx center,aligny center");
        pnlOperadores.add(botao4, "cell 0 1,alignx center,aligny center");
        pnlOperadores.add(botao5, "cell 1 1,alignx center,aligny center");
        pnlOperadores.add(botao6, "cell 2 1,alignx center,aligny center");
        pnlOperadores.add(botao7, "cell 3 1,alignx center,aligny center");
        pnlOperadores.add(botao8, "cell 0 2,alignx center,aligny center");
        pnlOperadores.add(botao9, "cell 1 2,alignx center,aligny center");
        pnlOperadores.add(botao10, "cell 2 2,alignx center,aligny center");
        pnlOperadores.add(botao11, "cell 3 2,alignx center,aligny center");
        pnlOperadores.add(botao12, "cell 0 3,alignx center,aligny center");
        pnlOperadores.add(botao13, "cell 1 3,alignx center,aligny center");
        pnlOperadores.add(botao14, "cell 2 3,alignx center,aligny center");
        pnlOperadores.add(botao15, "cell 3 3,alignx center,aligny center");
        pnlOperadores.add(botao16, "cell 0 4,alignx center,aligny center");
        pnlOperadores.add(botao17, "cell 1 4,alignx center,aligny center");
        pnlOperadores.add(botao18, "cell 2 4,alignx center,aligny center");
        pnlOperadores.add(botao19, "cell 3 4,alignx center,aligny center");
        
    }
    
    @Override
    public void atualizarResultado(String s)
    {
        // Se a interface control não foi inicializada, inicializa.
        if(control == null)
        {
            control = new MainControl();
        }
        
        // Se o label resultado somente contiver zero e não tiver pressionado vírgula remova-o primeiro zero.
        if(lblResultado.getText().equals("0") && !s.equals(","))
        {
            String consertoZero = numeros.get(indexNumeros).replaceFirst("0", "");
            numeros.set(indexNumeros, consertoZero);
        }
        
        // Se o botão clicado não contiver string de instruções.
        if(!s.equals("CE") && !s.equals("C") && !s.equals("<") && !s.equals("/") && !s.equals("X") && !s.equals("-") && !s.equals("+") && !s.equals("=") && !s.equals("+ -"))
        {
            // Se o tamanho do ArrayList de números for igual ao índice, concatene as strings.
            if(numeros.size() - 1 == indexNumeros)
            {
                String temp = numeros.get(indexNumeros).concat(s);
                numeros.set(indexNumeros, temp);
            }
            
            // Senão adicione um novo elemento ao ArrayList.
            else
            {
                numeros.add(indexNumeros, s);
            }
                
            lblResultado.setText(numeros.get(indexNumeros));
        }
        
        // Senão se a instrução for de reiniciar a calculadora, apaga todos os ArrayList e reseta a interface e operadores.
        else if(s.equals("CE"))
        {
            equacao.clear();
            numeros.clear();
            lblEquacao.setText("");
            lblResultado.setText("");
            indexNumeros = 0;
            operacao = false;
        }
        
        // Senão se a instrução for de apagar os último números digitados, reseta o último elemento do ArrayList de números.
        else if(s.equals("C"))
        {
            numeros.set(indexNumeros, "");
            lblResultado.setText(numeros.get(indexNumeros));
        }
        
        // Senão se a instrução for de apagar o último dígito e houver dígitos, modifica o último elemento do ArrayList de números para remover o último dígito.
        else if(s.equals("<") && lblResultado.getText().length() >= 1)
        {
            numeros.set(indexNumeros, numeros.get(indexNumeros).substring(0, numeros.get(indexNumeros).length() - 1));
            lblResultado.setText(numeros.get(indexNumeros));
        }
        
        // Senão se a instrução de mudar de sinal for pressionada e houver dígitos, muda o sinal do número
        else if(s.equals("+ -") && lblResultado.getText().length() >= 1)
        {
            String temp = "";
            if(numeros.get(indexNumeros).startsWith("-"))
            {
                temp = numeros.get(indexNumeros).substring(1);
            }
            else
            {
                String negativo = "-";
                temp = negativo.concat(numeros.get(indexNumeros));
            }
            numeros.set(indexNumeros, temp);
            lblResultado.setText(numeros.get(indexNumeros));
        }
        
        /* Senão se a instrução for de operadores, pega o último elemento do ArrayList de números modifica o vírgula pelo ponto 
        e reseta a interface de resultado deixando o último elemento na equação, também adicionando o operador a ArrayList de equação 
        e incrementando o índice de números. 
        */ 
        else if((s.equals("X") || s.equals("/") || s.equals("+") || s.equals("-")) && operacao == false)
        {
            // Se não houver dígitos e for pressionado o sinal de menos
            if(lblResultado.getText().equals("") && s.equals("-"))
            {
                numeros.add(indexNumeros, s);
                lblResultado.setText(numeros.get(indexNumeros));
            }
            
            // Senão realiza as operações
            else
            {
                String temp = numeros.get(indexNumeros);
                String tempFinal = temp.replace(',', '.');
                numeros.set(indexNumeros, tempFinal);
                lblEquacao.setText(lblResultado.getText() + " " + s);
                equacao.add(s);
                lblResultado.setText("");
                operacao = true;
                indexNumeros++;
            }
        }
        
        /* Senão se o operador for de igual, modifica o último elemento do ArrayList de numeros de vírgula para ponto 
        e envia a operação ao método "enviarOperacao" com parâmetros do ArrayList de equacao e numeros.
        */
        else if (s.equals("=") && operacao == true)
        {
            String temp = lblResultado.getText();
            String tempFinal = temp.replace(',', '.');
            numeros.set(indexNumeros, tempFinal);
            enviarOperacao(equacao, numeros);
            operacao = false;
        }
        
        window.doLayout();
        window.repaint();
    }
    
    @Override
    public void carregarJanela()
    {
        if(window == null)
        {
            window = new MainWindow();
        }
        this.setVisible(true);
    }

    @Override
    public void enviarOperacao(ArrayList<String> equacao, ArrayList<String> numeros)
    {
        control.enviarOperacao(equacao, numeros);
    }

    @Override
    public void resultadoFinal(String s)
    {
        lblEquacao.setText("");
        String temp = s;
        String tempFinal = temp.replace('.', ',');
        String consertoZero = tempFinal.replace(",0", "");
        lblResultado.setText(consertoZero);
        equacao.clear();
        numeros.clear();
        numeros.add(consertoZero);
        indexNumeros = 0;
    }
    
    /**
     * Função para fechar a janela e salvar o estado atual da janela.
     */
    @Override
    public void dispose()
    {
        // Se a interface control não foi inicializada, inicializa.
        if(control == null)
        {
            control = new MainControl();
        }
        control.salvarConfig(equacao, numeros, lblEquacao, lblResultado, indexNumeros, operacao);
        System.exit(0);
    }

    @Override
    public void carregarConfig(ArrayList<String> equacao, ArrayList<String> numeros, String strEquacao, String strResultado, int indexNumeros, boolean operacao)
    {
        this.equacao = equacao;
        if(this.equacao == null)
        {
            this.equacao = new ArrayList<String>();
        }
        this.numeros = numeros;
        if(this.numeros == null)
        {
            this.numeros = new ArrayList<String>();
        }
        lblEquacao.setText(strEquacao);
        lblResultado.setText(strResultado);
        this.indexNumeros = indexNumeros;
        this.operacao = operacao;
    }
}
