package study.datajpa.entity;

public enum UsageType {

    // @formatter:off
    VIDEO_SOURCE(0),
    VIDEO_PROCESSED(1),
    THUMBNAIL_UPLOADED(2),
    THUMBNAIL_EXTRACTED(3),
    PREVIEW_UPLOADED(4),
    PREVIEW_EXTRACTED(5),
    ;
    // @formatter:on

    private Integer value;

    UsageType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

}
