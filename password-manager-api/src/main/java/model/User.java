package model;

import util.RSA;

public class User implements Comparable<User> {

    private int id;
    private final String email;
    private final String password;
    private RSA rsaInstance;

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int compareTo(User user) {

        //return this.getId() > user.getId() ? 1 : this.getId() == user.getId() ? 0 : -1;
        return ((this.getEmail().compareTo(user.getEmail())) & (this.getPassword().compareTo(user.getPassword())));
    }

	public RSA getRsaInstance() {
		return rsaInstance;
	}

	public void setRsaInstance(RSA rsaInstance) {
		this.rsaInstance = rsaInstance;
	}
}