package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.FfFile;
import study.datajpa.entity.FfFileInfo;
import study.datajpa.entity.StreamInfo;
import study.datajpa.entity.UsageType;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class FileRepositoryTest {


    @Autowired
    FileRepository fileRepository;
    @Autowired
    FileInfoRepository fileInfoRepository;
    @Autowired
    StreamInfoRepository streamInfoRepository;

    @Test
    void test1() {
        // given
        FfFile file = FfFile.builder()
                .appId(1L)
                .name("test")
                .usageType(UsageType.VIDEO_SOURCE)
                .size(1234L)
                .s3BucketKey("dfdfdfdfdfdf")
                .mimeType("test")
                .build();
        FfFile ffFile = fileRepository.save(file);
        assertThat(ffFile).isEqualTo(file);

        FfFileInfo ffFileInfo = FfFileInfo.builder()
                .fileId(ffFile.getId())
                .formatName("trst")
                .formatLongName("test")
                .build();
        FfFileInfo dbInfo = fileInfoRepository.saveAndFlush(ffFileInfo);

        StreamInfo steamInfo = StreamInfo.builder()
                .fileInfoId(dbInfo.getId())
                .codecName("test")
                .build();
        streamInfoRepository.saveAndFlush(steamInfo);

        FfFile joinFile = fileRepository.findFileInternal(ffFile.getId());

        assertThat(joinFile.getId()).isEqualTo(ffFile.getId());
        assertThat(joinFile.getAppId()).isEqualTo(ffFile.getAppId());
        assertThat(joinFile.getS3BucketKey()).isEqualTo(ffFile.getS3BucketKey());
        // assertThat(joinFile.getFileInfo()).isEqualTo(dbInfo);


        System.out.println("result = " + joinFile);
    }

}