package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{

    @Column(name="company_name")
    private String companyName;
    @Column(name="web_site")
    private String webSite;
    @Column(name="phone_number")
    private String phoneNumber;
}
