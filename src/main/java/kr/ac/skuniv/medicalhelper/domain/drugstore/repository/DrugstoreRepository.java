package kr.ac.skuniv.medicalhelper.domain.drugstore.repository;

import kr.ac.skuniv.medicalhelper.domain.drugstore.entity.Drugstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DrugstoreRepository extends JpaRepository<Drugstore, Long> {

    @Query(nativeQuery = true, value = "select *, (6371*acos(cos(radians(:yPos))*cos(radians(d.y_pos))*cos(radians(d.x_pos)-radians(:xPos)) \n" +
            "+sin(radians(:yPos))*sin(radians(d.y_pos)))) AS distance from drugstore d where d.name like CONCAT('%', :name, '%') order by distance desc limit :pageNum, 10;")
    List<Drugstore> findByName(String name, String xPos, String yPos, int pageNum);


    @Query(nativeQuery = true, value = "select *, (6371*acos(cos(radians(:yPos))*cos(radians(d.y_pos))*cos(radians(d.x_pos)-radians(:xPos)) \n" +
            "+sin(radians(:yPos))*sin(radians(d.y_pos)))) AS distance from drugstore d order by distance desc limit :pageNum, 10;")
    List<Drugstore> findOrderByDistance(String xPos, String yPos, int pageNum);

    @Query("select d from Drugstore d join fetch d.drugstoreComment where d.drugstoreNo=:drugstoreNo")
    Optional<Drugstore> findById(Long drugstoreNo);


}