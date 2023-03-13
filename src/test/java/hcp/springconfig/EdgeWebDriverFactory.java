package hcp.springconfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.time.Duration;

@Configuration
public class EdgeWebDriverFactory {
    @Value("${edge.driver.location}")
    String edgeDriverLocation;

    @Bean
    @Profile("edge")
    public WebDriver getDriver() {
        System.setProperty("webdriver.edge.driver", new File(edgeDriverLocation).getAbsolutePath());
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }
}
