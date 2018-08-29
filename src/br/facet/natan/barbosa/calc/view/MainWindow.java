package br.facet.natan.barbosa.calc.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import br.facet.natan.barbosa.calc.control.MainControl;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame
{
    private static MainWindow window;
    private JPanel pnlResultado = new JPanel();
    private JPanel pnlOperadores = new JPanel();
    private boolean operacao = false;
    public double num1 = 0;
    public double num2 = 0;
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
    private Botao botao16 = new Botao(" ");
    private Botao botao17 = new Botao("0");
    private Botao botao18 = new Botao(",");
    private Botao botao19 = new Botao("=");
    private final JPanel pnlResultadoEquacao = new JPanel();
    private final JLabel lblEquacao = new JLabel("");
    private final JLabel lblResultado = new JLabel("");
    
    
    public static MainWindow getInstance()
    {
        if(window == null)
        {
            window = new MainWindow();
        }
        
        return window;
    }
    
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
    
    public void atualizarResultado(String s)
    {
        if(!s.equals("CE") && !s.equals("C") && !s.equals("<") && !s.equals("/") && !s.equals("X") && !s.equals("-") && !s.equals("+") && !s.equals("=") && !s.equals(" "))
        {
            lblResultado.setText(lblResultado.getText() + s);
        }
        else if(s.equals("CE"))
        {
            lblEquacao.setText("");
            lblResultado.setText("");
            operacao = false;
        }
        else if(s.equals("C") && operacao == true)
        {
            lblResultado.setText("");
        }
        else if(s.equals("<"))
        {
            lblResultado.setText(lblResultado.getText().substring(0, lblResultado.getText().length() - 1));
        }
        else if(s.equals("X") || s.equals("/") || s.equals("+") || s.equals("-"))
        {
            String temp = lblResultado.getText();
            String tempFinal = temp.replace(',', '.');
            if(operacao == false)
            {
                num1 = Double.parseDouble(tempFinal);
            }
            lblEquacao.setText(lblResultado.getText() + " " + s);
            lblResultado.setText(" ");
            operacao = true;
        }
        else if (s.equals("=") && operacao == true)
        {
            String temp = lblResultado.getText();
            String tempFinal = temp.replace(',', '.');
            num2 = Double.parseDouble(tempFinal);
            double resultado = 0;
            
            if(lblEquacao.getText().endsWith("X"))
            {
                resultado = MainControl.getInstance().multiplicacao(num1, num2);
                lblEquacao.setText(" ");
                lblResultado.setText(String.valueOf(resultado));
            }
            
            else if(lblEquacao.getText().endsWith("/"))
            {
                resultado = MainControl.getInstance().divisao(num1, num2);
                lblEquacao.setText(" ");
                lblResultado.setText(String.valueOf(resultado));
            }
            
            else if(lblEquacao.getText().endsWith("+"))
            {
                resultado = MainControl.getInstance().soma(num1, num2);
                lblEquacao.setText(" ");
                lblResultado.setText(String.valueOf(resultado));
            }
            
            else if(lblEquacao.getText().endsWith("-"))
            {
                resultado = MainControl.getInstance().subtracao(num1, num2);
                lblEquacao.setText(" ");
                lblResultado.setText(String.valueOf(resultado));
            }
            
            num1 = resultado;
            num2 = 0;
        }
        window.doLayout();
        window.repaint();
    }
}
