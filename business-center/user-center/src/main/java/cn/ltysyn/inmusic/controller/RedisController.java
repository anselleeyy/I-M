package cn.ltysyn.inmusic.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

import cn.ltysyn.inmusic.commons.Response;
import cn.ltysyn.inmusic.commons.ReturnCode;
import cn.ltysyn.inmusic.utils.RedisInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping(value = "/admin/redis")
@Api(tags = "管理员 redis 接口类")
public class RedisController {

    @Autowired
    private JedisPool jedisPool;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @GetMapping(value = "/getKeySize")
    @ApiOperation(value = "获取实时key大小")
    public Object getKeySize() {

        Map<String, Object> map = Maps.newHashMapWithExpectedSize(16);
        Jedis jedis = jedisPool.getResource();
        map.put("keySize", jedis.dbSize());
        LocalDateTime now = LocalDateTime.now();
        map.put("time", formatter.format(now));
        if (jedis != null) {
            jedis.close();
        }
        Response response = new Response(ReturnCode.REDIS_KEY_GOT, map);
        return response;
    }

    @GetMapping(value = "/getMemory")
    @ApiOperation(value = "获取实时内存大小")
    public Object getMemory() {

        Map<String, Object> map = Maps.newHashMapWithExpectedSize(16);
        Jedis jedis = jedisPool.getResource();
        String[] strs = jedis.info().split("\n");
        for (String s : strs) {
            String[] detail = s.split(":");
            if ("used_memory".equals(detail[0])) {
                map.put("memory", detail[1].substring(0, detail[1].length() - 1));
                break;
            }
        }
        LocalDateTime now = LocalDateTime.now();
        map.put("time", formatter.format(now));
        if (jedis != null) {
            jedis.close();
        }
        Response response = new Response(ReturnCode.REDIS_MEMORY_GOT, map);
        return response;
    }

    @GetMapping(value = "/info")
    @ApiOperation(value = "获取Redis信息")
    public Object info() {

        List<RedisInfo> infoList = new ArrayList<>();
        Jedis jedis = jedisPool.getResource();
        String[] strs = jedis.info().split("\n");
        for (String str1 : strs) {
            RedisInfo redisInfo = new RedisInfo();
            String[] str = str1.split(":");
            if (str.length > 1) {
                String key = str[0];
                String value = str[1];
                redisInfo.setKey(key);
                redisInfo.setValue(value);
                infoList.add(redisInfo);
            }
        }
        if (jedis != null) {
            jedis.close();
        }
        Response response = new Response(ReturnCode.REDIS_INFO_GOT, infoList);
        return response;
    }

}
