package com.cm.mybinderpool;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		new Thread(new Runnable() {
			@Override
			public void run() {
				testBinderPool();
			}
		}).start();
	}

	private void testBinderPool() {
		BinderPool mBinderPool = BinderPool.getInstance(MainActivity.this);
		//测试ICompute
		IBinder mComputeBinder = mBinderPool.queryBinder(BinderPool.BINDER_COMPUTE);
		ICompute mCompute = ICompute.Stub.asInterface(mComputeBinder);
		try {
			Log.i("chenming", "1+2 = " + mCompute.add(1, 2));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		//测试IUser
		IBinder mUserBinder = mBinderPool.queryBinder(BinderPool.BINDER_USER);
		IUser mUser = IUser.Stub.asInterface(mUserBinder);
		try {
			Log.i("chenming", "login " + mUser.login("user", "psd"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
