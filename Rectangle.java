/**
 * 
 */

/**
 * @author milenjohn
 *
 */
public class Rectangle {
	public String name;
	public int x;
	public int y;
	public int width;
	public int height;

	public Rectangle(String names, int xCord, int yCord, int widths, int heights) {
		names = name;
		xCord = x;
		yCord = y;
		widths = width;
		heights = height;
	}

	public boolean intersects(Rectangle r) {
		boolean bool = ((Math.abs(r.x - x) < (r.width - width)) && 
				Math.abs(r.y - y) < (r.height - height));
		return bool;
	}

	public String toString() {
		return name + ", " + x + ", " + y + ", " + width + ", " + height;
	}
}
