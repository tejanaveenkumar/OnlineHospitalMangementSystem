package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBillingFormDao;
import com.app.model.BillingForm;
import com.app.service.IBillingFormService;

@Service
public class BillingFormServiceImpl implements IBillingFormService {
@Autowired
	private IBillingFormDao dao;
@Transactional
	public Integer saveBilling(BillingForm billingForm) {
		return dao.saveBilling(billingForm);
	}

@Transactional
	public void updateBilling(BillingForm billingForm) {
dao.updateBilling(billingForm);
	}

@Transactional
public void deleteBilling(Integer id) {
dao.deleteBilling(id);
	}

@Transactional(readOnly=true)
public BillingForm getOneByBilling(Integer id) {
		return dao.getOneByBilling(id);
	}

@Transactional(readOnly=true)
	public List<BillingForm> getAllBilling() {
		return dao.getAllBilling();
	}

}
