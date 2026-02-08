package ru.koniaev.server.action.move;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.koniaev.server.physic.Vector;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

	static class TestMovable implements Movable {
		private Vector position;
		private final Vector velocity;

		TestMovable(Vector position, Vector velocity) {
			this.position = position;
			this.velocity = velocity;
		}

		@Override
		public Vector getPosition() {
			return position;
		}

		@Override
		public Vector getVelocity() {
			return velocity;
		}

		@Override
		public void setPosition(Vector position) {
			this.position = position;
		}
	}

	static class TestNonMovable implements Movable {
		private final Vector position;
		private final Vector velocity;

		TestNonMovable(Vector position, Vector velocity) {
			this.position = position;
			this.velocity = velocity;
		}

		@Override
		public Vector getPosition() {
			return position;
		}

		@Override
		public Vector getVelocity() {
			return velocity;
		}

		@Override
		public void setPosition(Vector position) {
			throw new UnsupportedOperationException("Position change is not supported.");
		}
	}


	@Test
	void move_normalMovable() {
		Movable movable = new TestMovable(
				new Vector(12, 5),
				new Vector(-7, 3)
		);

		new Move(movable).execute();

		assertEquals(new Vector(5, 8), movable.getPosition());
	}

	@Test
	void move_movableWithNullPosition() {
		Movable movable = new TestMovable(
				null,
				new Vector(1, 1)
		);

		Executable executable = () -> new Move(movable).execute();

		assertThrows(NullPointerException.class, executable);
	}

	@Test
	void move_movableWithNullVelocity() {
		Movable movable = new TestMovable(
				new Vector(1, 1),
				null
		);

		Executable executable = () -> new Move(movable).execute();

		assertThrows(NullPointerException.class, executable);
	}

	@Test
	void move_nonMovable() {
		Movable movable = new TestNonMovable(
				new Vector(0, 0),
				new Vector(0, 0)
		);

		Executable executable = () -> new Move(movable).execute();

		assertThrows(UnsupportedOperationException.class, executable);
	}

}