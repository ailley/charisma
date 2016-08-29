package com.w3cmart.service.user;

import com.w3cmart.entity.Menu;
import com.w3cmart.entity.MenuCriteria;
import com.w3cmart.mapper.MenuMapper;
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
}
