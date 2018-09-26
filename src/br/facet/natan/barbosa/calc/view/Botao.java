package br.facet.natan.barbosa.calc.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import br.facet.natan.barbosa.calc.control.IMainControl;
import br.facet.natan.barbosa.calc.control.MainControl;

/**
 * Uma classe como construtor de botões com evento pré-definido para atualizar a interface do View.
 * 
 * @author Natan Barbosa
 */
public class Botao extends JButton
{   
    IMainControl control;
    
    public Botao(String s)
    {
        setBorder(null);
        setMargin(new Insets(0,0,0,0));
        setMinimumSize(new Dimension(85, 35));
        setText(s);
        
        addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                atualizarResultado(s);
            }
        });
    }
    
    private void atualizarResultado(String s)
    {
        if(control == null)
        {
            control = new MainControl();
        }
        
        control.atualizarResultado(s);
    }
}
