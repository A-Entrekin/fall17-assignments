
public class ASCIIDrawer {
	public static void drawCircle(int radius) {
		double rsq = radius * radius;
		for (int i = -radius; i <= radius; i++) {
			for (int j= -radius; j <= radius; j++) {
				double ij = i * i +  j * j;
				if (Math.abs(ij - rsq) <= radius) System.out.print("**");
				else System.out.print("  ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		drawCircle(15);
	}
}
