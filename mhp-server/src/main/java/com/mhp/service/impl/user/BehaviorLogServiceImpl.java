package com.mhp.service.impl.user;

import com.mhp.context.BaseContext;
import com.mhp.dto.user.BehaviorLogDTO;
import com.mhp.mapper.user.BehaviorLogMapper;
import com.mhp.service.user.BehaviorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BehaviorLogServiceImpl implements BehaviorLogService {
    @Autowired
    private BehaviorLogMapper behaviorLogMapper;

    @Override
    public void report(BehaviorLogDTO dto) {
        Long studentId = BaseContext.getCurrentId();
        behaviorLogMapper.insert(studentId, dto.getEventType(), dto.getEventData());
    }
}
