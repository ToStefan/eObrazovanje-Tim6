
package eobrazovanje.tim6.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grades_lookup")
public class GradeLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private Integer grade;

    @Column(name = "min_points", unique = true, nullable = false)
    private Integer minPoints;

    @Column(name = "max_points", unique = true, nullable = false)
    private Integer maxPoints;
}
