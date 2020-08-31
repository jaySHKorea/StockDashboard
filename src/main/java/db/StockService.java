package db;

// MemberRegisterService와 같은 역할
public class StockService {
	private StockDao stockDao;

	public StockService(StockDao stockDao) {
		this.stockDao = stockDao;
	}
}
