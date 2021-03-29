{{tf.packageName}}

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cms.entity.{{tf.BigclassName}};

public interface {{tf.BigclassName}} {
	
	List<{{tf.BigclassName}}> getTbUsers(@Param("pageIndex") int pageIndex, @Param("PageRows") int PageRows);

    int add{{tf.BigclassName}}({{tf.BigclassName}} data);

    int del{{tf.BigclassName}}(@Param("id") int id);

    int up{{tf.BigclassName}}({{tf.BigclassName}} data);

    {{tf.BigclassName}} get{{tf.BigclassName}}(@Param("id") Integer {{tf.PRI.COLUMN_NAME}});
    
    int get{{tf.BigclassName}}Count(); 
}
