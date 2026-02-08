package ru.koniaev.server.action.move;

import ru.koniaev.server.action.IAction;

public class Move implements IAction {
	private final Movable movable;

	public Move(Movable movable) {
		this.movable = movable;
	}

	@Override
	public void execute() {
		movable.setPosition(
				movable.getPosition().plus(movable.getVelocity())
		);
	}
}
