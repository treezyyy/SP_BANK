public class BankApplication {
    public static void main(String[] args) {
        Account account = new Account(1000);

        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                double amount = Math.random() * 200;
                account.deposit(amount);
            }
        });


        Thread withdrawThread = new Thread(() -> {
            double amountToWithdraw = 800;
            account.withdraw(amountToWithdraw);
        });

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Остаток на счете: " + account.getBalance());
    }
}