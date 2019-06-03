
package eobrazovanje.tim6.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "academic_roles")
@Where(clause = "deleted=false")
public class AcademicRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academic_role_id", unique = true, nullable = false)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Boolean deleted = false;

    @Version
    @NonNull
    private Long version;

    @OneToMany(mappedBy = "academicRole", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    public Set<Staff> staffs = new HashSet<>();

    @OneToMany(mappedBy = "academicRole", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    public Set<Engagement> engagements = new HashSet<>();
}
