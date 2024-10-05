package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class JTextFieldPersonalizado extends JTextField{

	private int arcoComprimento;
    private int arcoAltura;
    private Color background;

    public JTextFieldPersonalizado(int arcoComprimento, int arcoAltura, Color background) {
        this.arcoComprimento = arcoComprimento;
        this.arcoAltura = arcoAltura;
        this.background = background;
        setOpaque(false);
        setBorder(new EmptyBorder(5, 10, 5, 10));
    }
    
    public void soNumeros() {
    	setDocument(criarRestricao());
    }
    
    private Document criarRestricao() {
    	return new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                
                if (str.matches("[0-9]*")) {
                    super.insertString(offset, str, attr);
                }
            }
        };
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
