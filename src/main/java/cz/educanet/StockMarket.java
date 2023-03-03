package cz.educanet;

public class StockMarket {
    private int stock_market_id;
    private String ticker_symbol;
    private String descriptive_name;

    public StockMarket(int stock_market_id, String ticker_symbol, String descriptive_name) {
        this.stock_market_id = stock_market_id;
        this.ticker_symbol = ticker_symbol;
        this.descriptive_name = descriptive_name;
    }

    public String getTicker_symbol() {
        return ticker_symbol;
    }

    public void setTicker_symbol(String ticker_symbol) {
        this.ticker_symbol = ticker_symbol;
    }

    public String getDescriptive_name() {
        return descriptive_name;
    }

    public void setDescriptive_name(String descriptive_name) {
        this.descriptive_name = descriptive_name;
    }

    public int getStock_market_id() {
        return stock_market_id;
    }

    public void setStock_market_id(int stock_market_id) {
        this.stock_market_id = stock_market_id;
    }
}
