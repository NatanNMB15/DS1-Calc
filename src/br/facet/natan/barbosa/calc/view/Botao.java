package br.facet.natan.barbosa.calc.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Botao extends JButton
{
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
                MainWindow.getInstance().atualizarResultado(s);
            }
        });
    }
}
