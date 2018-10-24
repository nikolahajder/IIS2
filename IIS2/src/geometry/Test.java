package geometry;

public class Test {

	public static void main(String[] args) {

		Point p = new Point();
		p.setX(10);
		p.setY(20);
		p.setSelected(true);
		
		System.out.println("X coordinate of point p is: " + p.getX() + '\n' +
				"Y coordinate of point p is: " + p.getY() + '\n' +
				"Point p is selected: " + p.getSelected());

		double result = p.distance(56, 87);
		System.out.println("Distance between points is: " + result);
		
	}

}
