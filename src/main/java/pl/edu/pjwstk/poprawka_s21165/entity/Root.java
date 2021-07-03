package pl.edu.pjwstk.poprawka_s21165.entity;

/* aby uzyskac api w json dodajemy na koncu /?forrmat=json    https://api.nbp.pl/api/exchangerates/rates/a/USD/2012-01-01/2012-01-05/?format=json */

import java.util.List;

public class Root{
    public String table;
    public String currency;
    public String code;
    public List<Rate> rates;

    public Root() {
    }

    public Root(String table, String currency, String code, List<Rate> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
