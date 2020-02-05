package kr.ac.skuniv.medicalhelper.domain.hospital.repository;

import kr.ac.skuniv.medicalhelper.domain.hospital.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Page<Hospital> findByCityCodeName(String cityCode, Pageable pageable);
    Page<Hospital> findByCityCodeNameAndNameContaining(String cityCode, String hospitalCode, Pageable pageable);

    @Query(nativeQuery = true, value = "select *, (6371*acos(cos(radians(:yPos))*cos(radians(h.y_pos))*cos(radians(h.x_pos)-radians(:xPos)) \n" +
            "+sin(radians(:yPos))*sin(radians(h.y_pos)))) AS distance from hospital h " +
            "where h.name like CONCAT('%', :name, '%') order by distance asc limit :pageNo, 10 ; ")
    List<Hospital> findByNameContaining(@Param("xPos") String xPos,
                                        @Param("yPos") String yPos,
                                        @Param("name") String name,
                                        @Param("pageNo") int pageNo);


    @Query(nativeQuery = true, value = "select *, (6371*acos(cos(radians(:yPos))*cos(radians(h.y_pos))*cos(radians(h.x_pos)-radians(:xPos)) \n" +
            "+sin(radians(:yPos))*sin(radians(h.y_pos)))) AS distance from hospital h having distance < 7 order by distance asc limit :pageNo, 10;")
    List<Hospital> findByXPosAndYPos(@Param("xPos") String xPos,
                                     @Param("yPos") String yPos,
                                     @Param("pageNo") int pageNo);

    @Query(nativeQuery = true, value = "select *, (6371*acos(cos(radians(:yPos))*cos(radians(h.y_pos))*cos(radians(h.x_pos)-radians(:xPos)) \n" +
            "+sin(radians(:yPos))*sin(radians(h.y_pos)))) AS distance from hospital h " +
            "where h.name like CONCAT('%', :hospitalCode, '%') having distance < 7  order by distance asc limit :pageNo, 10 ; ")
    List<Hospital> findByHospitalCode(@Param("xPos") String xPos,
                                      @Param("yPos") String yPos,
                                      @Param("hospitalCode")String hospitalCode,
                                      @Param("pageNo") int pageNo);
}
