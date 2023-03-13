package hcp.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("application.properties")
@ComponentScan ("hcp")
public class Config {
}
