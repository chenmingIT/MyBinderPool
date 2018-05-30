package com.cm.mybinderpool;

import android.os.RemoteException;

/**
 * Created by ChenMing on 2018/5/30.
 */

public class UserImpl extends IUser.Stub {
	@Override
	public boolean login(String username, String password) throws RemoteException {
		return true;
	}
}
