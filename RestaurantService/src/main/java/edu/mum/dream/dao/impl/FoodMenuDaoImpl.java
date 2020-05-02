package edu.mum.dream.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dream.dao.FoodMenuDao;
import edu.mum.dream.domain.FoodMenu;

@Repository
public class FoodMenuDaoImpl extends GenericDaoImpl<FoodMenu> implements FoodMenuDao {
	public FoodMenuDaoImpl() {
		super.setDaoType(FoodMenu.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodMenu> findAllMenuByResturantID(Long resturantId) {

		Query query = entityManager
				.createQuery("select food from FoodMenu  food  " + "where food.resturantId =:resturantId");
		return (List<FoodMenu>) query.setParameter("resturantId", resturantId).getResultList();

	}

}
