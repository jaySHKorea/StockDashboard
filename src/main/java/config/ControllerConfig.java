package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.BoardController;
import db.StockLoad;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private StockLoad stockLoad;
	
	@Bean
	public BoardController boardController() {
		BoardController controller = new BoardController();
		controller.setStockLoad(stockLoad);
		return controller;
	}
}
