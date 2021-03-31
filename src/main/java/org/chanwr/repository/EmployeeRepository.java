package org.chanwr.repository;

import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;
import org.chanwr.model.EmployeeDTO;
import org.springframework.stereotype.Repository;

// FIXME figure out how to setup IgniteRepository
@RepositoryConfig(cacheName = "employeeCache")
@Repository
public interface EmployeeRepository extends IgniteRepository<EmployeeDTO, Integer> {

    EmployeeDTO getEmployeeDTOById(Integer id);

}
