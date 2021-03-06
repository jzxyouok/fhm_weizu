package com.weizu.dao.addressBook;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.weizu.pojo.addressBook.AddressLookAuthRequestBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("addressLookAuthDaoImpl")
public class AddressLookAuthDaoImpl  extends DaoSupport implements AddressLookAuthDao{

    @Override
    public Integer insertAuthRequest(AddressLookAuthRequestBean bean) throws Exception {
        return (Integer) this.save("com.weizu.addressLookAuth.insertAuthRequest", bean);
    }

    @Override
    public List<PageData> getAllAuthRequestlistPage(Page page) throws Exception {
        return (List<PageData>) this.findForList("com.weizu.addressLookAuth.getAllAuthRequestlistPage", page);
    }
}
