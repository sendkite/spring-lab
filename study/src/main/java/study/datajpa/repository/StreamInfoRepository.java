package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.StreamInfo;

public interface StreamInfoRepository extends JpaRepository<StreamInfo, Long> {
}
