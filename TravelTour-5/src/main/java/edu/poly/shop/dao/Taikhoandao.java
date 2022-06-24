package edu.poly.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional 
public class Taikhoandao {
	@Autowired
	private EntityManager entityManager;
	
	
}
