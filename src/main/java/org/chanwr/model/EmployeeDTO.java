package org.chanwr.model;

import lombok.Data;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {

    @QuerySqlField(index = true)
    private Integer id;

    @QuerySqlField(index = true)
    private String name;

    @QuerySqlField(index = true)
    private boolean isEmployed;

}
