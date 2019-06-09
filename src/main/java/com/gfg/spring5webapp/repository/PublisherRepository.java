package com.gfg.spring5webapp.repository;

import com.gfg.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,String> {
}
