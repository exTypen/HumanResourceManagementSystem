package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_positions")
public class JobPosition {
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;

    @Column(name = "position")
    private String position;
}
