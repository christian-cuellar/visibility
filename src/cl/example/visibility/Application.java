/**
 * 
 */
package cl.example.visibility;

import java.util.List;
import java.util.Map;

import cl.example.visibility.util.FileUtil;

/**
 * @author ccuellarb
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start, end, time; 
		start = System.currentTimeMillis(); 
		
		
		Map<Integer,Integer> productsMap= FileUtil.getCsvFileToMap("resources/product.csv");
		List<String> sizes= FileUtil.getCsvFile("resources/size.csv");
		Map<Integer, Integer> stocksMap= FileUtil.getCsvFileToMap("resources/stock.csv");
		
		
		Alghoritm.visibility(sizes,productsMap,stocksMap);
		
		end = System.currentTimeMillis();
		time = end - start; 
		
		//System.out.println("Miliseconds :" + time);
		
	}

}
