package com.kitri.springbasicboot.lesson.mybatis.mappers;


import com.kitri.springbasicboot.lesson.mybatis.dto.RequestTodo;
import com.kitri.springbasicboot.lesson.mybatis.dto.ResponseTodo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 기존 DAO 역할
@Mapper
public interface TodoMapper {
   List<ResponseTodo> findAll();
   ResponseTodo findById(Long id);
   void save(RequestTodo todo);
   void update(RequestTodo todo);
   void deleteById(Long id);
}
