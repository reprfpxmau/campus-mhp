package com.mhp.entity;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * 聊天消息实体类
 * INDEX: idx_session_id
 */
@Data
public class CsChatMessage {
    // 主键
    private Long messageId;
    // 会话ID
    private Long sessionId;
    // 发送人ID
    private Long senderId;
    // 消息内容(加密)
    private String content;
    // 发送时间
    private LocalDateTime sendTime;
}
