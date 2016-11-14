package cn.itcast.usermanage.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import cn.itcast.usermanage.pojo.User;
import cn.itcast.usermanage.service.UserService;

/**
 * 
 * Title: RestUserController Description:
 * 
 * @author yacong_liu Email:2682505646@qq.com
 * @date 2016年11月13日
 */
@RequestMapping("news")
@Controller
public class RestUserController {

    @Resource
    private UserService userService;

    /**
     * 
     * Title: queryUserById Description: according to id search user
     * 
     * @authod yacong_liu
     */
    @RequestMapping(value = "{id}", method = GET)
    public ResponseEntity<User> queryUserById(@PathVariable("id") Long id) {
        User user = this.userService.queryUserById(id);

        try {
            if (null == user) {
                // resources dont't exist response 404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            // resources is exist reponse 200
            return ResponseEntity.ok(user); // easy
            // return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // server exception so reponse 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 
     * Title: saveUser Description: save user
     * 
     * @authod yacong_liu
     * @param user
     * @return
     */
    @RequestMapping(value = "add", method = POST)
    public ResponseEntity<Void> saveUser(User user) {

        Boolean flag = this.userService.saveUser(user);

        try {
            if (flag) {
                // created is success so reponse 201
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // server exception response 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 
     * Title: updateUser Description: update user
     * 
     * @authod yacong_liu
     * @return
     */
    @RequestMapping(method = PUT)
    public ResponseEntity<Void> updateUser(User user) {

        Boolean flag = this.userService.updateUser(user);
        try {
            if (flag) {
                // updated is success so response 204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // server exception response 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 
     * Title: deleteUserById Description: delete user by user'id
     * 
     * @authod yacong_liu
     * @param id
     * @return
     */
    @RequestMapping(method = DELETE)
    public ResponseEntity<Void> deleteUserById(@RequestParam(value = "id", defaultValue = "0") Long id) {
        Boolean flag = this.userService.deleteUserById(id);

        try {
            if (id.longValue() == 0) {
                // dont't transfer param id, response 400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            if (flag) {
                // deleted is success so response 204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // server exception response 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
