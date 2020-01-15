package kr.ac.skuniv.medicalhelper.domain.pharmacy.repository;

import kr.ac.skuniv.medicalhelper.domain.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

    @Query(nativeQuery = true, value = "select *, (6371*acos(cos(radians(:yPos))*cos(radians(p.y_pos))*cos(radians(p.x_pos)-radians(:xPos)) \n" +
            "+sin(radians(:yPos))*sin(radians(p.y_pos)))) AS distance from pharmacy p where p.name like CONCAT('%', :name, '%') having distance < 7 " +
            "order by distance asc limit :pageNo, 10;")
    List<Pharmacy> findByName(String name, String xPos, String yPos, int pageNo);


    @Query(nativeQuery = true, value = "select *, (6371*acos(cos(radians(:yPos))*cos(radians(p.y_pos))*cos(radians(p.x_pos)-radians(:xPos)) \n" +
            "+sin(radians(:yPos))*sin(radians(p.y_pos)))) AS distance from pharmacy p having distance < 7 order by distance asc limit :pageNo, 10;")
    List<Pharmacy> findOrderByDistance(String xPos, String yPos, int pageNo);



}
