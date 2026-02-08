package ru.koniaev.server.physic;

public record Vector(int x, int y) {

	public static Vector copy(Vector v) {
		return new Vector(v.x(), v.y());
	}

	public static Vector plus(Vector left, Vector right) {
		return new Vector(
				left.x + right.x,
				left.y + right.y
		);
	}

	public static Vector minus(Vector left, Vector right) {
		return new Vector(
				left.x - right.x,
				left.y - right.y
		);
	}


	public Vector plus(Vector right) {
		return Vector.plus(this, right);
	}


	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Vector vector)) return false;

		return x == vector.x && y == vector.y;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}
}
