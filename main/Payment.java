package main;

public class Payment {
    public Payment(Bill bill) {
        this.bill = bill;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    Bill bill;
    PaymentStatus paymentStatus;
    public void payBill()
    {
        this.paymentStatus = PaymentStatus.COMPLETED;
        this.bill.billStatus = BillStatus.PAID;
    }

}
