package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class JRadioButtonPersonalizado extends JRadioButton implements Icon{

    private final int size = 16;
    private final Color fillColor;
    private final Color borderColor;

    public JRadioButtonPersonalizado(Color fillColor, Color borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.setIcon(this);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(borderColor);
        g2.drawArc(x, y, size, size, size * 24, size * 24);

        if (((AbstractButton) c).isSelected()) {
            g2.setColor(fillColor);
            g2.fillOval(x + 4, y + 4, size - 8, size - 8);
        }
    }

    @Override
    public int getIconWidth() {
        return size;
    }

    @Override
    public int getIconHeight() {
        return size;
    }
	    
}
