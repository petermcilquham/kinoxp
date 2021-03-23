package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.WorkShiftsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkShiftRepository extends JpaRepository<WorkShiftsEntity, Integer>{

    @Query("FROM WorkShiftsEntity ")
    List<WorkShiftsEntity> findAllWorkShifts();

}
