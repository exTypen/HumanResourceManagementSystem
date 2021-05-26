package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{

    @NotBlank(message = "Şirket ismi alanı boş olamaz")
    @Column(name="company_name")
    private String companyName;

    @NotBlank(message = "Site link alanı boş olamaz")
    @Column(name="web_site")
    private String webSite;

    @NotBlank(message = "Telefon numarası alanı boş olamaz")
    @Column(name="phone_number")
    private String phoneNumber;
}
