package loader.aclass.com.classloaderdemo.andfix;

import android.content.Context;
import com.alipay.euler.andfix.patch.PatchManager;
import loader.aclass.com.classloaderdemo.Utils;

import java.io.IOException;

/**
 * 描述当前版本功能
 *
 * @Project: ClassLoaderDemo
 * @author: cjx
 * @date: 2019-08-04 10:08  星期日
 */
public class AndfixPatchManager {

    private static AndfixPatchManager mInstance = null;
    private static PatchManager mPatchManager = null;

    public static AndfixPatchManager getInstance() {

        if (mInstance == null) {

            synchronized (AndfixPatchManager.class) {
                if (mInstance == null) {
                    mInstance = new AndfixPatchManager();
                }
            }

        }

        return mInstance;

    }

    /**
     * 初始化andfix
     *
     * @param context
     */
    public void initPatch(Context context) {
        mPatchManager = new PatchManager(context);
        mPatchManager.init(Utils.getVersionName(context));
        mPatchManager.loadPatch();

    }

    /**
     * 加载Patch文件
     *
     * @param path
     */
    public void addPatch(String path) {
        if (mPatchManager != null) {
            try {
                mPatchManager.addPatch(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
