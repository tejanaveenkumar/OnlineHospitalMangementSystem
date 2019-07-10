package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IBillingFormDao;
import com.app.model.BillingForm;
@Repository
public class BillingFormDaoImpl implements IBillingFormDao {
@Autowired
	private HibernateTemplate ht;
	public Integer saveBilling(BillingForm billingForm) {
		return (Integer) ht.save(billingForm);
	}
	public void updateBilling(BillingForm billingForm) {
		ht.update(billingForm);
	}
	public void deleteBilling(Integer id) {
		BillingForm b=new BillingForm();
b.setId(id);	
		ht.delete(b);
	}
	public BillingForm getOneByBilling(Integer id) {
		return ht.get(BillingForm.class, id);
	}
	public List<BillingForm> getAllBilling() {
		return ht.loadAll(BillingForm.class);
	}

}
