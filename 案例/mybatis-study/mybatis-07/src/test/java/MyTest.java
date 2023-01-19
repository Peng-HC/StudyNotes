import com.phc.dao.BlogMapper;
import com.phc.pojo.Blog;
import com.phc.utils.IDUtils;
import com.phc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

/**
 * @FileName MyTest.java
 * @Description 动态SQL测试
 * @Author phc
 * @date 2023/1/19 20:49
 * @Version 1.0
 */
public class MyTest {
    @Test
    public void insertDataTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        // 生成一个随机且唯一的ID
        blog.setId(IDUtils.getId());
        blog.setTitle("世界这么大，我想去看看");
        blog.setAuthor("phc");
        blog.setCreateTime(new Date());
        blog.setViews(999999);
        blogMapper.insertData(blog);

        // 生成一个随机且唯一的ID
        blog.setId(IDUtils.getId());
        blog.setTitle("东南大学");
        blog.setAuthor("phw");
        blog.setCreateTime(new Date());
        blog.setViews(666666);
        blogMapper.insertData(blog);
        sqlSession.close();
    }
}