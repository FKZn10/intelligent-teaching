package com.rainng.coursesystem.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
// 如果前端是不同端口（比如 Vue 的 8080），需要加上 @CrossOrigin 允许跨域请求
@CrossOrigin
public class UploadController {

    @PostMapping("/upload")
    public Map<String, Object> uploadImage(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();

        if (file.isEmpty()) {
            result.put("code", 400);
            result.put("message", "图片不能为空！");
            return result;
        }

        try {
            // 1. 获取当前项目的根目录，并在里面建一个 uploads 文件夹
            String uploadDirPath = System.getProperty("user.dir") + "/uploads/";
            File dir = new File(uploadDirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // 2. 安全提取原图片后缀名
            String originalFilename = file.getOriginalFilename();
            String suffix = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            }

            // 3. 生成 UUID 文件名
            String newFileName = UUID.randomUUID().toString() + suffix;

            // 4. 保存图片到硬盘
            File destFile = new File(dir, newFileName); // 推荐使用这种 File 构造方式拼接路径
            file.transferTo(destFile);

            // 5. 生成网络 URL（假设你的 Spring Boot 运行在 8085 端口）
            String imageUrl = "http://localhost:8085/uploads/" + newFileName;

            result.put("code", 200);
            result.put("message", "图片保存成功！");
            result.put("data", imageUrl);

        } catch (IOException e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("message", "图片保存失败！");
        }

        return result;
    }
}