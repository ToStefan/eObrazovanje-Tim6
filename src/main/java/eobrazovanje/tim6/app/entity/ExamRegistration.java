
package eobrazovanje.tim6.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exam_registrations")
@Where(clause = "deleted=false")
public class ExamRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_registration_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "exam_registration_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date;

    @NotNull
    private Boolean deleted = false;

    @Version
    @NotNull
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "student_id", nullable = false)
    public Student student;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "course_id", nullable = false)
    public Course course;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "term_id", nullable = false)
    private Term term;
}
