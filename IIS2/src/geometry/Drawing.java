package geometry;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		
		Point p = new Point(150, 150, true);
		p.draw(g);
		
		Line l = new Line(new Point(200, 350), new Point(400, 300), true);
		l.draw(g);
		
		Rectangle r = new Rectangle(new Point(450, 80), 60, 120, true);
		r.draw(g);
		
		Circle c = new Circle(new Point(500, 450), 50, true);
		c.draw(g);
		
		Donut d = new Donut(new Point(600, 350), 80, 50, true);
		d.draw(g);
	}

}
