package org.chanwr.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata22.repository.config.EnableIgniteRepositories;
import org.chanwr.model.EmployeeDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableIgniteRepositories
public class SpringDataConfig {

    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration igniteCfg = new IgniteConfiguration();
        CacheConfiguration<Integer, EmployeeDTO> cacheCfg = new CacheConfiguration<>("employeeCache");
        cacheCfg.setIndexedTypes(Integer.class, EmployeeDTO.class);
        igniteCfg.setCacheConfiguration(cacheCfg);
        return Ignition.start(igniteCfg);
    }

}
