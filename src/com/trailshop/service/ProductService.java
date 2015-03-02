package com.trailshop.service;

import java.util.Collection;

import com.trailshop.entities.Product;


public interface ProductService {

	public Product createProduct(Product product) throws Exception;

	public Product getProduct(String productID);

	public Collection<Product> getProducts();

	public Product updateProduct(Product product) throws Exception;

	public void deleteProduct(Product product) throws Exception;

}
