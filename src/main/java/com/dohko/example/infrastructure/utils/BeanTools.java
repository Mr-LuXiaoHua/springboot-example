package com.dohko.example.infrastructure.utils;


import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author luxiaohua
 * @create 2021-09-02 17:01
 */
public class BeanTools {

    public static <T> T copy(Object source, Class<T> target) {
        if (Objects.isNull(source)) {
            return null;
        }
        T t = null;
        try {
            t = target.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(source, t);
        return t;
    }


    public static <T> List<T> copyList(List sourceList, Class<T> target) {

        List<T> targetList = new ArrayList<>();
        if (CollectionUtils.isEmpty(sourceList)) {
            return targetList;
        }

        for (Object o : sourceList) {
            targetList.add(copy(o, target));
        }

        return targetList;
    }


}
