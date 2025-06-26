import java.time.LocalDateTime;
import java.util.Random;

class BankAccount {
    private String ownerName;

    private int balance;

    private LocalDateTime openingDate;

    private Boolean isBlocked;

     private String number;

     // Геттеры для полей
     public String GetOwnerName() {
         return ownerName;
     }

     public int GetBalance() {
         return balance;
     }

     public LocalDateTime GetOpeningDate() {
         return openingDate;
     }

     public boolean IsBlocked() {
         return isBlocked;
     }

     public String GetNumber() {
         return number;
     }

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 500000;
        this.openingDate = LocalDateTime.of(2025, 6, 25, 14, 30);
        this.isBlocked = false;
        this.number = generateAccountNumber();
    }

     // Генерация номера счета
     private String generateAccountNumber() {
         Random random = new Random();
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < 8; i++) {
             sb.append(random.nextInt(10));
         }
         return sb.toString();
     }

    public boolean Deposit(int amount){
        if (amount > 0 && !isBlocked) {
            balance += amount;
            return true;
        }
        return false;
    }

     public boolean Withdraw(int amount){
         if (amount > 0 && balance >= amount && !isBlocked) {
             balance -= amount;
             return true;
         }
         return false;
     }

     public boolean Transfer(BankAccount otherAccount, int amount) {
         if (Withdraw(amount)) {
             return otherAccount.Deposit(amount);
         }
         return false;
     }

     // Переопределение toString
     @Override
     public String toString() {
         return "BankAccount{" +
                 "ownerName='" + ownerName + '\'' +
                 ", balance=" + balance +
                 ", openingDate=" + openingDate +
                 ", isBlocked=" + isBlocked +
                 ", number='" + number + '\'' +
                 '}';
     }

     // Переопределение equals и hashCode
     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         BankAccount that = (BankAccount) o;
         return number.equals(that.number);
     }

     @Override
     public int hashCode() {
         return number.hashCode();
     }
}
