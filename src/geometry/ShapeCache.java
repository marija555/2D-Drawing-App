package geometry;

import java.util.Hashtable;



public class ShapeCache {

	private static Hashtable<String, Shape> map = new Hashtable<String, Shape>();

	 public static Shape getShape(String shapeId) {
	      Shape cachedShape = map.get(shapeId);
	      return (Shape) cachedShape.clone();
	   }


	   public static void loadCache() {
		   //
	   }

}