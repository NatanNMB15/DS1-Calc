package br.facet.natan.barbosa.calc.control;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JLabel;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.io.FileHandler;
import br.facet.natan.barbosa.calc.model.Calculadora;
import br.facet.natan.barbosa.calc.model.ICalculadora;
import br.facet.natan.barbosa.calc.view.IMainWindow;
import br.facet.natan.barbosa.calc.view.MainWindow;

/**
 * Uma classe para controlar todas as conexões entre o Model e View.
 * 
 * @author Natan Barbosa
 */

public class MainControl implements IMainControl
{
    private static IMainControl control;
    private static IMainWindow window;
    private static ICalculadora calculadora;
    
    @Override
    public void enviarOperacao(ArrayList<String> equacao, ArrayList<String> numeros)
    {
        String resultado = calculadora.realizarOperacao(equacao, numeros);
        control.resultadoFinal(resultado);
    }
    
    @Override
    public void resultadoFinal(String s)
    {
        window.resultadoFinal(s);
    }

    @Override
    public void atualizarResultado(String s)
    {
        window.atualizarResultado(s);
    }
    
    @Override
    public void carregarConfig()
    {
        try
        {
            File file = new File("DS1Calculadora-results.xml");
            //
            //
            if(file.exists())
            {
                Configurations configs = new Configurations();
                XMLConfiguration config = configs.xml(file);
                //
                //
                
                ArrayList<String> equacao = (ArrayList<String>) config.getList(String.class, "calculadora.Equacao.operador", null);
                ArrayList<String> numeros = (ArrayList<String>) config.getList(String.class, "calculadora.Numeros.num", null);
                String strEquacao = config.getString("calculadora.lblEquacao");
                String strResultado = config.getString("calculadora.lblResultado");
                int indexNumeros = config.getInt("calculadora.indexNumeros");
                boolean operacao = config.getBoolean("calculadora.operacao");
                
                window.carregarConfig(equacao, numeros, strEquacao, strResultado, indexNumeros, operacao);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void salvarConfig(ArrayList<String> equacao, ArrayList<String> numeros, JLabel lblEquacao, JLabel lblResultado, int indexNumeros, boolean operacao)
    {
        try
        {
            File file = new File("DS1Calculadora-results.xml");
            file.createNewFile();
            //
            //
            XMLConfiguration config = new XMLConfiguration();
            //
            ////// Config Fibonacci
            if(equacao != null)
            {
                config.addProperty("calculadora.Equacao.operador", equacao); // Salva o ArrayList equacao
            }
            if(numeros != null)
            {
                config.addProperty("calculadora.Numeros.num", numeros); // Salva o ArrayList numeros
            }
            config.addProperty("calculadora.lblEquacao", lblEquacao.getText()); // Salva o ArrayList equacao
            config.addProperty("calculadora.lblResultado", lblResultado.getText()); // Salva o ArrayList numeros
            config.addProperty("calculadora.indexNumeros", indexNumeros); // Salva o índice de números do ArrayList numeros
            config.addProperty("calculadora.operacao", operacao); // Salva o estado da variável operacao
            //
            //
            FileHandler handler = new FileHandler(config);
            handler.save(file);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void carregarJanela()
    {
        window.carregarJanela();
    }
    
    /**
     * Função para iniciar o programa e as interfaces de conexão.
     * @param args
     */
    public static void main(String[] args)
    {
        control = new MainControl();
        calculadora = new Calculadora();
        window = new MainWindow();
        
        control.carregarJanela();
        control.carregarConfig();
    }
}
