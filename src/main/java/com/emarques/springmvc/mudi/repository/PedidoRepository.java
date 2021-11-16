package com.emarques.springmvc.mudi.repository;

import java.util.List;

import com.emarques.springmvc.mudi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emarques.springmvc.mudi.model.Pedido;
import com.emarques.springmvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	List<Pedido> findAllByStatus(StatusPedido status);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username")String username);

	@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
	List<Pedido> findAllByStatusEUser(@Param("status")StatusPedido status, @Param("username") String username);

	//List<Pedido> findAllByStatusAndUser(StatusPedido status, String username);
}
