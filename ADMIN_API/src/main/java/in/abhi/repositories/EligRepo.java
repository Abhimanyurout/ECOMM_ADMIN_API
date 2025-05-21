package in.abhi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.abhi.entities.EligEntity;

public interface EligRepo extends JpaRepository<EligEntity, Integer> {

}
