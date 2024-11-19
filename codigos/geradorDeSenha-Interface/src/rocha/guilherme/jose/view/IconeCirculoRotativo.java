package rocha.guilherme.jose.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class IconeCirculoRotativo extends JPanel{

	 private int angulo = 0;

	    public IconeCirculoRotativo() {
	        Timer timer = new Timer(50, e -> {
	            angulo += 10;
	            if (angulo >= 360) angulo = 0;
	            repaint();
	        });
	        timer.start();
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;

	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setColor(Color.WHITE);
	        g2d.setStroke(new BasicStroke(5));

	        g2d.drawArc(10, 10, getWidth() - 20, getHeight() - 20, angulo, 270);
	    }
}
