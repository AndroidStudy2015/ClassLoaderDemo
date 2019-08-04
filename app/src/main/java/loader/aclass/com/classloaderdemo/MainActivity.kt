package loader.aclass.com.classloaderdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import loader.aclass.com.classloaderdemo.andfix.AndfixPatchManager
import java.io.File

class MainActivity : AppCompatActivity() {


    var mPatchDir = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        printClassLoder()


        setListener()

    }

    private fun setListener() {

        create_bug.setOnClickListener {
            Utils.printBug(this)

        }


        fix_bug.setOnClickListener {
            AndfixPatchManager.getInstance().addPatch(getPatchName())

        }
    }

    private fun getPatchName(): String? {


        return mPatchDir + "cjx.apatch"
    }

    private fun mkdir() {

        mPatchDir = "/storage/sdcard/Download/"

//        创建存放补丁的文件夹
        val file = File(mPatchDir)
        Log.e("cjx",mPatchDir+file.exists())

        if (!file.exists()) {
            val mkdir = file.mkdir()

        }
    }


    private fun printClassLoder() {
        //        打印所有的ClassLoader
        mkdir()

        var classLoader = classLoader

        if (classLoader != null) {

            Log.e("cjx", "ClassLoader---$classLoader")

            while (classLoader.parent != null) {

                classLoader = classLoader.parent

                Log.e("cjx", "ClassLoader---$classLoader")
            }
        }
    }
}
