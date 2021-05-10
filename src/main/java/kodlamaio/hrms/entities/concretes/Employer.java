package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employers")
public class Employer{
    @Id
    @GeneratedValue
    @Column(name="id")
    public int id;

    @Column(name="company_name")
    public String companyName;

    @Column(name="web_site")
    public String webSite;

    @Column(name="email")
    public String email;

    @Column(name="phone_number")
    public String phoneNumber;

    @Column(name="password")
    public String password;

    public Employer() {

    }

    public Employer(int id, String companyName, String webSite, String email, String phoneNumber, String password) {
        this.id = id;
        this.companyName = companyName;
        this.webSite = webSite;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
