package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.BoardController;

@Configuration
public class ControllerConfig {
	
	@Bean
	public BoardController boardController() {
		BoardController controller = new BoardController();
		return controller;
	}
}
