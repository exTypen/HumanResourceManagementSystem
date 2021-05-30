package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisement")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @NotBlank
    @Column(name = "description")
    private String description;

    @Column(name="min_salary")
    private int minSalary;

    @Column(name="max_salary")
    private int maxSalary;

    @NotNull
    @Column(name="number_of_open_position")
    private short numberOfOpenPosition;

    @NotNull
    @Column(name = "create_date")
    private LocalDate createDate;

    @NotNull
    @Column(name="application_deadline")
    private LocalDate applicationDeadline;

    @NotNull
    @Column(name = "is_active")
    private boolean isActive;

}
