package commoms;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AbtractTest {
	private String projectFolder = System.getProperty("user.dir");
	private WebDriver driver;
	private String osName = System.getProperty("os.name");

	protected WebDriver getBrowserDriver(String browserName,String urlValues) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		if (browser == Browser.FIREFOX_UI) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser==Browser.CHROME_UI) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser==Browser.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		} else if (browser==Browser.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browser==Browser.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser==Browser.IE) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Please input valid browser name value");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(urlValues);
		return driver;
	}

	protected int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	private void setBrowserDriver() {
		if (isWindows()) {
			System.setProperty("webdriver.chrome.driver", projectFolder + getDirectorySlash("browerDriver") + "chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", projectFolder + getDirectorySlash("browerDriver") + "geckodriver.exe");
			System.setProperty("webdriver.edge.driver", projectFolder + getDirectorySlash("browerDriver") + "msedgedriver.exe");
		} else if (isMac()) {
			System.setProperty("webdriver.chrome.driver", projectFolder + getDirectorySlash("browerDriver") + "chromedriver_mac.exe");
			System.setProperty("webdriver.gecko.driver", projectFolder + getDirectorySlash("browerDriver") + "geckodriver_mac.exe");
			System.setProperty("webdriver.edge.driver", projectFolder + getDirectorySlash("browerDriver") + "msedgedriver_mac.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectFolder + getDirectorySlash("browerDriver") + "chromedriver_linux.exe");
			System.setProperty("webdriver.gecko.driver", projectFolder + getDirectorySlash("browerDriver") + "geckodriver_linux.exe");
			System.setProperty("webdriver.edge.driver", projectFolder + getDirectorySlash("browerDriver") + "msedgedriver_linux.exe");
		}
	}

	private String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else {
			folderName = "\\" + folderName + "\\";
		}
		return folderName;
	}

	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0);
	}

	private boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}

}
