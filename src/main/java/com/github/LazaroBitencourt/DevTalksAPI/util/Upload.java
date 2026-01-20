package com.github.LazaroBitencourt.DevTalksAPI.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface UploadImage {
    boolean uploadImage(MultipartFile file, UUID id) throws Exception;
}
