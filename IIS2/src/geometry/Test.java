package geometry;

public class Test {

	public static void main(String[] args) {

		Point p = new Point();
		p.setX(10);
		p.setY(20);
		p.setSelected(true);
		
		System.out.println("X coordinate of point p is: " + p.getX() + '\n' +
				"Y coordinate of point p is: " + p.getY() + '\n' +
				"Point p is selected: " + p.isSelected());

		double result = p.distance(56, 87);
		System.out.println("Distance between points is: " + result);
		
		Point p1 = new Point();
		p1.setX(18);
		p1.setY(30);
		
		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1

		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a
		// za krajnju tacku linije l1 tacku p1

		// 3. Postaviti y koordinatu krajnje tacke l1 na 23

		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1

		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije

		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15

		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1

		// 8. Postaviti x koordinatu centra kruga na vrednost razlike
		// povrsine pravougaonika i y koordinate pocetne tacke linije l1
		
	}

}
