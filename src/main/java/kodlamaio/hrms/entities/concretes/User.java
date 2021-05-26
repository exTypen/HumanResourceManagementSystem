package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Email(message = "Geçerli bir email adresi giriniz")
    @NotBlank(message = "Email alanı boş olamaz")
    @Column(name="email")
    private String email;

    @NotBlank(message = "Şifre alanı boş olamaz")
    @Column(name="password")
    private String password;
}
