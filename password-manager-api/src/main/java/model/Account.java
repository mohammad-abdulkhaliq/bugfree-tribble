package model;

public class Account implements Comparable<Account>{

    private final int id;
    private final String account;
    private final String password;

    public Account(int id, String account, String password) {

        this.id = id;
        this.account = account;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int compareTo(Account account) {
        return this.getId() > account.getId() ? 1 : this.getId() == account.getId() ? 0 : -1;
    }
}