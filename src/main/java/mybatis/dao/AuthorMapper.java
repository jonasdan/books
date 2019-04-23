package mybatis.dao;

import java.util.List;
import mybatis.model.Author;
import org.mybatis.cdi.Mapper;

@Mapper
public interface AuthorMapper {

    int deleteByPrimaryKey(int id);

    int insert(Author record);

    Author selectByPrimaryKey(int id);

    List<Author> selectAll();

    int updateByPrimaryKey(Author record);

}
