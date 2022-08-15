package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private Color color;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Point() {

	}

	public Point(int x, int y) {
		try {
			setX(x);
			setY(y);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public Point(int x, int y, boolean selected) {
		this(x, y);
		setSelected(selected);
	}

	public Point(int x, int y, Color color) {
		this(x, y);
		this.color = color;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(this.x - 10, y, this.x + 10, y);
		g.drawLine(x, this.y - 10, x, this.y + 10);
		g.setColor(new Color(0, 0, 0));
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getX() - 10, this.y - 10, 20, 20);
			g.setColor(Color.BLACK);
		}
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y += byY;

	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Point) {
			Point start = new Point(0, 0);
			return (int) (this.distance(start.getX(), start.getY()) - ((Point) o).distance(start.getX(), start.getY()));
		}
		return 0;
	}

	public boolean contains(int x, int y) {
		if (this.distance(x, y) <= 10)
			return true;
		return false;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			if (this.x == p.getX() && this.y == p.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		String x = String.valueOf(getX());
		String y = String.valueOf(getY());
		return "x," + x + ",y," + y;
	}


}