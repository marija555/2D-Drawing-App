package command.commands;

import command.Command;
import geometry.Shape;
import mvc.DrawingModel;

public class ToBack implements  Command {

	DrawingModel model;
	Shape shape;
	int index;
	String nameString;

	public ToBack(DrawingModel model, Shape shape, int index, String nameString) {
		this.model = model;
		this.shape = shape;
		this.index = index;
		this.nameString = nameString;
	}

	@Override
	public void execute() {
		index--;
		if (index >= 0) {
			model.getShapes().remove(shape);
			model.getShapes().add(index, shape);
		}
	}

	@Override
	public void unexecute() {
		index++;
		model.getShapes().remove(shape);
		model.getShapes().add(index, shape);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nameString;
	}

}