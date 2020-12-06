package MavenTutorial.TestMaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrivenExcel {

	@SuppressWarnings("deprecation")
	public ArrayList<String> getData(String testcaseName) {
		ArrayList<String> a = new ArrayList<String>();
		try {

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\OPTLPTP289\\Desktop\\New folder (2)\\TestMaven\\resources\\InformationExcel.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheetsCount = workbook.getNumberOfSheets();
			System.out.println(sheetsCount);
			for (int i = 0; i < sheetsCount; i++) {
				if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
					XSSFSheet sheet = workbook.getSheetAt(i);
					Iterator<Row> rows = sheet.iterator();
					Row firstRow = rows.next();
					Iterator<Cell> columns = firstRow.cellIterator();
					int k = 0;
					int column = 0;
					while (columns.hasNext()) {
						Cell value = columns.next();
						if (value.getStringCellValue().equalsIgnoreCase(testcaseName)) {
							column = k;
						}
						k++;
					}
					System.out.println(column);
					while (rows.hasNext()) {
						Row r = rows.next();
						if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
							Iterator<Cell> cv = r.cellIterator();
							while (cv.hasNext()) {
								Cell c = cv.next();
								if (c.getCellType() == CellType.STRING) {
									a.add(c.getStringCellValue());
								} else {
									a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

								}

								// a.add(cv.next().getStringCellValue());
							}
						}

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;

	}

	public static void main(String[] args) throws IOException {

	}

}
