package com.itag.api.server.v1.register.biz;

import com.itag.api.server.v1.register.dao.RegistrationDao;
import com.itag.api.server.v1.register.dao.RegistrationDaoImpl;
import com.itag.api.server.v1.register.dos.RegisterationDo;
import com.itag.api.server.v1.register.dos.UserDo;
import com.itag.api.server.v1.register.model.BaseModel;
import com.itag.api.server.v1.register.model.Registration;

public class RegistrationBOFImpl extends RegistrationBOF {
	public RegistrationDao registerDao;
	
	public RegistrationBOFImpl() {
		registerDao = new RegistrationDaoImpl();
	}
	
	@Override
	public UserBo register(RegistrationBo bo) {
		UserDo user = registerDao.register((RegisterationDo)registerDao.mapBoToDo(bo));
		return (UserBo) registerDao.mapDoToBo(user);
	}

	@Override
	public <T> RegistrationBo mapModelToBo(BaseModel model, Class<T> toClass) {
		return (RegistrationBo) RegistrationModelHelper.mapper((Registration)model, toClass);
	}

	@Override
	public BaseModel mapBoToModel(BaseBo bo) {
		// TODO Auto-generated method stub
		return null;
	}

}
