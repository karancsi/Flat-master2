package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "expense", schema = "zsofidb")
public class ExpenseEntity {
    @javax.persistence.Id
    @Column(name = "idexpense")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idexpense;

    @Basic
    @Column(name = "idresidential")
    private int idresidential;

     @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "amount")
    private int amount;

    @Basic
    @Column(name = "paymentdate")
    private Date paymentdate;

    @Basic
    @Column(name = "success")
    private int success;

    public ExpenseEntity()
    {}

    public ExpenseEntity(int idexpense, int idresidential,  Date date, String description, int amount, Date paymentdate, int success) {
        this.idexpense = idexpense;
        this.idresidential = idresidential;

        this.date = date;
        this.description = description;
        this.amount = amount;
        this.paymentdate = paymentdate;
        this.success = success;
    }

    public int getIdexpense() {
        return idexpense;
    }

    public void setIdexpense(int idexpense) {
        this.idexpense = idexpense;
    }

    public int getIdresidential() {
        return idresidential;
    }

    public void setIdresidential(int idresidential) {
        this.idresidential = idresidential;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ExpenseEntity{" +
                "idexpense=" + idexpense +
                ", idresidential=" + idresidential +

                ", date=" + date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", paymentdate=" + paymentdate +
                ", success=" + success +
                '}';
    }
}
