package com.amitgoswami.rest.webservices.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAUserRepository extends JpaRepository<JPAUser, Integer>
{


}
