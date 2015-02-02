package com.tony.examples.couchbase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.mapping.event.ValidatingCouchbaseEventListener;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Arrays;
import java.util.List;

/**
 * Annotation-based Configuration ("JavaConfig")
 */
@Configuration
@EnableCouchbaseRepositories("com.tony.examples.couchbase")
public class Config extends AbstractCouchbaseConfiguration {

    @Value("#{couchbase['couchbase.hosts']}")
    private String hosts;

    @Value("#{couchbase['couchbase.bucket.name']}")
    private String bucketName;

    @Value("#{couchbase['couchbase.bucket.passwd']}")
    private String bucketPasswd;

    @Override
    protected List<String> bootstrapHosts() {
        return Arrays.asList(this.hosts.split(","));
    }

    @Override
    protected String getBucketName() {
        return this.bucketName;
    }

    @Override
    protected String getBucketPassword() {
        return this.bucketPasswd;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public ValidatingCouchbaseEventListener validationEventListener() {
        return new ValidatingCouchbaseEventListener(validator());
    }
}