package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class JTablePersonalizado extends DefaultTableCellRenderer{

	Color color1;
	Color color2;
	private int x;
	private int widthCell;
	private boolean isSelect;
	private int row;

	public JTablePersonalizado(Color color1, Color color2) {
		setHorizontalAlignment(SwingConstants.CENTER);
		setForeground(Color.WHITE);
		this.color1 = color1;
		this.color2 = color2;
		setOpaque(false);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Rectangle cellRec = table.getCellRect(row, column, true);
		x =- cellRec.x;
		widthCell = table.getWidth()-cellRec.x;
		this.isSelect = isSelected;
		this.row = row;
		return com;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		int width = getWidth();
		int height = getHeight();
		GradientPaint gp;
		Color corIsSelect1 = Color.decode("#2C3E50");
		Color corIsSelect2 = Color.decode("#4CA1AF");
		
		if(row % 2 == 0){
			if(isSelect) {
				gp = new GradientPaint(x, 0, corIsSelect1, widthCell, 0, corIsSelect2);		
			}else {
				gp = new GradientPaint(x, 0, color2, widthCell, 0, color1);		
			}
			
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, width, height);
			
		}else {
			if(isSelect) {
				gp = new GradientPaint(x, 0, corIsSelect1, widthCell, 0, corIsSelect2);			
			}else {
				gp = new GradientPaint(x, 0, color1, widthCell, 0, color2);		
			}
			
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, width, height);
					
		}
		
		setForeground(Color.WHITE);
		g2d.dispose();
		super.paintComponent(g);
	}
	
}
