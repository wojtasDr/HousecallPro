package hcp.springconfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.time.Duration;

@Configuration
public class ChromeWebDriverFactory {
    @Value("${chrome.driver.location}")
    String chromeDriverLocation;

    @Bean
    @Profile("chrome")
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", new File(chromeDriverLocation).getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }
}
