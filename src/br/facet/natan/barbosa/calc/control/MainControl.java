package br.facet.natan.barbosa.calc.control;

import br.facet.natan.barbosa.calc.model.Calculadora;
import br.facet.natan.barbosa.calc.model.ICalculadora;
import br.facet.natan.barbosa.calc.view.IMainWindow;
import br.facet.natan.barbosa.calc.view.MainWindow;

public class MainControl implements IMainControl
{
    private static MainControl control;
    public static IMainWindow window;
    private static ICalculadora calculadora;
    
    
    
    @Override
    public double multiplicacao(double n1, double n2)
    {
        return calculadora.multiplicacao(n1, n2);
    }
    
    @Override
    public double divisao(double n1, double n2)
    {
        return calculadora.divisao(n1, n2);
    }
    
    @Override
    public double soma(double n1, double n2)
    {
        return calculadora.soma(n1, n2);
    }
    
    @Override
    public double subtracao(double n1, double n2)
    {
        return calculadora.subtracao(n1, n2);
    }
    
    @Override
    public void atualizarResultado(String s)
    {
        window.atualizarResultado(s);
    }
    
    public static void main(String[] args)
    {
        control = new MainControl();
        calculadora = new Calculadora();
        window = new MainWindow();
        window.carregarJanela();
        
    }
}
