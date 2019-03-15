package aufgabeZwei;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MainTest {

	@Test
	public void testGetOptimalValue() {
		Flear f1 = new Flear("f1", 10, 10); // 1
		Flear f2 = new Flear("f2", 1, 10); // 10
		Flear f3 = new Flear("f3", 5, 10); // 2
		Flear f4 = new Flear("f4", 10, 1); // 0,1
		Flear f5 = new Flear("f5", 1, 1); // 1
		Flear f6 = new Flear("f6", 5, 1); // 0,2
		Flear f7 = new Flear("f7", 10, 5); // 0,5
		Flear f8 = new Flear("f8", 1, 5); // 5
		Flear f9 = new Flear("f9", 5, 5); // 1
		Flear f10 = new Flear("f10", 30, 9); // 0,3

		List<Flear> list = new ArrayList<>();
		list.add(f10);
		list.add(f9);
		list.add(f8);
		list.add(f7);
		list.add(f6);
		list.add(f5);
		list.add(f4);
		list.add(f3);
		list.add(f2);
		list.add(f1);

		int erg = Main.getOptimalValue(26, list);

		// fail("Not yet implemented");
		assertTrue(erg + " ist nicht gleich 6!", erg == 6);
	}

}
