package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="cv_id")
    private Cv cv;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @NotNull
    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    private int endYear;
}
