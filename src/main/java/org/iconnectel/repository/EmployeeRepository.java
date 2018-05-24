package org.iconnectel.repository;

import org.iconnectel.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lahirue on 5/22/18.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDTO,Long> {

}
