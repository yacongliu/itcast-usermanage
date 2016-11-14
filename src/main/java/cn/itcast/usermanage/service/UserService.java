package cn.itcast.usermanage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.usermanage.bean.EasyUIResult;
import cn.itcast.usermanage.mapper.UserMapper;
import cn.itcast.usermanage.pojo.User;

/**
 * 
 * Title: UserService Description:
 * 
 * @author yacong_liu Email:2682505646@qq.com
 * @date 2016年11月13日
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 
     * Title: queryUserList Description: search user list
     * 
     * @authod yacong_liu
     * @param page
     * @param rows
     */
    public EasyUIResult queryUserList(Integer page, Integer rows) {
        // set page params
        PageHelper.startPage(page, rows);

        // search data
        List<User> users = this.userMapper.select(null);

        // get after pagination infomation
        PageInfo<User> pageInfo = new PageInfo<User>(users);

        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 
     * Title: queryUserById Description: according to user'id search user
     * 
     * @authod yacong_liu
     * @param id
     * @return
     */
    public User queryUserById(Long id) {

        User user = this.userMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 
     * Title: saveUser Description: save user
     * 
     * @authod yacong_liu
     * @return
     */
    public Boolean saveUser(User user) {
        Boolean flag = this.userMapper.insert(user) == 1;
        return flag;
    }

    /**
     * 
     * Title: updateUser Description: update user
     * 
     * @param user
     * 
     * @authod yacong_liu
     * @return
     */
    public Boolean updateUser(User user) {
        Boolean flag = this.userMapper.updateByPrimaryKeySelective(user) == 1;
        return flag;
    }

    /**
     * 
     * Title: deleteUserById Description: delete user by user'id
     * 
     * @authod yacong_liu
     * @param id
     * @return
     */
    public Boolean deleteUserById(Long id) {
        Boolean flag = this.userMapper.deleteByPrimaryKey(id) == 1;
        return flag;
    }

}
