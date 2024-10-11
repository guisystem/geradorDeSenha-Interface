package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class JTableHeaderPersonalizado extends DefaultTableCellRenderer{

	private Color color1;
	private Color color2;
	private int x;
	private int widthCell;
	
	public JTableHeaderPersonalizado(Color cor1, Color cor2) {
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(Color.WHITE);
		setOpaque(false);
		this.color1 = cor1;
		this.color2 = cor2;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Rectangle celula = table.getCellRect(row, column, true);
		componente.setFont(new Font("Arial", Font.PLAIN, 20));
		
		x =- celula.x;
		widthCell = table.getWidth() - celula.x;
		return componente;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		int width = getWidth();
		int height = getHeight();
		GradientPaint gp = new GradientPaint(x, 0, color2, widthCell, 0, color1);		
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, width, height);
		g2d.dispose();
		super.paintComponent(g);
	}
		
}
