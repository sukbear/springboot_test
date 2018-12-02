package cn.test.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {
	private static String UPLOADED_FOLDER = "D:\\file\\";
	@GetMapping("/")
	public String index() {
		return "upload";
	}
	@PostMapping("/upload")
	public String singleFileUpload (@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes){
		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "sb");
			return "redirect:uploadStatus";
		}
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            //Path path = Paths.get(file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:uploadStatus";
	}
	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		 return "uploadStatus";
	}
}
