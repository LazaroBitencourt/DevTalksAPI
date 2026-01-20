package com.github.LazaroBitencourt.DevTalksAPI.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface Upload {
    String uploadImage(MultipartFile file, UUID id, UploadImpl.DitetoryType ditetoryType) throws Exception;
}
