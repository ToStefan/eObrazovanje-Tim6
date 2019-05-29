
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
@Table(name = "documents")
@Where(clause = "deleted=false")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id", unique = true, nullable = false)
    private Long id;

    @NotNull
    private String name;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @NotNull
    private String uri;

    @NotNull
    private Boolean deleted = false;

    @Version
    @NotNull
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "student_id")
    public Student student;
}
