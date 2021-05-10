package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Roles")
public class Role {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
}
