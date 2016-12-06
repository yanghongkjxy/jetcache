/**
 * Created on  13-09-17 11:26
 */
package com.alicp.jetcache.anno.config.beans;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.testsupport.DynamicQuery;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:yeli.hl@taobao.com">huangli</a>
 */
@Component("testBean")
public class TestBean {

    private int count = 0;


    public TestBean() {
    }

    public int noCacheCount(){
        return count++;
    }

    @Cached
    public int count() {
        return count++;
    }

    @Cached(enabled = false)
    public int countWithDisabledCache(){
        return count++;
    }

    @Cached(area = "A1", cacheType = CacheType.BOTH)
    public int count(DynamicQuery q) {
        return count++;
    }

    @Cached(condition = "mvel{bean('configBean').trueProp}")
    public int countEnabledWithConfigBean(){
        return count++;
    }

    @Cached(condition = "mvel{bean('configBean').falseProp}")
    public int countDisabledWithConfigBean(){
        return count++;
    }

    @Cached(condition = "mvel{xxx('configBean').trueProp}")
    public int countWithWrongCondition(){
        return count++;
    }

    @Cached(condition = "mvel{args[0]}")
    public int count(boolean useCache){
        return count++;
    }

    @Cached(name="n1")
    public int namedCount1_WithNameN1(){
        return count++;
    }

    @Cached(name="n1")
    public int namedCount2_WithNameN1(){
        return count++;
    }

    @Cached(name="n2")
    public int namedCount_WithNameN2(){
        return count++;
    }
}
