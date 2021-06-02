package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User{

    @NotBlank(message = "İsim alanı boş olamaz")
    @Column(name="name")
    public String name;

    @Column(name = "image_url")
    private String imageUrl;

    @NotBlank(message = "Soyisim alanı boş olamaz")
    @Column(name="surname")
    public String surname;

    @NotNull(message = "Doğum yılı alanı boş olamaz")
    @Column(name="birth_year")
    private int birthYear;

    @NotBlank(message = "Kimlik numarası alanı boş olamaz")
    @Column(name="national_identity")
    private String nationalIdentity;
}
