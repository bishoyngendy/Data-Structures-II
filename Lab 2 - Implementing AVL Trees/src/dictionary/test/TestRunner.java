package dictionary.test;

import dictionary.*;

public class TestRunner {

	public static IAVLTree getImplementationInstance() {
		return new AVLTree();
	}

	public static IDictionary getDicImplementationInstance() {
		return new Dictionary();
	}

}
