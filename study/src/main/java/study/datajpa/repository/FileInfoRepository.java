package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.FfFileInfo;

public interface FileInfoRepository extends JpaRepository<FfFileInfo, Long> {
}
