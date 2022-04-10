package br.com.mv.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mv.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository <Prato, Long> {

	@Query(value = "SELECT * FROM prato", nativeQuery = true)
	public List<Prato> listaPratos();
	
	
	
	
	
	
	
}
