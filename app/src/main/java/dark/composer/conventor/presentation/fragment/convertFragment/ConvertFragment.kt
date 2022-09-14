package dark.composer.conventor.presentation.fragment.convertFragment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import dark.composer.conventor.databinding.FragmentConvertBinding
import dark.composer.conventor.presentation.fragment.BaseFragment
import dark.composer.conventor.presentation.fragment.adapters.ConvertTypeAdapter
import dark.composer.conventor.presentation.fragment.dto.ConvertTypeDTO
import dark.composer.conventor.presentation.fragment.splash.SplashViewModel
import okhttp3.internal.addHeaderLenient
import java.io.File


class ConvertFragment : BaseFragment<FragmentConvertBinding>(FragmentConvertBinding::inflate) {
    private val convertTypeAdapter by lazy {
        ConvertTypeAdapter()
    }
    val viewModel: SplashViewModel by viewModels()
    private val REQUEST_CODE = 100

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreate() {
        setUpUi()
//        checkPermission()
    }

    private fun setUpUi() {
        binding.convertTypeRcv.adapter = convertTypeAdapter
        convertTypeAdapter.setFile(setItem())
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            convertTypeAdapter.setFile(getWord(Environment.getExternalStorageDirectory()))
//        }
//        Toast.makeText(requireContext(), "${convertTypeAdapter.itemCount}", Toast.LENGTH_SHORT).show()
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

            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "*/*"
            val mimetypes = arrayOf(
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                "application/msword"
            )
            intent.putExtra(Intent.EXTRA_MIME_TYPES, mimetypes)
            startActivityForResult(intent, REQUEST_CODE)
        } else {
            ActivityCompat.requestPermissions(requireActivity(), permission, 1)
        }
    }

    private fun setItem(): List<ConvertTypeDTO> {
        val list = mutableListOf<ConvertTypeDTO>()
        list.add(ConvertTypeDTO(0, "word", "Word to Pdf"))
        list.add(ConvertTypeDTO(1, "pdf", "Pdf to Word"))
        return list
    }

    private fun getWord(file: File): List<File> {
        val list = mutableListOf<File>()
        val files = file.listFiles()

        files?.let {
            for (singleFile: File in files) {
                if (singleFile.isDirectory && !singleFile.isHidden) {
                    list.addAll(getWord(singleFile))
//                    Toast.makeText(requireContext(), "File", Toast.LENGTH_SHORT).show()
                } else {
                    if (singleFile.name.endsWith(".pdf")) {
                        list.add(singleFile)
                        Toast.makeText(requireContext(), "${list.size}", Toast.LENGTH_SHORT).show()
                    }
                    Toast.makeText(requireContext(), singleFile.canonicalPath, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        return list
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