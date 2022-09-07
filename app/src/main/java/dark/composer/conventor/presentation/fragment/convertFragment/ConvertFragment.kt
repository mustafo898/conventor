package dark.composer.conventor.presentation.fragment.convertFragment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import dark.composer.conventor.databinding.FragmentConvertBinding
import dark.composer.conventor.presentation.fragment.BaseFragment
import dark.composer.conventor.presentation.fragment.adapters.ConvertTypeAdapter
import dark.composer.conventor.presentation.fragment.splash.SplashViewModel

class ConvertFragment : BaseFragment<FragmentConvertBinding>(FragmentConvertBinding::inflate) {
    private val convertTypeAdapter by lazy {
        ConvertTypeAdapter()
    }
    val viewModel: SplashViewModel by viewModels()
    private val REQUEST_CODE = 100

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreate() {
        setUpUi()
        checkPermission()
    }

    private fun setUpUi() {
        binding.convertTypeRcv.adapter = convertTypeAdapter
    }

    @Deprecated("Deprecated in Java")
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        checkPermission()
    }

    fun convertType(){
        

    }
    @RequiresApi(Build.VERSION_CODES.P)
    private fun checkPermission() {
        val permission = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.FOREGROUND_SERVICE
        )
        if (ContextCompat.checkSelfPermission(
                activity?.applicationContext!!,
                permission[0]
            ) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(
                activity?.applicationContext!!,
                permission[1]
            ) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(
                activity?.applicationContext!!,
                permission[2]
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            Log.d("SSSSS", "checkPermission: Otdi")
//            Intent(Intent.ACTION_PICK).also {
//                it.type = "file/*"
//                startActivityForResult(it, REQUEST_CODE)
//            }
        } else {
            ActivityCompat.requestPermissions(requireActivity(), permission, 1)
        }
    }
//
//    @Deprecated("Deprecated in Java")
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK) {
//            if (requestCode == REQUEST_CODE) {
//                val uri = data?.data
//                val imagePath = uri?.let { uploadFile(it, requireContext()) }.toString()
//                Glide.with(this).load(imagePath).into(binding.image)
//                val file = File(imagePath)
//                val requestBody =
//                    RequestBody.create("multipart/form-date".toMediaTypeOrNull(), file)
//                val body = MultipartBody.Part.createFormData("file", file.name, requestBody)
//                viewModel.fileUploadProfile(body)
//            }
//        }
//    }
}