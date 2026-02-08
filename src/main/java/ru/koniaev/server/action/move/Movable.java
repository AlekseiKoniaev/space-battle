package ru.koniaev.server.action.move;

import ru.koniaev.server.physic.Vector;

public interface Movable {
	Vector getPosition();
	Vector getVelocity();
	void setPosition(Vector position);
}
