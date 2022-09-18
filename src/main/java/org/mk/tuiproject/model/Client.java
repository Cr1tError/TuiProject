package org.mk.tuiproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "passport", nullable = false)
    private String passport;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SoldTrip> trips;

    public Client(long id, String name, String surname, String passport) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
