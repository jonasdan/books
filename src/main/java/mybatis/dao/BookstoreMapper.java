package mybatis.dao;

import mybatis.model.Bookstore;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface BookstoreMapper {

    int deleteByPrimaryKey(int id);

    int insert(Bookstore record);

    Bookstore selectByPrimaryKey(int id);

    List<Bookstore> selectAll();

    int updateByPrimaryKey(Bookstore record);
    
}
