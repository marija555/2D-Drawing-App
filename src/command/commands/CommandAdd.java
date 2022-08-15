package command.commands;

import command.Command;
import geometry.Shape;
import mvc.DrawingModel;

public class CommandAdd  implements Command {

	
	private Shape shape;
	private DrawingModel model;
	private String nameString;

	
	public CommandAdd(DrawingModel model, Shape shape, String nameString) {
		this.model = model;
		this.shape = shape;
		this.nameString = nameString;
	}

	@Override
	public void execute() {
		model.add(shape);
	}

	@Override
	public void unexecute() {
		model.remove(shape);
	}

	@Override
	public String getName() {
		return nameString;
	}

}