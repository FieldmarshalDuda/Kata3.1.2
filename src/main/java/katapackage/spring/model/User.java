package katapackage.spring.model;



import jakarta.persistence.*;


@Entity
@Table(name = "usertable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)

    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "email")
    private String email;

    public User() {

    }
    public User(User user) {
        name = user.getName();
        lastname = user.getLastname();
        email = user.email;
    }

    public User(String name, String lastName, String email) {
        this.name = name;
        this.lastname = lastName;
        this.email = email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return ("Name:" + name + " / " + "Last name: " + lastname + " / " + "Identification: " + id);
    }
}
