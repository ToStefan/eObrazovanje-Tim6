
package eobrazovanje.tim6.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grades")
@Where(clause = "deleted=false")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", unique = true, nullable = false)
    private Long id;

    @NotNull
    private Integer grade;

    @Column(name = "total_points", nullable = false)
    private Integer totalPoints;

    @ManyToMany
    @JoinTable(name = "grades_pre_exam_obligations",
            joinColumns = @JoinColumn(name = "grade_id", referencedColumnName = "grade_id"),
            inverseJoinColumns = @JoinColumn(name = "pre_exam_obligation_id",
                    referencedColumnName = "pre_exam_obligation_id"))
    public Set<PreExamObligation> preExamObligations = new HashSet<PreExamObligation>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "student_id")
    public Student student;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "course_id", nullable = false)
    public Course course;

    @NotNull
    private Boolean deleted = false;

    @Version
    @NotNull
    private Long version;
}
