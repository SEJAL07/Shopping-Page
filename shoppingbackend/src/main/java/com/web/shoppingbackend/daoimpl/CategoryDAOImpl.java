package com.web.shoppingbackend.daoimpl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.shoppingbackend.dao.CategoryDAO;
import com.web.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private static List<Category> categories = new ArrayList<Category>();

	static {

		Category category = new Category();

		category.setId(1);
		category.setName("Earrings");
		category.setDescription("this is inside eaRRINGS");
		category.setImageURL("img_1.png");
		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Rings");
		category.setDescription("this is inside RINGS");
		category.setImageURL("img_2.png");
		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("Nacklaces");
		category.setDescription("this is inside nacklaces");
		category.setImageURL("img_3.png");
		categories.add(category);

		category = new Category();
		category.setId(4);
		category.setName("Bracelets");
		category.setDescription("this is inside bracelets");
		category.setImageURL("img_4.png");
		categories.add(category);

	
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	public Category get(int id) {
		//foreach
		for(Category category : categories) {
			if(category.getId()== id)return category;
		}
		return null;
	}

	@Transactional  
	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);
		
			return true;
		}

		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		
	}

}
