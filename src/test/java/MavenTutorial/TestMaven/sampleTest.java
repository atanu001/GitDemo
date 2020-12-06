package MavenTutorial.TestMaven;

import java.util.ArrayList;

public class sampleTest {

	public static void main(String[] args) {
		dataDrivenExcel data = new dataDrivenExcel();
		ArrayList dta = data.getData("Mijan");
		System.out.println(dta.get(0));
		System.out.println(dta.get(1));
		System.out.println(dta.get(2));
		System.out.println(dta.get(3));

	}

}
