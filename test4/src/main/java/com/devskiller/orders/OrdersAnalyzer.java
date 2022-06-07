package com.devskiller.orders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.devskiller.orders.model.Customer;
import com.devskiller.orders.model.Order;
import com.devskiller.orders.model.Product;

public class OrdersAnalyzer {

    /**
     * Should return at most three most popular products. Most popular product is the product that have the most occurrences
     * in given orders (ignoring product quantity).
     * If two products have the same popularity, then products should be ordered by name
     *
     * @param orders orders stream
     * @return list with up to three most popular products
     */
    public List<Product> findThreeMostPopularProducts(Stream<Order> orders) {
    	
    	Map<Product, Integer> count = new LinkedHashMap<>();
   
    	orders.forEach(order -> {
    		order.getOrderLines().forEach(orderLine -> {
    			Product product = orderLine.getProduct();
    			if(count.containsKey(product)) {
    				Integer countingProduct = count.get(product);
    				count.put(product, countingProduct + 1);    				
    			} else {
    				count.put(product, 1);    				    				
    			}
    		});
    	});
    	
    	List<Product> products = new ArrayList<>();
    	
    	count.entrySet().stream()
    	.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(e -> {
    		if(products.size() < 3) {
    			products.add(e.getKey());    			
    		}
    	});
    	
    	return products;
    }

    /**
     * Should return the most valuable customer, that is the customer that has the highest value of all placed orders.
     * If two customers have the same orders value, then any of them should be returned.
     *
     * @param orders orders stream
     * @return Optional of most valuable customer
     */
    public Optional<Customer> findMostValuableCustomer(Stream<Order> orders) {
        Map<Customer, BigDecimal> values = new HashMap<>();
        
        orders.forEach(order -> {
        	Customer customer = order.getCustomer();
        	order.getOrderLines().forEach(orderLine -> {
        		Product product = orderLine.getProduct();
        		BigDecimal price = product.getPrice();
        		BigDecimal quantity = new BigDecimal(orderLine.getQuantity());
        		
        		values.put(customer, price.multiply(quantity));
        	});
        });
        
        List<Customer> customers = new ArrayList<>();
        
        values.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .forEach(e -> {
        	Customer customer = e.getKey();
        	customers.add(customer);
        });
        return Optional.of(customers.get(0));	
    }

}
