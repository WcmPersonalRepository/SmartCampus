package com.gxufe.smarcampus.common.mapper;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * 复制对象属性的工具类.
 * 
 * @author Lingo
 */
public class BeanMapper {
    /** 实例. */
    private static MapperFacade mapper;

    static {
        // 如果src中属性为null，就不复制到dest
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder()
                .mapNulls(false).build();
        // 如果属性是Object，就只复制引用，不复制值，可以避免循环复制
        mapperFactory.getConverterFactory().registerConverter(
                new PassThroughConverter(Object.class));
        mapper = mapperFactory.getMapperFacade();
    }

    /**
     * 把src中的值复制到dest中.
     */
    public void copy(Object src, Object dest) {
        mapper.map(src, dest);
    }

    public <S, D> List<D> copyList(List<S> src, Class<D> clz) {
        return mapper.mapAsList(src, clz);
    }
}
