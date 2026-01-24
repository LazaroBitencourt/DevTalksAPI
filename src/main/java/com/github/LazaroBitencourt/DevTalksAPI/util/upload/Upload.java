package com.github.LazaroBitencourt.DevTalksAPI.util.upload;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface Upload {
    String uploadFile(MultipartFile file, UUID id, String diretoryName);
}
