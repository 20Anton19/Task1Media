import java.time.LocalDateTime;
 class BankAccount {
    private String ownerName;

    private int balance;

    private LocalDateTime openingDate;

    private Boolean isBlocked;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        balance = 500000;
        openingDate = LocalDateTime.of(2025, 6, 25, 14, 30);
        isBlocked = false;
    }

    public int GetBalance() {
        return balance;
    }

    public boolean Deposit(int amount){
        balance += amount;
        return true;
    }

     public boolean Withdraw(int amount){
         if (balance >= amount) {
             balance -= amount;
             return true;
         }
         else {
             System.out.println("Ошибка! Недостаточно средств.");
             return false;
         }
     }

     public boolean Transfer(BankAccount otherAccount, int amount) {
         if (balance >= amount) {
             balance -= amount;
             otherAccount.balance += amount;
             return true;
         }
         else {
             System.out.println("Ошибка! Недостаточно средств.");
             return false;
         }
     }
}
