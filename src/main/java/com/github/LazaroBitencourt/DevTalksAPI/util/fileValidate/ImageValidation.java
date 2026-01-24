package com.github.LazaroBitencourt.DevTalksAPI.util;
import org.springframework.web.multipart.MultipartFile;
public interface ImageValidation {
    public void validate(MultipartFile multipartFile);
}
