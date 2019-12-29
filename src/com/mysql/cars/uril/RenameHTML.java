package com.mysql.cars.uril;

import java.io.File;

public class RenameHTML {

	public static void main(String[] args) {
		File  dir=new  File("D:\\JavaeeProjects\\347Cars\\WebContent");
		File[] files=dir.listFiles();
		
		for(File f:files) {
			if(f.isFile()) {
			System.out.println(f.getName());
			System.out.println(f.getName().lastIndexOf("."));
			String lastFliename=f.getName().substring(0,f.getName().lastIndexOf("."));
			f.renameTo(new File(dir,lastFliename+".jsp"));
			}
		}

	}

}
