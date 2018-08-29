package br.facet.natan.barbosa.calc.control;

import br.facet.natan.barbosa.calc.model.Calculadora;
import br.facet.natan.barbosa.calc.model.ICalculadora;
import br.facet.natan.barbosa.calc.view.MainWindow;

public class MainControl
{
    private static MainControl control;
    private static MainWindow window;
    private static ICalculadora calculadora;
    
    public double multiplicacao(double n1, double n2)
    {
        return calculadora.multiplicacao(n1, n2);
    }
    
    public double divisao(double n1, double n2)
    {
        return calculadora.divisao(n1, n2);
    }
    
    public double soma(double n1, double n2)
    {
        return calculadora.soma(n1, n2);
    }
    
    public double subtracao(double n1, double n2)
    {
        return calculadora.subtracao(n1, n2);
    }
    
    public static void main(String[] args)
    {
        control = new MainControl();
        window = new MainWindow();
        
        window.setVisible(true);
        
    }
}
