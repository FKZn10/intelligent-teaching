package com.rainng.coursesystem.controller;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
//负责接收 Python 发来的画面，并且准备好未来发给 Vue 前端
// 🌟 核心：定义 WebSocket 的访问地址
@ServerEndpoint("/api/video-stream")
@Component
public class VideoStreamSocket {

    // 用来存放所有连接进来的客户端（比如 Python 摄像头、或者未来看大屏的 Vue 浏览器）
    private static final CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();

    // 当有客户端连上水管时触发
    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("✅ 新的设备接入视频流！当前连接数: " + sessions.size() + "，ID: " + session.getId());
    }

    // 当有客户端断开水管时触发
    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("❌ 设备断开视频流！当前连接数: " + sessions.size());
    }

    // 🌟 核心引擎：当 Python 通过水管发来一帧画面时触发
    @OnMessage
    public void onMessage(String message, Session session) {
        // message 其实就是 Python 发来的 Base64 图片字符串

        // 我们要做的是“广播”：把这帧画面，原封不动地转发给【其他】所有连在这个管道上的设备（也就是 Vue 前端）
        for (Session s : sessions) {
            // 如果是处于开启状态，并且不是发消息的人自己（不能把画面发回给相机）
            if (s.isOpen() && !s.getId().equals(session.getId())) {
                try {
                    s.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 报错时触发
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("🚨 视频流管道发生异常！");
        error.printStackTrace();
    }
}