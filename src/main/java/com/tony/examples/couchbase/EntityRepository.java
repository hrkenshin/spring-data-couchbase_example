package com.tony.examples.couchbase;

import com.couchbase.client.protocol.views.Query;
import com.tony.examples.couchbase.model.Entity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityRepository<T extends Entity, ID extends java.io.Serializable> extends PagingAndSortingRepository<T, ID> {
    public List<T> findByType(Query query);
}