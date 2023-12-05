package utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import test.BaseTest;
import test.Login;

public class ReadXLSdata extends BaseTest {

	Login log = new Login();
	WebDriver driver;
	List<String> excelDataList = new ArrayList<String>();

	public ReadXLSdata(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getData() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(2000);
		File f = new File(getRecentFilePath());
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheetAt(0);

		int totalRows = sheetName.getLastRowNum();
		for (int i = 2; i <= totalRows; i++) {
			int totalColumn = sheetName.getRow(i).getLastCellNum();
			for (int j = 0; j < totalColumn; j++) {

				if (sheetName.getRow(i).getCell(j).getCellType() == CellType.STRING) {

					excelDataList.add(sheetName.getRow(i).getCell(j).getStringCellValue());
				} else {
					double cellData = (int) sheetName.getRow(i).getCell(j).getNumericCellValue();
					excelDataList.add(String.valueOf(cellData));
				}
			}
		}
		return excelDataList;
	}
	
	public String getPDFData() throws IOException, InterruptedException{
		Thread.sleep(2000);
		driver.get("file:///" + getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);	
		String content = new PDFTextStripper().getText(document);
		document.close();
		return content;
	}

	public String getRecentFilePath() {
		File mostRecent = null;

		String downloadDirectory = System.getProperty("user.home") + "/Downloads";

		Path parentFolder = Paths.get(downloadDirectory);

		Optional<File> mostRecentFileOrFolder = Arrays.stream(parentFolder.toFile().listFiles())
				.max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));
		Optional<File> mostRecentFile = Arrays.stream(parentFolder.toFile().listFiles()).filter(f -> f.isFile())
				.max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));
		Optional<File> mostRecentFolder = Arrays.stream(parentFolder.toFile().listFiles()).filter(f -> f.isDirectory())
				.max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));

		if (mostRecentFolder.isPresent()) {
			mostRecent = mostRecentFileOrFolder.get();
			System.out.println("downloaded file:"+mostRecent);
			return mostRecent.getPath();
		} else {

			return "folder is empty!";
		}

	}
}
