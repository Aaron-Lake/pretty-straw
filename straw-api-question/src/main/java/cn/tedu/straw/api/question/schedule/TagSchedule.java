package cn.tedu.straw.api.question.schedule;

import cn.tedu.straw.api.question.mapper.TagMapper;
import cn.tedu.straw.api.question.util.RedisUtils;
import cn.tedu.straw.commons.vo.TagVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Slf4j
public class TagSchedule {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    TagMapper tagMapper;


    @Scheduled(fixedRate = 10*1000)
    public void updateRedisTag(){
        log.debug("[{}]准备更新。。。", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        // 在Redis中“标签列表”数据的Key
        String tagListKey = "tags";
        // 删除“标签列表”数据，避免反复增加列表元素，或某些列表元素在MySQL中更新后在Redis中无法处理
        redisUtils.delete(tagListKey);
        // 从数据库中读取新的“标签列表”
        List<TagVO> tags = tagMapper.findAll();
        // 遍历“标签列表”并向Redis中逐一添加数据
        for (TagVO tag : tags) {
            // 向Redis中添加数据
            redisUtils.rightPush(tagListKey, tag);
        }
        log.debug("[{}]更新完毕！", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    }
}
