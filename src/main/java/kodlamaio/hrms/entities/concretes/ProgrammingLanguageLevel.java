package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "programming_language_levels")
public class ProgrammingLanguageLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="cv_id")
    private Cv cv;

    @ManyToOne
    @JoinColumn(name = "programming_language_id")
    private ProgrammingLanguage programmingLanguage;

    //1-5
    @NotNull
    @Column(name = "level")
    private int level;
}
