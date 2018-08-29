package br.facet.natan.barbosa.calc.control;

import br.facet.natan.barbosa.calc.model.Calculadora;
import br.facet.natan.barbosa.calc.view.MainWindow;

public class MainControl
{
    private static MainControl control;
    
    public static MainControl getInstance()
    {
        if(control == null)
        {
            control = new MainControl();
        }
        
        return control;
    }
    
    public double multiplicacao(double n1, double n2)
    {
        return Calculadora.getInstance().multiplicacao(n1, n2);
    }
    
    public double divisao(double n1, double n2)
    {
        return Calculadora.getInstance().divisao(n1, n2);
    }
    
    public double soma(double n1, double n2)
    {
        return Calculadora.getInstance().soma(n1, n2);
    }
    
    public double subtracao(double n1, double n2)
    {
        return Calculadora.getInstance().subtracao(n1, n2);
    }
    
    public static void main(String[] args)
    {
        MainWindow.getInstance().setVisible(true);
        control = new MainControl();
    }
}
