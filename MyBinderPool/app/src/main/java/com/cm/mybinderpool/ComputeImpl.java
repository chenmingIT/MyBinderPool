package com.cm.mybinderpool;

import android.os.RemoteException;

/**
 * Created by ChenMing on 2018/5/30.
 */

public class ComputeImpl extends ICompute.Stub {
	@Override
	public int add(int x, int y) throws RemoteException {
		return x + y;
	}
}
