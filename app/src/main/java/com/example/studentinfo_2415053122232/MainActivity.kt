package com.example.studentinfo_2415053122232

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
// Sửa dòng dưới thành tên package của bạn + .databinding.ActivityMainBinding
import com.example.studentinfo_2415053122232.databinding.ActivityMainBinding

// --- YÊU CẦU 3: MODEL LƯU TRỮ ---
data class Student(
    val mssv: String,
    val name: String,
    val className: String,
    val age: Int,
    val score: Double
)

// --- YÊU CẦU 4 & 6 (MÃ CHẴN): EXTENSION FUNCTION XỬ LÝ TRẠNG THÁI ---
// Mở rộng kiểu Double để tự động tính ra chữ "Đạt" hoặc "Chưa đạt"
fun Double.toPassStatus(): String {
    return if (this >= 5.0) "Đạt" else "Chưa đạt"
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Tạo đối tượng Model (Yêu cầu 5: Dữ liệu cá nhân)
        val myInfo = Student(
            mssv = "2415053122232",
            name = "Trương Văn Quang",
            className = "Công nghệ Thông tin",
            age = 20, // Bạn có thể sửa tuổi thực tế
            score = 8.5
        )

        // 2. Gán dữ liệu từ Model lên Giao diện
        binding.tvMssv.text = "MSSV: ${myInfo.mssv}"
        binding.tvName.text = "Họ tên: ${myInfo.name}"
        binding.tvClass.text = "Lớp: ${myInfo.className}"
        binding.tvAge.text = "Tuổi: ${myInfo.age}"
        binding.tvScore.text = "Điểm: ${myInfo.score}"

        // Sử dụng Extension Function để lấy trạng thái Đạt/Chưa đạt
        binding.tvStatus.text = "Trạng thái: ${myInfo.score.toPassStatus()}"
    }
}