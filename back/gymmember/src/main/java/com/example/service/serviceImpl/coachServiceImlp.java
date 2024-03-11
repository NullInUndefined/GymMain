package com.example.service.serviceImpl;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.example.dao.coachDao;
import com.example.model.coach;
import com.example.service.coachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.example.utils.RedisConstants.*;


@Service
public class coachServiceImlp implements coachService {

    @Autowired
    private coachDao coaDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public coach redisfindone(String id){
        //这些代码是不添加缓存击穿函数时使用的，现在这些代码已经被封装进queryWithPassThrough函数里了
//        String key = CACHE_COACH_KEY + id;
//        //1 从redis查询教练缓存
//        String coachJson = stringRedisTemplate.opsForValue().get(key);
//        //2 判断是否存在
//        if(StrUtil.isNotBlank(coachJson)){
//        //3 存在直接返回
//            coach coa = JSONUtil.toBean(coachJson, coach.class);
//            return  coa;
//        }
//        //缓存击穿：判断命中是否为空值
//        if(coachJson != null){
//            //返回错误信息
//            return null;
//        }
//
//        //4 不存在，根据id查询数据库
//        coach coa = coaDao.findCoachById(id);
//            //5 不存在，防止缓存击穿
//        if(coa == null){
//            //5.1 将空值写入redis
//            stringRedisTemplate.opsForValue().set(key, "", CACHE_NULL_TTL, TimeUnit.MINUTES);
//            //5.2 返回null
//            return null;
//        }
//            //6 存在，写入redis
//        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(coa), CACHE_COACH_TTL, TimeUnit.MINUTES);
//        //7 返回
//        return coa;

        //缓存穿透
//        coach coa = queryWithPassThrough(id);

        //用互斥锁解决缓存击穿
        coach coa = queryWithMutex(id);

        return coa;
    }

    public coach queryWithMutex(String id) {
        String key = CACHE_COACH_KEY + id;
        //1 从redis查询教练缓存
        String coachJson = stringRedisTemplate.opsForValue().get(key);
        //2 判断是否存在
        if (StrUtil.isNotBlank(coachJson)) {
            //3 存在直接返回
            return JSONUtil.toBean(coachJson, coach.class);

        }
        //缓存击穿：判断命中是否为空值
        if (coachJson != null) {
            //返回错误信息
            return null;
        }
        //4 实现缓存重建
        //4.1 获取互斥锁
        String lockKey = "lock:shop:" + id;
        coach coa = null;
        try {
            boolean isLock = tryLock(lockKey);
            //4.2 判断是否获取成功
            if (isLock) {
                //4.3 失败，则休眠并重试
                Thread.sleep(50);
                queryWithMutex(id);
            }

            //4.4 成功，则根据id查询数据库
            coa = coaDao.findCoachById(id);
            //5 不存在，防止缓存击穿
            if (coa == null) {
                //5.1 将空值写入redis
                stringRedisTemplate.opsForValue().set(key, "", CACHE_NULL_TTL, TimeUnit.MINUTES);
                //5.2 返回null
                return null;
            }
            //6 存在，写入redis
            stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(coa), CACHE_COACH_TTL, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //7 释放互斥锁
            unlock(lockKey);
        }
        //8 返回
        return coa;
    }

    public coach queryWithPassThrough(String id){
        String key = CACHE_COACH_KEY + id;
        //1 从redis查询教练缓存
        String coachJson = stringRedisTemplate.opsForValue().get(key);
        //2 判断是否存在
        if(StrUtil.isNotBlank(coachJson)){
            //3 存在直接返回
            return JSONUtil.toBean(coachJson, coach.class);

        }
        //缓存击穿：判断命中是否为空值
        if(coachJson != null){
            //返回错误信息
            return null;
        }

        //4 不存在，根据id查询数据库
        coach coa = coaDao.findCoachById(id);
        //5 不存在，防止缓存击穿
        if(coa == null){
            //5.1 将空值写入redis
            stringRedisTemplate.opsForValue().set(key, "", CACHE_NULL_TTL, TimeUnit.MINUTES);
            //5.2 返回null
            return null;
        }
        //6 存在，写入redis
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(coa), CACHE_COACH_TTL, TimeUnit.MINUTES);
        //7 返回
        return coa;
    }

    //定义声明锁和释放锁的方法
    private boolean tryLock(String key){
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", 10, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(flag);
    }

    private void unlock(String key){
        stringRedisTemplate.delete(key);
    }

    @Transactional
    @Override
    public int redisupdate (coach coa){
        String id = coa.getCoachid();
        if(id == null){
            return 0;// 0 表示失败
        }
        //1 更新数据库
        coaDao.update(coa);
        //2 删除缓存
        stringRedisTemplate.delete(CACHE_COACH_KEY + coa.getCoachid());

        return 1;
    }

    @Override
    public List<coach> findAll() {
        return coaDao.findAllCoaches();
    }

    @Override
    public coach findone(String id) {
        return coaDao.findCoachById(id);
    }

    @Override
    public int insert(coach coa) {
        return coaDao.insert(coa);
    }

    @Override
    public int update(coach coa) {
        return coaDao.update(coa);
    }

    @Override
    public int delete(String id) {
        return coaDao.delete(id);
    }
}

