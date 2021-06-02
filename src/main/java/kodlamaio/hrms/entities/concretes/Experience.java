package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "experiences")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name")
    @NotBlank
    private String companyName;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="cv_id")
    private Cv cv;

    @NotNull
    @Column(name = "position_id")
    private int positionId;

    @NotNull
    @Column(name = "start_year")
    private int start_year;

    @Column(name = "end_year")
    private int end_year;
}
