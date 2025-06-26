public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Антон Лебедев");
        BankAccount account2 = new BankAccount("Михаил Осипов");

        System.out.println("Счет 1: " + account1);
        System.out.println("Счет 2: " + account2);


        boolean depositAccount = account1.Deposit(500);
        System.out.println("Пополнение счета: " + (depositAccount ? "Успешно" : "Неудача"));
        System.out.println("Счет: " + account1.GetBalance());

        boolean withdrawAccount = account1.Withdraw(100);
        System.out.println("Снятие с счета: " + (withdrawAccount ? "Успешно" : "Неудача"));
        System.out.println("Счет: " + account1.GetBalance());

        boolean transferAccount = account1.Transfer(account2, 100);
        System.out.println("Перевод на другой счет: " + (transferAccount ? "Успешно" : "Неудача"));
        System.out.println("Счет Антона Лебедева: " + account1.GetBalance());
        System.out.println("Счет Михаила Осипова: " + account2.GetBalance());

        System.out.println("Счета одинаковые? " + account1.equals(account2));
    }
}
