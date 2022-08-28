package study.datajpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StreamInfo {

    @Id
    @GeneratedValue
    private Long id;

    private Long fileInfoId;
    private String codecName;

    @Builder
    public StreamInfo(Long fileInfoId, String codecName) {
        this.fileInfoId = fileInfoId;
        this.codecName = codecName;
    }
}
