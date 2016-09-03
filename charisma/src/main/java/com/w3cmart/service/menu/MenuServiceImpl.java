package com.w3cmart.service.menu;

import com.w3cmart.entity.menu.Menu;
import com.w3cmart.entity.menu.MenuCriteria;
import com.w3cmart.mapper.menu.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/8/28.
 */
@Service
public class MenuServiceImpl  implements  MenuService{

    @Resource
    private MenuMapper menuMapper;


    public int addRootMenu(Menu menu) {
        return menuMapper.insert(menu);
    }

    public int updateMenu(Menu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    public int deleteMenu(Long id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    public List<Menu> selectByExample(MenuCriteria menuCriteria) {
        return menuMapper.selectByExample(menuCriteria);
    }

    public List<Menu> selectByUserName(String userName) {
        return menuMapper.selectByUserName(userName);
    }
}
