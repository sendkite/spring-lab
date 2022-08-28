package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
public class FfFileInfo {

    @Id
    @GeneratedValue
    @Column(name = "fileInfoId")
    private Long id;

    private Long fileId;

    private String formatName;
    private String formatLongName;

    @OneToMany
    @JoinColumn(name = "fileInfoId")
    private List<StreamInfo> streamInfos;

    @OneToOne
    @JoinColumn(name = "fileId", insertable = false, updatable = false)
    private FfFile ffFile;

    @Builder
    public FfFileInfo(Long fileId, String formatName, String formatLongName, List<StreamInfo> streamInfos) {
        this.fileId = fileId;
        this.formatName = formatName;
        this.formatLongName = formatLongName;
        if (streamInfos != null) {
            this.streamInfos = streamInfos;
        }
    }
}
