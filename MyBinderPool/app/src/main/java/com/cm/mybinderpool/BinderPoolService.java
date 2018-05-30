package com.cm.mybinderpool;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BinderPoolService extends Service {
	public BinderPoolService() {
	}

	Binder binderPool = new BinderPool.BinderPoolImpl();

	@Override
	public IBinder onBind(Intent intent) {
		return binderPool;
	}
}
