package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class JPanelPersonalizado extends JPanel{

    private int arcoComprimento;
    private int arcoAltura;
    private Color cor1;
    private Color cor2;
    private Color inicioCor1;
    private Color inicioCor2;
    private Color fimCor1;
    private Color fimCor2;
    private int passos = 40;
    private int passoAtual = 0;
    private Timer timer;

    public JPanelPersonalizado(int arcoComprimento, int arcoAltura, Color cor1, Color cor2, boolean efeitoTransicao) {
        this.arcoComprimento = arcoComprimento;
        this.arcoAltura = arcoAltura;
        this.cor1 = cor1;
        this.cor2 = cor2;
        this.inicioCor1 = cor1;
        this.inicioCor2 = cor2;
        this.fimCor1 = cor2;
        this.fimCor2 = cor1;
        setOpaque(false);

        if(efeitoTransicao) {
        	timer = new Timer(50, new ActionListener() {
        		@Override
        		public void actionPerformed(ActionEvent e) {
        			if (passoAtual < passos) {
        				JPanelPersonalizado.this.cor1 = interpolateColor(inicioCor1, fimCor1, (float) passoAtual / passos);
        				JPanelPersonalizado.this.cor2 = interpolateColor(inicioCor2, fimCor2, (float) passoAtual / passos);
        				passoAtual++;
        				repaint();
        			} else {
        				passoAtual = 0;
        				Color temp1 = inicioCor1;
        				Color temp2 = inicioCor2;
        				inicioCor1 = fimCor1;
        				inicioCor2 = fimCor2;
        				fimCor1 = temp1;
        				fimCor2 = temp2;
        			}
        		}
        	});
        	timer.start();
        }
    }

    private Color interpolateColor(Color comeco, Color fim, float fracao) {
        int vermelho = (int) (comeco.getRed() + (fim.getRed() - comeco.getRed()) * fracao);
        int verde = (int) (comeco.getGreen() + (fim.getGreen() - comeco.getGreen()) * fracao);
        int azul = (int) (comeco.getBlue() + (fim.getBlue() - comeco.getBlue()) * fracao);
        return new Color(vermelho, verde, azul);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        GradientPaint gp = new GradientPaint(0, 0, cor1, width, height, cor2);
        g2d.setPaint(gp);
        g2d.fill(new RoundRectangle2D.Double(0, 0, width, height, arcoComprimento, arcoAltura));
        
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(null);
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcoComprimento, arcoAltura));
    }
}
