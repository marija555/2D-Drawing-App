package mvc;

import geometry.Shape;

import java.util.ArrayList;


public class DrawingModel {

	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void add(Shape sh) {
        shapes.add(sh);
    }

    public void remove(Shape sh) {
        shapes.remove(sh);
    }

    public Shape get(int i) {
        return shapes.get(i);
    }

}