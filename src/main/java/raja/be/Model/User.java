package raja.be.Model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    private String login;
    private String passwordhash;
    private boolean active;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Person person;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", passwordhash='" + passwordhash + '\'' +
                ", active=" + active +
                ", person=" + person +
                '}';
    }
}
