package br.com.yuricodev.schedulingmvp.repository;

import br.com.yuricodev.schedulingmvp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
}
