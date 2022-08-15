package command.commands;
import command.Command;
import geometry.Shape;
import mvc.DrawingModel;

public class BringToFront implements Command {

	DrawingModel model;
	Shape shape;
	int index;
	int length;
	int indexSave;
	String nameString;

	public BringToFront(DrawingModel model, Shape shape, int index, int length,String nameString) {
		this.model = model;
		this.shape = shape;
		this.index = index;
		this.length = length;
		this.nameString = nameString;
	}

	@Override
	public void execute() {
		indexSave = model.getShapes().indexOf(shape);
		if (index < length) {
			model.getShapes().remove(shape);
			model.getShapes().add(shape);
		}
	}

	@Override
	public void unexecute() {
		model.getShapes().remove(shape);
		model.getShapes().add(indexSave, shape);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nameString;
	}

}
