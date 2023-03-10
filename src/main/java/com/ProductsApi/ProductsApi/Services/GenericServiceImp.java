package com.ProductsApi.ProductsApi.Services;

import com.ProductsApi.ProductsApi.Abstractions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public abstract class GenericServiceImp<ID extends Serializable, Ent extends BaseEntity<ID>, Req, Res, Upd> implements GenericService<ID, Ent, Req, Res, Upd> {

    private final Repository<ID, Ent> repository;
    private final Mapper<ID, Ent, Req, Res, Upd> mapper;

    @Autowired
    public GenericServiceImp(Repository<ID, Ent> r, Mapper<ID, Ent, Req, Res, Upd> m){
        repository = r;
        mapper = m;
    }

    public PageResponse<Res> getAll(Optional<Integer> offset, Optional<Integer> limit) {
        int page = offset.orElse(0) * limit.orElse(10);
        Pageable pageable = PageRequest.of(page, limit.orElse(10));
        Page<Ent> entities = repository.findAllByStatus(pageable, true);
        return mapper.map(entities);
    }

    public Res getOne(ID id) {
        Ent entity = repository.getReferenceByIdAndStatus(id, true);
        return mapper.map(entity);
    }

    public Res save(Req request, String username) {
        Ent entityToSave = mapper.map(request, username);
        Ent entitySaved = repository.save(entityToSave);
        return mapper.map(entitySaved);
    }

    public Res update(Upd updateRequest, ID id, String username) {
        Ent entity = repository.getReferenceByIdAndStatus(id, true);
        if(entity == null) return null;
        Ent entityToUpdate = mapper.map(updateRequest, entity, username);
        entityToUpdate.setId(id);
        Ent entityUpdated = repository.save(entityToUpdate);
        return mapper.map(entityUpdated);
    }

    public void delete(ID id) {
        Ent entityToDelete = repository.getReferenceByIdAndStatus(id, true);
        if(entityToDelete == null) return;
        entityToDelete.setStatus(false);
        repository.save(entityToDelete);
    }
}
