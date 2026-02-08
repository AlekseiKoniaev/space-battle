package ru.koniaev.server.action.move;

import ru.koniaev.server.action.ICommand;

public class Move implements ICommand {
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
