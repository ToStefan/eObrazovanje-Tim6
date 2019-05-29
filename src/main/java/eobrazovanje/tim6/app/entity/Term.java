package eobrazovanje.tim6.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "terms")
@Where(clause = "deleted=false")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_id", unique = true, nullable = false)
    private Long id;

    @NotNull
    private String name;

    @Column(name = "date_start", nullable = false)
    private Date dateStart;

    @Column(name = "date_end", nullable = false)
    private Date dateEnd;

    @Version
    @NotNull
    private Long version;

    @NotNull
    private Boolean deleted;

    @NotNull
    private Boolean current;
}
