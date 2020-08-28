package db;

// MemberRegisterService와 같은 역할
public class StockLoad {
	private StockDao stockDao;

	public StockLoad(StockDao memberDao) {
		this.stockDao = memberDao;
	}
}
