package command.commands;

import command.Command;
import geometry.Point;
import mvc.DrawingModel;
import observer.SelectedObjects;

public class PointModify implements Command {

	
	private Point original = new Point();
	private Point oldState;
	private Point newState;
	private DrawingModel model;
	private int index;
	private String nameString;
	private SelectedObjects selectedObjects;
	
	public PointModify(DrawingModel model, Point oldState, Point newState, int index, String nameString, SelectedObjects selectedObjects) {
		this.oldState = oldState;
		this.newState = newState;
		this.nameString = nameString;
		this.model = model;
		this.index = index;
		this.selectedObjects = selectedObjects;
	}

	@Override
	public void execute() {
		original.setX(oldState.getX());
		original.setY(oldState.getY());
		original.setColor(oldState.getColor());

		oldState.setX(newState.getX());
		oldState.setY(newState.getY());
		oldState.setColor(newState.getColor());
		selectedObjects.remove(oldState);
		selectedObjects.add(newState);
		model.remove(oldState);
		model.getShapes().add(index, newState);
	}

	@Override
	public void unexecute() {
		oldState.setX(original.getX());
		oldState.setY(original.getY());
		oldState.setColor(original.getColor());
		
		selectedObjects.remove(newState);
		selectedObjects.add(oldState);
		model.remove(newState);
		model.getShapes().add(index, oldState);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nameString;
	}

}