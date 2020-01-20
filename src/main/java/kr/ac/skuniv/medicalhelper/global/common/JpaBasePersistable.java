package kr.ac.skuniv.medicalhelper.global.common;

import kr.ac.skuniv.medicalhelper.global.config.BooleanToYNConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = "id", callSuper = false)
@Getter
public class JpaBasePersistable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

}
