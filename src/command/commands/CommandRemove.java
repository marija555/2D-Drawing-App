package command.commands;

import command.Command;
import geometry.Shape;
import mvc.DrawingModel;
import observer.SelectedObjects;

public class CommandRemove  implements Command {

	
	private Shape shape;
	private DrawingModel model;
	private String nameString;
	private int index;
	private SelectedObjects selectedObjects;
	public CommandRemove(DrawingModel model, Shape shape, int index,String nameString, SelectedObjects selectedObjects) {
		
		this.model = model;
		this.shape = shape;
		this.index=index;
		this.nameString = nameString;
		this.selectedObjects = selectedObjects;
	}

	@Override
	public void execute() {
		selectedObjects.remove(shape);
		model.remove(shape);
	}

	@Override
	public void unexecute() {
		shape.setSelected(true);
		selectedObjects.add(shape);
		model.getShapes().add(index,  shape);
	}

	@Override
	public String getName() {
		return nameString;
	}

}