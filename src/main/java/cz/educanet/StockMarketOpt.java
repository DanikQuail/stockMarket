package cz.educanet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class StockMarketOpt {

    String ticker;
    String name;
    int id;

    public List<StockMarket> getMarkets() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stock_market?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM stock_market")
        ) {
            ArrayList<StockMarket> stockMarkets = new ArrayList<>();

            while (resultSet.next()) {
                stockMarkets.add(new StockMarket(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
            return stockMarkets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createMarket(String ticker, String name){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stock_market?user=root&password=");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO stock_market (ticker_symbol, descriptive_name) VALUES (?, ?)"
            );

            preparedStatement.setString(1, ticker);
            preparedStatement.setString(2, name);

            preparedStatement.execute();

            preparedStatement.close();
            this.ticker = "";
            this.name = "";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editMarket(int id, String ticker, String name){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stock_market?user=root&password=");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE stock_market SET ticker_symbol = ?, descriptive_name = ? WHERE stock_market_id = ? "

            );

            preparedStatement.setString(1, ticker);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, id);

            preparedStatement.execute();

            preparedStatement.close();

            this.id = 0;
            this.name = "";
            this.ticker = "";


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMarket(int id){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stock_market?user=root&password=");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM stock_market WHERE stock_market_id = ?"
            );

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
