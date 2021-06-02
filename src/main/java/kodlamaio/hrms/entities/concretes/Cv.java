package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
public class Cv {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "job_seeker_id")
    @ManyToOne
    private JobSeeker jobSeeker;

    @OneToMany(mappedBy = "cv")
    private List<Education> educations;

    @OneToMany(mappedBy = "cv")
    private List<Experience> experience;

    @OneToMany(mappedBy = "cv")
    private List<ForeignLanguageLevel> foreignLanguageLevel;

    @OneToMany(mappedBy = "cv")
    private List<ProgrammingLanguageLevel> programmingLanguageLevel;

    @Column(name = "github_address")
    private String githubAddress;

    @Column(name = "linkedin_address")
    private String linkedinAddress;

    @Column(name = "cover_letter")
    private String coverLetter;


}
