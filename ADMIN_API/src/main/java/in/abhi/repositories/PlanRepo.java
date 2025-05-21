package in.abhi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.abhi.entities.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity, Integer>{

}
