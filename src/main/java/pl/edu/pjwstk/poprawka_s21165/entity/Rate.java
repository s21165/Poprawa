package pl.edu.pjwstk.poprawka_s21165.entity;


/* piersze klasy ktore tworzymy, wiemy jakie maja miec konstruktory poprzez transformacje json to pojo link:https://json2csharp.com/json-to-pojo?fbclid=IwAR18wGu4bkJJoyYO_1z_srqb1ARu5oJFXyCh_mxFAek3A4TaKvE5Rvyw6hU */

public class Rate {
    public String no;
    public String effectiveDate;
    public double mid;

    public Rate() {
    }

    public Rate(String no, String effectiveDate, double mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }
}
