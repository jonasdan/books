package mybatis.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import mybatis.model.BookAuthor;
import org.mybatis.cdi.Mapper;

@Mapper
public interface BookAuthorMapper {

    int deleteByPrimaryKey(@Param("authorId") int authorId, @Param("bookId") int courseId);
    
    int insert(BookAuthor record);
    
    List<BookAuthor> selectAll();
    
}
