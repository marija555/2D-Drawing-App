package command.commands;


import command.Command;
import geometry.Shape;
import observer.SelectedObjects;

public class Select implements Command {

	Shape shape;
	String nameString;
	SelectedObjects selectedObjects;
	
	
	public Select(Shape shape, SelectedObjects selectedObjects, String nameString) {
		this.shape = shape;
		this.selectedObjects = selectedObjects;
		this.nameString = nameString;
	}
	
	@Override
	public void execute() {
		shape.setSelected(true);
		selectedObjects.add(shape);
	}

	@Override
	public void unexecute() {
		shape.setSelected(false);
		selectedObjects.remove(shape);
	}

	@Override
	public String getName() {
		return nameString;
	}

}