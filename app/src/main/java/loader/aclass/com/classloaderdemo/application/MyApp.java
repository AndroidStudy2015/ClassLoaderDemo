package loader.aclass.com.classloaderdemo.application;

import android.app.Application;
import loader.aclass.com.classloaderdemo.andfix.AndfixPatchManager;

/**
 * 描述当前版本功能
 *
 * @Project: ClassLoaderDemo
 * @author: cjx
 * @date: 2019-08-04 10:19  星期日
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AndfixPatchManager.getInstance().initPatch(this);
    }
}
