package test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class Testing {
    public static AppiumDriver driver;
    public static DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeClass
    public void setUp() throws Exception {
        //aapt 명령어를 통해 입력 할 예정(테스트 할 앱의 패키지 명)
        capabilities.setCapability("appPackage", "com.google.android.calculator");

        //aapt 명령어를 통해 입력 할 예정(테스트 할 앱의 launchable-activity 정보)
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        //자신의 디바이스 명을 설정. 아무 이름이나 적어도 괜찮습니다.
        capabilities.setCapability("deviceName", "devices");

        //adb 명령어를 통해 입력 할 예정(자기 디바이스의 udid)
        capabilities.setCapability("udid", "emulator-5554");

        //크게 신경 안써도 되는 문구
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void Test1() throws Exception {

        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"1\"]")).click();
//        driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
//        driver.findElement(By.xpath("//android.widget.Button[@text='3']")).click();
//        driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void end() throws Exception {
        driver.quit();
    }
}
