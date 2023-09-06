package com.zlennon.mybatisplus.service.impl;

import com.zlennon.mybatisplus.entity.User;
import com.zlennon.mybatisplus.mapper.UserMapper;
import com.zlennon.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlennon
 * @since 2023-08-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
