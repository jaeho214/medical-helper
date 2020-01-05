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


    List<Hospital> findByNameContaining(String name);
    Page<Hospital> findByCityCode(String cityCode, Pageable pageable);
    Page<Hospital> findByCityCodeAndNameContaining(String cityCode, String hospitalCode, Pageable pageable);

    @Query("select h from Hospital h join fetch h.hospitalComment where h.hospitalNo=:hospitalNo")
    Optional<Hospital> findById(Long hospitalNo);

    @Query(nativeQuery = true, value = "select *, (6371*acos(cos(radians(:yPos))*cos(radians(h.y_pos))*cos(radians(h.x_pos)-radians(:xPos)) \n" +
            "+sin(radians(:yPos))*sin(radians(h.y_pos)))) AS distance from Hospital h having distance < 7 order by distance asc limit :pageNum, 10;")
    List<Hospital> findByXPosAndYPos(@Param("xPos") String xPos,
                                     @Param("yPos") String yPos,
                                     @Param("pageNum") int pageNum);

    @Query(nativeQuery = true, value = "select *, (6371*acos(cos(radians(:yPos))*cos(radians(h.y_pos))*cos(radians(h.x_pos)-radians(:xPos)) \n" +
            "+sin(radians(:yPos))*sin(radians(h.y_pos)))) AS distance from Hospital h " +
            "where h.name like CONCAT('%', :hospitalCode, '%') having distance < 7  order by distance asc limit :pageNum, 10 ; ")
    List<Hospital> findByHospitalCode(@Param("xPos") String xPos,
                                      @Param("yPos") String yPos,
                                      @Param("hospitalCode")String hospitalCode,
                                      @Param("pageNum") int pageNum);
}
