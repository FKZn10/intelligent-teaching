package com.rainng.coursesystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class UploadController {

    // 老师要求的：接收图片并保存
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
                dir.mkdirs(); // 文件夹不存在就创建
            }

            // 2. 提取原图片后缀名 (比如 .jpg, .png)
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

            // 3. 给图片重新起个名字（防止前端传来的重名文件把以前的覆盖掉）
            String newFileName = UUID.randomUUID().toString() + suffix;

            // 4. 真正保存图片到硬盘上！
            File destFile = new File(uploadDirPath + newFileName);
            file.transferTo(destFile);

            // 5. 生成一个可以直接访问的图片 URL 路径（注意：这里不是物理路径，而是网络路径）
            String imageUrl = "http://localhost:8085/uploads/" + newFileName;

            // 返回成功信息和图片的网络地址给前端
            result.put("code", 200);
            result.put("message", "图片保存成功！");
            result.put("data", imageUrl); // 前端拿到这个 url 就可以直接显示图片了，你也可以把它存进数据库

        } catch (IOException e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("message", "图片保存失败！");
        }

        return result;
    }
}