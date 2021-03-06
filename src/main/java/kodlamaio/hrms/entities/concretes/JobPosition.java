package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    @NotBlank
    @Column(name = "position")
    private String position;
}
