package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JPasswordFieldPersonalizado extends JPasswordField{

	private int arcoComprimento;
    private int arcoAltura;
    private Color background;

    public JPasswordFieldPersonalizado(int arcoComprimento, int arcoAltura, Color background) {
        this.arcoComprimento = arcoComprimento;
        this.arcoAltura = arcoAltura;
        this.background = background;
        setOpaque(false);
        setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (background != null) {
            g2.setColor(background);
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcoComprimento, arcoAltura));
        }

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.WHITE);
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcoComprimento, arcoAltura));

        g2.dispose();
    }
}
