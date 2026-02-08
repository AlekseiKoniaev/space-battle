package ru.koniaev.server.physic;

public record Angle(int direction) {

	public static final int DIRECTIONS_COUNT = 360;

	public static Angle plus(Angle left, Angle right) {
		return new Angle(left.direction + right.direction);
	}


	public Angle plus(Angle angle) {
		return Angle.plus(this, angle);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Angle angle)) return false;

		return direction == angle.direction;
	}

	@Override
	public int hashCode() {
		return direction;
	}
}
