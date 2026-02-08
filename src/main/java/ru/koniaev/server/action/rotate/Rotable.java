package ru.koniaev.server.action.rotate;

import ru.koniaev.server.physic.Angle;

public interface Rotable {
	Angle getAngle();
	Angle getAngularVelocity();
	void setAngle(Angle angle);
}
