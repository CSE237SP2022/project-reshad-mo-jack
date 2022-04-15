package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Input;

class InputTest {
	private Input input;

	@BeforeEach
	public void setup() {
		input = new Input();
	}
	
	@Test
	public void testInputConstructor() {
		assertNotNull(input.scanner);
	}

}
