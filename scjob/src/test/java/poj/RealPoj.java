package poj;

import java.util.Map;

/**
 * @author szh
 * @create 2018-08-12 22:47
 **/
public class RealPoj {
    private String pageNo;

    private String pageSize;

    private Map<String,TestPoj> hrInfoMap;

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, TestPoj> getHrInfoMap() {
        return hrInfoMap;
    }

    public void setHrInfoMap(Map<String, TestPoj> hrInfoMap) {
        this.hrInfoMap = hrInfoMap;
    }
}
