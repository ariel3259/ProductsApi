package com.ariel.ProductsApi.Abstractions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T,Long> {
    Page<T> findByStatus(Pageable page, boolean status);

    @Query("SELECT e FROM #{#entityName} e WHERE e.id = :id AND e.status = true")
    T getReferenceById(@Param("id") Long id);

    long countByStatus(boolean status);

    @Modifying
    @Query("UPDATE #{#entityName} e SET e.status = false WHERE e.id = :id")
    void deleteById(@Param("id") Long id);
}
