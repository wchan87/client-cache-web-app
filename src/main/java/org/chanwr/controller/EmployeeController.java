package org.chanwr.controller;

import org.apache.ignite.Ignite;
import org.chanwr.model.EmployeeDTO;
import org.chanwr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private Ignite ignite;

    /*
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }
    */

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public EmployeeDTO getEmployee(@PathVariable int id) {
        return (EmployeeDTO) ignite.cache("employeeCache").get(id);
        // return repository.getEmployeeDTOById(id);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO requestBody) {
        ignite.cache("employeeCache").put(requestBody.getId(), requestBody);
        return requestBody;
        // return repository.save(requestBody.getId(), requestBody);
    }

}
