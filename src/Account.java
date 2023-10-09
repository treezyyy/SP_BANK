class Account {
    private double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Пополнено: " + amount);
        notifyAll();
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
        System.out.println("Снято: " + amount);
    }

    public synchronized double getBalance() {
        return balance;
    }
}