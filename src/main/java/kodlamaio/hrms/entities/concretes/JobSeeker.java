package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="job_seeker")
public class JobSeeker {
    @Id
    @GeneratedValue
    @Column(name="id")
    public int id;

    @Column(name="name")
    public String name;

    @Column(name="surname")
    public String surname;

    @Column(name="identification_number")
    public String identificationNumber;

    @Column(name="birth_year")
    public int birthYear;

    @Column(name="email")
    public String email;

    @Column(name="password")
    public String password;

}
