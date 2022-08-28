package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
public class FfFile {

    @Id
    @GeneratedValue
    private Long id;

    private Long appId;
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private UsageType usageType;

    private String mimeType;
    private Long size;
    private String s3BucketKey;

    @OneToOne(mappedBy = "ffFile")
    private FfFileInfo fileInfo;

    @Builder
    public FfFile(Long appId, String name, UsageType usageType, String mimeType, Long size, String s3BucketKey, FfFileInfo fileInfo) {
        this.appId = appId;
        this.name = name;
        this.usageType = usageType;
        this.mimeType = mimeType;
        this.size = size;
        this.s3BucketKey = s3BucketKey;
        if (fileInfo != null) {
            this.fileInfo = fileInfo;
        }
    }
}
