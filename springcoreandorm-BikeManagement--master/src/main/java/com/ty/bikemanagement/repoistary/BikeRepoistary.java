package com.ty.bikemanagement.repoistary;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ty.bikemanagement.model.Bike;
import com.ty.bikemanagement.model.Hero;
import com.ty.bikemanagement.model.Honda;

import java.util.List;

@Repository
@Transactional
public class BikeRepoistary {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void saveBike(Bike bike) {

//		if (bike instanceof Hero)
			hibernateTemplate.save(bike);

//		else
//			hibernateTemplate.save((Honda) (bike));

	}

	public List<Hero> getHeros() {

		return hibernateTemplate.loadAll(Hero.class);
	}

	public List<Honda> getHondas() {
		return hibernateTemplate.loadAll(Honda.class);
	}

	public void deleteBike(Bike bike) {
//		if (bike instanceof Hero)
			hibernateTemplate.delete(bike);

//		else
//			hibernateTemplate.delete((Honda) (bike));

	}

	public void updateBike(Bike bike) {
//		if (bike instanceof Hero)
			hibernateTemplate.update(bike);

//		else
//			hibernateTemplate.update((Honda) (bike));

	}

}
