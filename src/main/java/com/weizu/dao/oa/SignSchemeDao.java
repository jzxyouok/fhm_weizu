package com.weizu.dao.oa;

import com.weizu.pojo.oa.SignSchemeBean;

import java.util.List;

public interface SignSchemeDao {

    /** 查找签到方案 */
    SignSchemeBean findSignSchemeById(SignSchemeBean bean) throws Exception;

    /** 通过条件查找签到方案 */
    List<SignSchemeBean> findSignSchemeByCondition(SignSchemeBean bean) throws Exception;

    /** 插入签到方案 */
    Integer insertSignScheme(SignSchemeBean bean) throws Exception;

    /** 修改签到方案 */
    Integer updateSignScheme(SignSchemeBean bean) throws Exception;

    /** 删除签到方案 */
    void deleteSignScheme(SignSchemeBean bean) throws Exception;

    /** 删除团队下的所有签到方案 */
    void deleteByTeamId(Long teamId) throws Exception;

    /** 批量更新选中状态 */
    void batchUpdateCheckedByCondition(SignSchemeBean bean) throws Exception;
}
