package r.demo.graphql.domain.word;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import r.demo.graphql.domain.content.Content;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(schema = "demo", name = "word")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "content", referencedColumnName = "id")
    private Content content;

    @Column(name = "eng", columnDefinition = "TEXT", nullable = false)
    private String eng;

    @Column(name = "kor", columnDefinition = "TEXT", nullable = false)
    private String kor;

    @Column(name = "pos", length = 10)
    private String pos;

    @Column(name = "lemma", columnDefinition = "TEXT", nullable = false)
    private String lemma;

    @Column(name = "sequence", columnDefinition = "SMALLINT", nullable = false)
    private int sequence;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private java.util.Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", nullable = false)
    private java.util.Date modified;

    @Builder
    public Word(@NonNull Content content, @NonNull String eng, @NonNull String kor, @Nullable String pos, @NonNull String lemma, int sequence) {
        this.content = content;
        this.eng = eng;
        this.kor = kor;
        this.pos = pos;
        this.lemma = lemma;
        this.sequence = sequence;
    }
}
