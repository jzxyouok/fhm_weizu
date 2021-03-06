package com.weizu.dao.addressBook;

import java.util.List;

import com.weizu.pojo.addressBook.WeChatAPPBean;
import org.springframework.stereotype.Repository;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.weizu.pojo.addressBook.AddressLookBean;

@Repository("addressLookDaoImpl")
public class AddressLookDaoImpl  extends DaoSupport implements AddressLookDao{

	@Override
	public AddressLookBean findAddressLookById(AddressLookBean bean) throws Exception {
		return (AddressLookBean) this.findForObject("com.weizu.addressLook.findAddressLookById", bean);
	}

	@Override
	public Integer inserAddressLook(AddressLookBean bean) throws Exception {
		return (Integer) this.save("com.weizu.addressLook.inserAddressLook", bean);
	}

	@Override
	public Integer updateAddressLook(AddressLookBean bean) throws Exception {
		return (Integer) this.update("com.weizu.addressLook.updateAddressLook", bean);
	}

	@Override
	public void deleteAddressLook(AddressLookBean bean) throws Exception {
		this.delete("com.weizu.addressLook.deleteAddressLook", bean);
	}

	@Override
	public List<AddressLookBean> getAllAddressLook(WeChatAPPBean bean) throws Exception {
		return (List<AddressLookBean>) this.findForList("com.weizu.addressLook.getAllAddressLook", bean);
	}

	@Override
	public List<PageData> getAllAddressLookListPage(Page page) throws Exception {
		return (List<PageData>) this.findForList("com.weizu.addressLook.getAllAddressLooklistPage", page);
	}

	@Override
	public List<AddressLookBean> findAddressLookByCondition(AddressLookBean bean)
			throws Exception {
		return (List<AddressLookBean>) this.findForList("com.weizu.addressLook.findAddressLookByCondition", bean);
	}

}
