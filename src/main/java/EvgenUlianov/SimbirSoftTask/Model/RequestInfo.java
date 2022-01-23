package EvgenUlianov.SimbirSoftTask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "request_info")
public class RequestInfo {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_time")
    private Date dateTime;

    @Column
    private String url;

    public RequestInfo() {}

    @Override
    public String toString() {
        return "RequestInfo{" +
                "dateTime=" + dateTime +
                ", url='" + url + '\'' +
                '}';
    }

    public RequestInfo(String url) {
        this.id = 0L;
        this.dateTime = new Date();
        this.url = url;
    }
}
