package edu.neu.csye6200;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.api.AbstractProduct;
import edu.neu.csye6200.api.AbstractTransction;

public class AppleStore {
	
	private List productList = new ArrayList<AbstractProduct>();
	private List transList = new ArrayList<AbstractTransction>();
	
	public void addProduct(AbstractProduct p){
		productList.add(p);
	}
	
	public void addTransction(AbstractTransction t){
		transList.add(t);
	}
	
	public void csv_write(){
		
		String[] products = {"1,iphone,10", 
							 "2,macPro,20", 
							 "3,ipod,30"};
		
		try(BufferedWriter br = new BufferedWriter(new FileWriter("ProductIn.csv")))
		{
			for (String pro : products) {
				br.write(pro);
				br.newLine();
			}
			br.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Demo(){
		
		AppleStore as = new AppleStore();
		
		AbstractProduct pro1 = new HardwareProduct(1,"iphone",10);
		AbstractProduct pro2 = new HardwareProduct(2,"macPro",20);
		AbstractProduct pro3 = new HardwareProduct(3,"ipod",30);
		as.addProduct(pro1);
		as.addProduct(pro2);
		as.addProduct(pro3);
		
		as.csv_write();
		
	}
}
