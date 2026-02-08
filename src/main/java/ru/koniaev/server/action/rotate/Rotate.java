package ru.koniaev.server.action.rotate;

import ru.koniaev.server.action.IAction;

public class Rotate implements IAction {
	private final Rotable rotable;

	public Rotate(Rotable rotable) {
		this.rotable = rotable;
	}

	@Override
	public void execute() {
		rotable.setAngle(
				rotable.getAngle().plus(rotable.getAngularVelocity())
		);
	}
}
