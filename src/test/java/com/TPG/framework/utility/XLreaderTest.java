package com.TPG.framework.utility;

public class XLreaderTest {

	public static void main(String[] args){
//		// TODO Auto-generated method stub
//        try {
//        	XlsReader xls = new XlsReader("src/test/resources/data","TestDataLogin.xlsx");
//			//XlsReader.addSheet("src/test/resources/data/TestDataLogin.xlsx", "TableData");
//            Object[][] obj=null;
//        	obj = xls.readXls( "Login");
//        	for(int i=0;i<4;i++){
//        		for(int j=0;j<2;j++)
//        			System.out.print(obj[i][j]+" ");
//        		System.out.println();
//        	}
//        	xls.addColumn("TableData", "First");
//        	xls.addColumn("TableData", "Second");
//        	xls.addColumn("TableData", "Third");
//        //	xls.addSheet("AccountData");
////        	xls.addColumn("AccountData", "Acc_name");
////        	xls.addColumn("AccountData", "Acc No");
////        	
////        	for(int i=1,j=0; i<2; i++){
////        	
////        	xls.setCellData("AccountData",i, j, "Manu");
////        	xls.setCellData("AccountData",i, ++j, "12345");
////        	
////        	}
////        	for(int i=2; i<5; i++)
////        		for(int j=0;j<2;j++)        			
////    	xls.setCellData("Login",i, j, "one");
////        		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String price = "Rs 12,816";
		int p = Integer.parseInt(price.replaceAll("[ ,a-zA-Z]", ""));
		System.out.println(p);
		
		String str ="Rs 12344";
		System.out.println(str.split("Rs "));

	}}
