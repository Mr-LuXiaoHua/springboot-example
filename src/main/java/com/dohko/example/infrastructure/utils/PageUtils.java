package com.dohko.example.infrastructure.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dohko.example.infrastructure.common.model.vo.PageVO;

import java.util.List;

/**
 * @author luxiaohua
 * @create 2021-09-08 11:32
 */
public class PageUtils {

    /**
     * 转换成PageVO
     * @param page
     * @param target
     * @param <T>
     * @return
     */
    public static <T> PageVO<T> toPageVO(Page page, Class<T> target) {
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setCurrent(page.getCurrent());
        pageVO.setPages(page.getPages());
        pageVO.setTotal(page.getTotal());
        pageVO.setSize(page.getSize());

        List<T> recordList = BeanTools.copyList(page.getRecords(), target);
        pageVO.setRecordList(recordList);

        return pageVO;
    }
}
