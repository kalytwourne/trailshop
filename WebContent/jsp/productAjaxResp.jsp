<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

					<div class="features_items">
						<h2 class="title text-left">Browse Products</h2>
						<form action="AddProduct.action" method="post"        name="listProducts" id="listProducts">
                             <s:iterator value="products">
                        <div class="col-sm-4">
                          <div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/<s:property value="productUrl" />" alt="" />
										<h2><s:property value="unitPrice" /></h2>
										<p><s:property value="description" /></p>
									<div>
										<input type="hidden" id="productId" value="<s:property value="productId" />" >
										<input type="button" id="add2cart" value="Add to cart" class="btn btn-default add-to-cart">
										</input>
									</div>
										
										
									</div>
                                  
									
								</div>
								
							</div>
						</div>
                            				  </s:iterator>

                        </form>    
                            
						
						
					</div><!--features_items-->
				