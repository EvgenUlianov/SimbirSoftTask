package EvgenUlianov.SimbirSoftTask.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "statistic_entity")
public class StatisticEntity {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_info")
    private RequestInfo requestInfo;

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String word;

    @Column
    private int count;

    public StatisticEntity() {}

    public StatisticEntity(String word, int count) {
        this.id = 0L;
        this.word = word;
        this.count = count;
    }

    @Override
    public String toString() {
        return word + " = " + count;
    }
}
