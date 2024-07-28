package com.KrishiKendra.Controller;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.core.io.InputStreamResource; 
import org.springframework.http.HttpHeaders; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.MediaType; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.multipart.MultipartFile; 

@RestController
@RequestMapping("file")
public class FileUploadController {
	
	
	 @PostMapping("/upload")
	    public String uploadFile(@RequestParam("file") MultipartFile file) {
	        // Define the directory and file path
	        String directoryPath = "/Users/abc/Documents/krishikendra/uploads";
	        String originalFileName = file.getOriginalFilename();
	        String filePath = directoryPath + File.separator + originalFileName;

	        System.out.println(filePath);
	        String fileUploadStatus;

	        // Ensure the directory exists
	        File directory = new File(directoryPath);
	        if (!directory.exists()) {
	            if (directory.mkdirs()) {
	                System.out.println("Directory created successfully");
	            } else {
	                System.out.println("Failed to create directory");
	                return "Error in creating directory";
	            }
	        }

	        // Handle the case where a file with the same name already exists
	        File uploadFile = new File(filePath);
	        if (uploadFile.exists()) {
	            String newFileName = UUID.randomUUID().toString() + "_" + originalFileName;
	            filePath = directoryPath + File.separator + newFileName;
	        }

	        try (FileOutputStream fout = new FileOutputStream(filePath)) {
	            // Save the file
	            fout.write(file.getBytes());
	            fileUploadStatus = "File Uploaded Successfully";
	        } catch (IOException e) {
	            e.printStackTrace();
	            fileUploadStatus = "Error in uploading file: " + e.getMessage();
	        }

	        return fileUploadStatus;
	    }
	 
	
	  @RequestMapping(value = "/getFiles", method = RequestMethod.GET) 
	    public String[] getFiles() 
	    { 
//	        String folderPath = System.getProperty("user.dir") +"/Uploads"; 
	        String  folderPath = "/Users/abc/Documents/krishikendra/uploads";
	          
	          // Creating a new File instance 
	        File directory= new File(folderPath); 
	          
	        // list() method returns an array of strings  
	          // naming the files and directories  
	          // in the directory denoted by this abstract pathname 
	        String[] filenames = directory.list(); 
	          
	        // returning the list of filenames 
	        return filenames; 
	          
	    } 
	  
	
	@RequestMapping(value = "/download/{path:.+}", method = RequestMethod.GET) 
    public ResponseEntity<?> downloadFile(@PathVariable("path") String filename) throws FileNotFoundException { 
      
        // Checking whether the file requested for download exists or not 
        String fileUploadpath = System.getProperty("user.dir") +"/Uploads"; 
        String[] filenames = this.getFiles(); 
        boolean contains = Arrays.asList(filenames).contains(filename); 
        if(!contains) { 
            return new ResponseEntity("FIle Not Found", HttpStatus.NOT_FOUND); 
        } 
          
        // Setting up the filepath 
        String filePath = fileUploadpath+File.separator+filename; 
          
        // Creating new file instance 
        File file= new File(filePath); 
          
        // Creating a new InputStreamResource object 
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file)); 
          
        // Creating a new instance of HttpHeaders Object 
        HttpHeaders headers = new HttpHeaders(); 
          
        // Setting up values for contentType and headerValue 
        String contentType = "application/octet-stream"; 
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\""; 
               
        return ResponseEntity.ok() 
                .contentType(MediaType.parseMediaType(contentType)) 
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue) 
                .body(resource);  
          
    } 


}
