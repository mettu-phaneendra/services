package com.itag.api.server.v1.register.dao;

import com.itag.api.server.v1.register.biz.BaseBo;
import com.itag.api.server.v1.register.biz.RegistrationBo;
import com.itag.api.server.v1.register.dos.BaseDo;
import com.itag.api.server.v1.register.dos.RegisterationDo;
import com.itag.api.server.v1.register.dos.UserDo;

public abstract class RegistrationDao {
	public abstract UserDo register(RegisterationDo register);

	public abstract RegistrationBo mapDoToBo(BaseDo domain);

	public abstract BaseDo mapBoToDo(BaseBo bo);
}
