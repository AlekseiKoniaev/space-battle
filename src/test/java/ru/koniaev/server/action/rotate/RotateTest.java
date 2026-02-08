package ru.koniaev.server.action.rotate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.koniaev.server.physic.Angle;


import static org.junit.jupiter.api.Assertions.*;

class RotateTest {
	
	static class TestRotable implements Rotable {
		private Angle angle;
		private final Angle angularVelocity;

		public TestRotable(Angle angle, Angle angularVelocity) {
			this.angle = angle;
			this.angularVelocity = angularVelocity;
		}

		@Override
		public Angle getAngle() {
			return angle;
		}

		@Override
		public Angle getAngularVelocity() {
			return angularVelocity;
		}

		@Override
		public void setAngle(Angle angle) {
			this.angle = angle;
		}
	}

	static class TestNonRotable implements Rotable {
		private final Angle angle;
		private final Angle angularVelocity;

		public TestNonRotable(Angle angle, Angle angularVelocity) {
			this.angle = angle;
			this.angularVelocity = angularVelocity;
		}

		@Override
		public Angle getAngle() {
			return angle;
		}

		@Override
		public Angle getAngularVelocity() {
			return angularVelocity;
		}

		@Override
		public void setAngle(Angle angle) {
			throw new UnsupportedOperationException("Angle change is not supported.");
		}
	}


	@Test
	void rotate_normalRotable() {
		Rotable rotable = new TestRotable(
				new Angle(8),
				new Angle(7)
		);

		new Rotate(rotable).execute();

		assertEquals(new Angle(15), rotable.getAngle());
	}

	@Test
	void rotate_rotableWithNullAngle() {
		Rotable Rotable = new TestRotable(
				null,
				new Angle(1)
		);

		Executable executable = () -> new Rotate(Rotable).execute();

		assertThrows(NullPointerException.class, executable);
	}

	@Test
	void move_rotableWithNullAngularVelocity() {
		Rotable Rotable = new TestRotable(
				new Angle(1),
				null
		);

		Executable executable = () -> new Rotate(Rotable).execute();

		assertThrows(NullPointerException.class, executable);
	}

	@Test
	void move_nonRotable() {
		Rotable Rotable = new TestNonRotable(
				new Angle(8),
				new Angle(7)
		);

		Executable executable = () -> new Rotate(Rotable).execute();

		assertThrows(UnsupportedOperationException.class, executable);
	}
}