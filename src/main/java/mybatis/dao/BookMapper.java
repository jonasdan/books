package mybatis.dao;

import mybatis.model.Book;

import java.util.List;
import org.mybatis.cdi.Mapper;

@Mapper
public interface BookMapper {

    int deleteByPrimaryKey(int id);

    int insert(Book record);

    Book selectByPrimaryKey(int id);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);
    
}
