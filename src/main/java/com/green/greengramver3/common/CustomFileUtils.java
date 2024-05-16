package com.green.greengramver3.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
@Getter
public class CustomFileUtils {
    private final String uploadPath;

    public CustomFileUtils(@Value("${file.directory}") String uploadPath){
        this.uploadPath = uploadPath;
    }

    public String makeFolder(String path){
        File folder = new File(uploadPath, path);
        folder.mkdirs();
        return folder.getAbsolutePath();
    }

    public String makeRandomFileName(MultipartFile pic){
        if(pic==null){return null;}
        String fileName = pic.getOriginalFilename();
        return UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
    }

    public void transferTo(MultipartFile pic, String target) throws IOException {
        File saveFile = new File(uploadPath, target);
        pic.transferTo(saveFile);
    }
}
