package cl.example.visibility;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public  class Alghoritm {
	
	private static final short SIZE_ID = 0;
	
	private static final short SIZE_ID_PRODUCT = 1;

	private static final short SIZE_ID_BACKSOON = 2;
	
	private static final short SIZE_ID_ESPECIAL = 3;
	
	private static final String FALSE = "false";
	
	private static final String TRUE = "true";
	
	
	public static void visibility(List<String> sizes,Map<Integer,Integer> products,Map<Integer, Integer> stocks) {
			
		// Filtrar y dejar solo Stocks que sean mayor que 0
		Map<Integer, Integer> filteredStock = stocks.entrySet() 
		          .stream() 
		          .filter(map -> map.getValue() > 0) 
		          .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));  
		
		// Obtener id Productos a Mostrar
		Set<String> productsToShow = getProductsToShow(sizes,filteredStock);
	
		//Obtener secuencia Asociada al Producto
		Map<String, Integer> productsFull = getAssociatedProducts(productsToShow,products);
		
		//Visualizar lista productos ordenados por Secuencia
		viewInFront(productsFull);
		
	}
	
	
	
	private static Set<String> getProductsToShow(List<String> sizes, Map<Integer, Integer> filteredStock) {

		Set<String> productIdList = new TreeSet<String>();

		for (int x = 0; x < sizes.size(); x++) {

			String[] sizesData = sizes.get(x).split(",");

			Integer sizeId = Integer.valueOf(sizesData[SIZE_ID]);
			String productId = sizesData[SIZE_ID_PRODUCT];
			String backsoon = sizesData[SIZE_ID_BACKSOON];
			String especial = sizesData[SIZE_ID_ESPECIAL];

			if(especial.equalsIgnoreCase(FALSE) && (filteredStock.get(sizeId) != null || backsoon.equalsIgnoreCase(TRUE))) {
					productIdList.add(productId);	
			}
				
		}

		return productIdList;
	}


	private static Map<String,Integer> getAssociatedProducts(Set<String> productsIdList, Map<Integer,Integer> products) {
		
		Map<String,Integer> productsFull = new HashMap<String, Integer>();
		
		for (String s : productsIdList) {
			productsFull.put(s, products.get(Integer.valueOf(s)));	
		}

		return productsFull;
		
		
		
	}

	private static void viewInFront(Map<String,Integer> productsShow) {
		
		 String orderedProducts = productsShow.entrySet().stream()
	                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
	                .map(Map.Entry::getKey)
	                .map(Object::toString)
	                .collect(Collectors.joining(","));
		
		 System.out.println(orderedProducts);
	
		
	}


	

}
