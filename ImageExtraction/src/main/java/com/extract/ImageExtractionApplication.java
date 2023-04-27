package com.extract;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aspose.slides.IPPImage;
import com.aspose.slides.Presentation;

@SpringBootApplication
public class ImageExtractionApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ImageExtractionApplication.class, args);
		
		Presentation pres = new Presentation("C:\\Users\\Kiran Mishra\\Downloads\\ppt for project.pptx");

		int n = 1;
		String type = "";
		String path = "C:\\Users\\Kiran Mishra\\Downloads\\Images_";

		for (IPPImage image : pres.getImages()) {
		  
		  type = image.getContentType();
		  type = type.substring(type.indexOf("/") + 1, type.length());

		 
		  try {
		   ImageIO.write(image.getSystemImage(), type, new File (path + n + "." + type.toString()));
		   System.out.println("Image "+n+" saved");
		   
		  } catch (IOException ex) {
		    System.out.println(ex.getMessage());
		  }
		  n++;
		}
	}

}
