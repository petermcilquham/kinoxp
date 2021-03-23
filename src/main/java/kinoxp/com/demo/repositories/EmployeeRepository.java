package kinoxp.com.demo.repositories;

import kinoxp.com.demo.model.EmployeesEntity;
import kinoxp.com.demo.model.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<ProductsEntity, Integer> {

    @Query("FROM EmployeesEntity ")
    List<EmployeesEntity> findAllEmps();
}
