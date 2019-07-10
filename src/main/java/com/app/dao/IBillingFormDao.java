package com.app.dao;

import java.util.List;

import com.app.model.BillingForm;

public interface IBillingFormDao {

	public Integer saveBilling(BillingForm billingForm);
	public void updateBilling(BillingForm billingForm);
	public void deleteBilling(Integer id);
	public BillingForm getOneByBilling(Integer id);
	public List<BillingForm> getAllBilling();
}
