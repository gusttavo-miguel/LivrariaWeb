package com.crud.livrariaWeb.repository;

import com.crud.livrariaWeb.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VendaRepository<Int> extends JpaRepository<Venda, Int>  {

    List<Venda> findByCliente (@Param("id") int idCliente);
    Venda findById(int id);


}

