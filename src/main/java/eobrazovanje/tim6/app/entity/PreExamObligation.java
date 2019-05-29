
package eobrazovanje.tim6.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pre_exam_obligations")
@Where(clause = "deleted=false")
public class PreExamObligation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pre_exam_obligation_id", unique = true, nullable = false)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer points;

    @NotNull
    private Boolean deleted = false;

    @Version
    @NotNull
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "student_id")
    public Student student;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "course_id")
    public Course course;
}
