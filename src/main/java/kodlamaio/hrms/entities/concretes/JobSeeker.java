package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User{

    @Column(name="name")
    public String name;

    @Column(name="surname")
    public String surname;

    @Column(name="birth_year")
    private int birthYear;

    @Column(name="national_identity")
    private String nationalIdentity;
}
